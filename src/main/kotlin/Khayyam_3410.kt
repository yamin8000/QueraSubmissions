fun main() {
    val n = (readlnOrNull() ?: "0").toInt()
    val nums = mutableListOf<List<Int>>()

    for (i in 1..n) {
        val line = mutableListOf<Int>()
        for (j in 1..i) {
            if (j == 1 || j == i)
                line.add(1)
            else {
                val previousLine = nums.drop(1).last()
                line.add(previousLine[j - 1] + previousLine[j - 2])
            }
        }
        nums.add(line)
    }
    nums.forEach { line ->
        println(line.joinToString(" "))
    }
}