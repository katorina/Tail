package org.spbstu.razdorkina
import java.util.*

class ConsoleReaderByLine : Reader {
    /**
     * Reading data by console and returning last lines
     * @param fileNames is ignored
     * @param count is a number for "n" flag
     * @return last lines in console
     */
    override fun read(fileNames: List<String>, count: Int): String {
        val input = Scanner(System.`in`)
        val lines = ArrayDeque<String>()
        var lineNew: String

        while (input.hasNextLine()) {
            lineNew = input.nextLine()
            if (lineNew.isEmpty()) {
                break
            }
            if (lines.size == count)
                lines.removeFirst()
            lines.add(lineNew)
        }
        return getResult(lines, count)
    }

    fun getResult (lines: ArrayDeque<String>, count: Int): String {
        return lines.toTypedArray().joinToString(System.lineSeparator())
    }

}