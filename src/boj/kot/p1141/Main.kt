// https://acmicpc.net/problem/1141
package boj.kot.p1141

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    val words = reader.useLines { lines ->
        lines
            .take(n)
            .sortedByDescending { it.length }
            .toList()
    }

    val selected = mutableListOf<String>()
    for (word in words) {
        if (selected.any { str -> str.startsWith(word) }) continue
        selected.add(word)
    }
    println(selected.size)
}
