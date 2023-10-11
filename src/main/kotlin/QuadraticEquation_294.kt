import java.util.Scanner
import kotlin.math.sqrt

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextFloat()
    val b = scanner.nextFloat()
    val c = scanner.nextFloat()

    val x1: Float
    val x2: Float
    val delta = delta(a, b, c)
    if (a != 0f && b != 0f) {
        if (delta == 0f) {
            x1 = -1f * b / a * .5f
            printForQuera(x1)
        } else if (delta > 0) {
            x1 = ((-1f * b) + sqrt(delta)) / a * .5f
            x2 = ((-1f * b) - sqrt(delta)) / a * .5f
            printAscending(x1, x2)
        } else println("IMPOSSIBLE")
    } else {
        if (b == 0f) {
            if (c == 0f) printForQuera(0f)
            else if (a < 0 && c > 0) printAscending(sqrt(c / a), -1f * sqrt(c / a))
            else if (a > 0 && c < 0) printAscending(sqrt(c / a), -1f * sqrt(c / a))
            else println("IMPOSSIBLE")
        } else printForQuera(-1f * c / b)
    }
}

fun delta(a: Float, b: Float, c: Float) = (b * b) + (-4 * a * c)

fun Float.format() = "%.3f".format(this)

fun printAscending(x1: Float, x2: Float) {
    if (x1.isNaN() || x2.isNaN()) {
        println("IMPOSSIBLE")
    } else if (x1 == x2) {
        printForQuera(x1)
    } else if (x1 < x2) {
        printForQuera(x1)
        printForQuera(x2)
    } else {
        printForQuera(x2)
        printForQuera(x1)
    }
}

fun printForQuera(x: Float) {
    if (x == 0f) println("0.000")
    else println(x.format())
}