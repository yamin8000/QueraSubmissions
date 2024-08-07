import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.random.Random
import kotlin.random.nextInt

private const val base = "https://quera.org/problemset/"

private const val cppPath = "cpp"
private const val goPath = "go"
private const val pythonPath = "python"
private const val javaPath = "src/main/java"
private const val kotlinPath = "src/main/kotlin"
private const val rustPath = "rust/main_cargo/src"
private const val othersPath = "other"

private val current = Paths.get("").toAbsolutePath().toString()

private val client = OkHttpClient.Builder().build()

private const val init = """# Quera Submissions
    
This repo is a compilation of my submissions to [Quera.org](https://quera.org) questions.
"""

private fun main() {
    val codes = mutableMapOf<String, List<String>>()
    codes["C++"] = getLanguageCodes(cppPath).map { it.replaceFirst("cpp", "CPP") }
    codes["Golang"] = getLanguageCodes(goPath)
    codes["Python"] = getLanguageCodes(pythonPath, "py")
    codes["Java"] = getLanguageCodes(javaPath, "java").filterNot { it.contains("Main.java") }
    codes["Kotlin"] = getLanguageCodes(kotlinPath, "kt")
    codes["Rust"] = getLanguageCodes(rustPath, "rs").filterNot { it.contains("main.rs") }
    codes["Other"] = getLanguageCodes(othersPath, "")

    val output = buildString {
        appendLine(init.trim())
        appendLine()
        appendLine("| Code | Quera Link | Quera name | Language |")
        appendLine("|-|-|-|-|")
        val lines = mutableMapOf<Int, String>()
        codes.forEach { entry ->
            entry.value.forEach { code ->
                runBlocking {
                    val name = code.substringAfterLast('/')
                    val number = code.substringAfterLast('_').substringBefore('.')

                    print("Getting title for: ${entry.key}:${name} ->")

                    val farsiName = findTitle("$base$number")
                    println(farsiName)

                    lines[number.toInt()] = "| [$name]($code) | [$number]($base$number) | $farsiName | ${entry.key} |"
                    delay(Random.nextInt(100..500).toLong())
                }
            }
        }
        lines.toSortedMap().forEach {
            appendLine(it.value)
        }
    }

    val file = File("README.md")
    file.createNewFile()
    file.writeText(output)
}

private fun getLanguageCodes(
    path: String,
    suffix: String = path
): List<String> {
    return listOf(*((File("$current/$path").listFiles()
        ?.filterNotNull()
        ?.filter { it.name.endsWith(suffix) }
        ?: listOf()).toTypedArray()))
        .mapNotNull { it.absolutePath }
        .map { it.removePrefix(current) }
        .map { it.replace("\\", "/") }
}

private suspend fun findTitle(
    url: String
): String {
    createTempDirectory()

    val file = File("temp/${url.substringAfterLast('/')}")
    if (!file.exists()) {
        val title = getTitle(url)

        withContext(Dispatchers.IO) { file.createNewFile() }
        file.writeText(title)

        if (title.trim().contains("Wait... What?")) {
            println("Blocked, waiting...")
            delay(Random.nextInt(1000..5000).toLong())
            return findTitle(url)
        }
        return title
    } else return file.readText()
}

private fun createTempDirectory() {
    val tempPath = "temp"
    try {
        val temp = File(tempPath)
        if (temp.exists()) {
            if (temp.isFile) {
                temp.delete()
                Files.createDirectory(Paths.get(tempPath))
            }
        } else Files.createDirectory(Paths.get(tempPath))
    } catch (e: Exception) {
        println(e.message)
    }
}

private fun getTitle(
    url: String
): String {
    println("Getting $url title")
    return (client.newCall(Request.Builder().url(url).build())
        .execute()
        .body
        .string()
        .substringAfter("<title>")
        .substringBefore("</title>")
        .split("|")
        .first()
        .replace("\u200F", "")
        .trim())
}