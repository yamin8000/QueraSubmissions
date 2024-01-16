fun main() {
    val k = readlnOrNull()?.toInt()
    val password = readlnOrNull()
    if (k != null && password != null) {
        var sum = 0
        for (i in 0 until k) {
            val wheel = readlnOrNull()
            if (wheel != null) {
                val position = wheel.indexOf(password[i])
                sum += if (position <= 4) position else 9 - position
            }
        }
        println(sum)
    }
}