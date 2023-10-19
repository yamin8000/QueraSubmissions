import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLine().toInt()
    val correct = scanner.nextLine()
    val input = scanner.nextLine()
    var x = 0
    correct.forEachIndexed { index, c ->
        if (c != input[index])
            x++
    }
    println(x)
}