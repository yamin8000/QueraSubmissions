import java.util.Scanner

fun main() {
    val coordinates = Scanner(System.`in`).nextLine().split(' ')
    val mostapha = coordinates.subList(0, 2)
    val boss = coordinates.subList(2, 4)
    when {
        mostapha[0] == boss[0] -> println("Vertical")
        mostapha[1] == boss[1] -> println("Horizontal")
        else -> println("Try again")
    }
}