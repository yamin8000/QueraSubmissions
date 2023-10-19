import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLine().toInt()
    val names = mutableListOf<String>()
    repeat(n) { names.add(scanner.nextLine()) }
    println(names.map { it.toSet() }
        .reduce { acc, chars ->
            if (chars.size > acc.size) chars else acc
        }.size
    )
}