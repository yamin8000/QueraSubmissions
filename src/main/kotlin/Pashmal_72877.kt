fun main() {
    val inputs = readlnOrNull()
    if (inputs != null) {
        val (n, k, p) = inputs.split(' ').map { it.toFloat() }
        println((n * k * p).toInt())
    }
}