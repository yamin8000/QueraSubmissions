import java.util.*

fun main() {
    val fibs = listOf(1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
    val n = Scanner(System.`in`).nextLine().toInt()
    for (i in 1..n) {
        if (i in fibs) print('+') else print('-')
    }
}