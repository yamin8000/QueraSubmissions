import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val x = scanner.nextLine().toInt()
    when (val n = scanner.nextLine().toInt()) {
        0 -> println(20)
        7 -> println(x)
        else -> {
            var out = x - n
            if (out < 0) out = 0
            println(out)
        }
    }
}