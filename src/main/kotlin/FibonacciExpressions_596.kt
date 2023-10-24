import java.util.Scanner

val fibs = mutableMapOf<ULong, ULong>()
fun main() {
    fibs[1UL] = 1UL
    val scanner = Scanner(System.`in`)
    var n = scanner.nextLine().toULong()
    var i = 1UL
    while (fib(i) <= n) {
        i++
    }
    i--
    val builder = StringBuilder()
    while (n > 0UL) {
        val temp = fib(i)
        val tempI = i
        i--
        if (n >= temp) {
            builder.append("$tempI ")
            n -= temp
        } else continue
    }
    println(builder.toString().trim())
}

fun fib(n: ULong): ULong {
    return if (n == 0UL || n == 1UL) 1UL
    else {
        val output = fibs[n] ?: (fib(n - 1UL) + fib(n - 2UL))
        fibs[n] = output
        return output
    }
}