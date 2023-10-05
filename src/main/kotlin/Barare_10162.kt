import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val k = scanner.nextInt()
    if (k % 2 == 0) println("Bala Barare") else println("Payin Barare")
}