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
        val lines = mutableListOf<String>()
        var lineNew: String

        while (input.hasNextLine()) {
            lineNew = input.nextLine()
            if (lineNew.isEmpty()) {
                break
            }
            if (lines.size == count)
                lines.removeAt(0)
            lines.add(lineNew)
        }

        return getResult(lines, count)
    }

    fun getResult(lines: List<String>, count: Int): String {
        val text = lines.toTypedArray().joinToString("\n")
        val firstIndex = lines.size - count
        return lines.subList(firstIndex, lines.size).toTypedArray().joinToString("\n")
    }
}