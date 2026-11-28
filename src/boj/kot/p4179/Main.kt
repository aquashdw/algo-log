// https://acmicpc.net/problem/4179
package boj.kot.p4179

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.IntStream


var n: Int? = null
var m: Int? = null
val deltas = listOf(
    arrayOf(0, -1),
    arrayOf(-1, 0),
    arrayOf(0, 1),
    arrayOf(1, 0),
)

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val size = reader.readLine().split(" ")
        .map { s -> s.toInt() }
        .toIntArray()
    n = size[0]
    m = size[1]

    val room = Array(n!!) { CharArray(m!!) }
    IntStream.range(0, n!!).forEach { i ->
        room[i] = reader.readLine().toCharArray()
    }

    val startPoint = intArrayOf(-1, -1)
    val firePoints = ArrayDeque<IntArray>()

    for (i in room.indices) {
        val row = room[i]
        for (j in row.indices) {
            when (row[j]) {
                'J' -> {
                    startPoint[0] = i
                    startPoint[1] = j
                }

                'F' -> firePoints.add(intArrayOf(i, j))
            }
        }
    }

    var turns = 0
    var success = false
    var pNextQueue = ArrayDeque<IntArray>()
    pNextQueue.add(startPoint)

    var fNextQueue = firePoints
    while (pNextQueue.isNotEmpty()) {
        val pNowQueue = pNextQueue
        pNextQueue = ArrayDeque()
        while (pNowQueue.isNotEmpty()) {
            val now = pNowQueue.removeFirst()
            if (room[now[0]][now[1]] == 'F') continue
            for (delta in deltas) {
                val nextY = now[0] + delta[0]
                val nextX = now[1] + delta[1]

                if (!checkBounds(nextY, nextX)) {
                    success = true
                    break
                }

                if (room[nextY][nextX] in "#JF") continue
                pNextQueue.add(intArrayOf(nextY, nextX))
                room[nextY][nextX] = 'J'
            }
        }
        turns++
        if (success) break
        val fNowQueue = fNextQueue
        fNextQueue = ArrayDeque()

        while (fNowQueue.isNotEmpty()) {
            val now = fNowQueue.removeFirst()
            for (delta in deltas) {
                val nextY = now[0] + delta[0]
                val nextX = now[1] + delta[1]

                if (!checkBounds(nextY, nextX) || room[nextY][nextX] in "#F") continue
                fNextQueue.add(intArrayOf(nextY, nextX))
                room[nextY][nextX] = 'F'
            }
        }
    }
    println(if (success) turns else "IMPOSSIBLE")
}

fun checkBounds(y: Int, x: Int): Boolean {
    return y in 0..<n!! && x in 0..<m!!
}
