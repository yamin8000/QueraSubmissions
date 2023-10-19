import java.math.BigInteger
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextLine()
    val operation = scanner.nextLine()
    val b = scanner.nextLine()

    if (operation == "+") println(sum(a, b)) else println(product(a, b))
}

fun sum(a: String, b: String) = BigInteger(a).plus(BigInteger(b)).toString()

fun product(a: String, b: String) = BigInteger(a).times(BigInteger(b)).toString()
