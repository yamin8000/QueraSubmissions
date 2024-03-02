package yamin

import java.math.RoundingMode
import java.text.DecimalFormat

private fun main() {
    var (n, vTotal) = readln().split(' ').map { it.toDouble() }
    var hIvIs = mutableListOf<Pair<Double, Double>>()
    for (i in 0 until n.toLong()) {
        val input = readln().split(' ').map { it.toDouble() }
        hIvIs.add(input.first() to input.last())
    }
    hIvIs = hIvIs.sortedByDescending { it.first / it.second }.toMutableList()
    var output = 0.0
    hIvIs.forEach { (h, v) ->
        if (vTotal >= v) {
            output += h
            vTotal -= v
        } else {
            output += vTotal * h / v
        }
    }
    val format = DecimalFormat("#.#")
    //format.roundingMode = RoundingMode.CEILING
    println(format.format(output))
}