import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val names = mutableMapOf<String, Int>()
    val n = scanner.nextLine().toInt()
    repeat(n) {
        val input = scanner.nextLine().split(' ').first()
        if (names.containsKey(input)) {
            names[input] = (names[input] ?: 0) + 1
        } else names[input] = 1
    }
    println(names.values.max())
}