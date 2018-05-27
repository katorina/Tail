package org.spbstu.razdorkina

import java.io.BufferedReader
import java.util.*
import java.util.ArrayList
import java.util.ArrayDeque
import java.util.Deque


class ConsoleReaderBySymbol : Reader {
    /**
     * Reading data by console and returning last symbols
     * @param fileNames is ignored
     * @param count is a number for "c" flag
     * @return last lines in console
     */
    override fun read(fileNames: List<String>, count: Int): String {
        val input = Scanner(System.`in`)
        val deque = ArrayDeque<Char>()
        var lineNew: String
        var num = count
        var win = false

        while (input.hasNextLine()) {
            lineNew = input.nextLine()
            if (lineNew.isEmpty()) {
                break
            }
            for (char in lineNew) {
                if (char == '\r') win = true
                deque.add(char)
                if (deque.size >= num) deque.removeFirst()
            }
            deque.addLast('\n')
            if (win) {
                num += 2
                deque.addLast('\r')
            } else num++
        }
        deque.removeLast()
        return deque.toTypedArray().joinToString("")
    }

}
