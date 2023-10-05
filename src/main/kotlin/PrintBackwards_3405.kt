import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val list = mutableListOf<Int>()
    var current: Int
    do {
        current = scanner.nextInt()
        list.add(current)
    } while (current != 0)
    list.removeLast()
    list.reversed().forEach { println(it) }
}