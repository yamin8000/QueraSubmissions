import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine().split(' ')
    val n = input.first().toInt()
    val name = input.last()
    println(
        buildString {
            repeat(n) {
                append("copy of ")
            }
            append(name)
        }
    )
}