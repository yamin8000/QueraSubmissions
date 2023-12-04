import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.nio.file.Paths

private const val base = "https://quera.org/problemset/"

private const val cppPath = "cpp"
private const val goPath = "go"
private const val pythonPath = "python"
private const val javaPath = "src/main/java"
private const val kotlinPath = "src/main/kotlin"
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
    codes["Kotlin"] = getLanguageCodes(kotlinPath, "kt").filterNot { it.contains("ReadmeBuilder") }
    codes["Other"] = getLanguageCodes(othersPath, "")

    val output = buildString {
        appendLine(init.trim())
        appendLine()
        appendLine("| Code | Quera Link | Quera name | Language |")
        appendLine("|-|-|-|-|")
        codes.forEach { language ->
            language.value.forEach { code ->
                val name = code.substringAfterLast('/')
                val number = code.substringAfter('_').substringBefore('.')
                val farsiName = getTitle("$base$number")
                appendLine("| [$name]($code) | [$number]($base$number) | $farsiName | ${language.key} |")
            }
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

private fun getTitle(
    url: String
): String {
    println("Getting $url title")
    return (client.newCall(Request.Builder().url(url).build())
        .execute()
        .body
        ?.string()
        ?.substringAfter("<title>")
        ?.substringBefore("</title>")
        ?.split("|")
        ?.first()
        ?.replace("\u200F", "")
        ?.trim())
        ?: ""
}