import java.util.Scanner

fun main() {
    val days = listOf("shanbe", "1shanbe", "2shanbe", "3shanbe", "4shanbe", "5shanbe", "jome")
    val schedules = mutableSetOf<String>()

    val scanner = Scanner(System.`in`)
    while (scanner.hasNextLine()) {
        val line = scanner.nextLine()
        if (line.toIntOrNull() == null)
            schedules.addAll(line.split(' '))
    }
    val nist = days.toMutableList()
    nist.removeAll(schedules)
    println(nist.size)
}