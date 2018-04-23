package org.spbstu.razdorkina
import java.io.File
import java.util.*

class FileReaderBySymbol : Reader {
    /**
     * Reading text from the file line by line and return last symbols
     * @param fileNames are input files
     * @param count is a number for "c" flag
     * @return last "c" symbols
     */
    override fun read(fileNames: List<String>, count: Int): String {
        val lines = ArrayList<String>()

        for (file in fileNames) {
            for (line in File(file).readLines()) {
                if (lines.toTypedArray().joinToString("").length >= count) lines.removeAt(0)
                lines.add(line)
            }
        }

        val result = lines.toTypedArray().joinToString("\n")
        val endIndex = result.lastIndex + 1
        val startIndex = Math.max(endIndex - count, 0)
        return result.substring(startIndex, endIndex)
    }
}