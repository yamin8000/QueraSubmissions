fun main() {
    val n = readlnOrNull()?.toIntOrNull()
    val aArray = readlnOrNull()?.split(' ')?.mapNotNull { it.toIntOrNull() }
    val bArray = readlnOrNull()?.split(' ')?.mapNotNull { it.toIntOrNull() }
    if (aArray != null && bArray != null) {
        var sum = 0
        aArray.forEachIndexed { index, i ->
            sum += i * bArray[index]
        }
        println(sum)
    }
}