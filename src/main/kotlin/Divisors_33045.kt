import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLine().toInt()
    val divisors = mutableListOf<Int>()
    for (i in 1..n) {
        divisors.addAll(getDivisors(i))
    }
    println("${divisors.size} ${divisors.sum()}")
}

fun getDivisors(n: Int): List<Int> {
    val list = mutableListOf<Int>()
    for (i in 1..n) {
        if (n % i == 0)
            list.add(i)
    }
    return list
}