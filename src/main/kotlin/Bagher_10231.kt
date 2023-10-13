import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val inputs = mutableListOf<String>()
    for (i in 0..4) {
        inputs.add(scanner.nextLine())
    }
    val output = inputs.mapIndexed { index, input ->
        if (input.contains("MOLANA") || input.contains("HAFEZ"))
            index + 1
        else null
    }.filterNotNull().joinToString(" ")
    if (output.isNotBlank())
        println(output)
    else println("NOT FOUND!")
}