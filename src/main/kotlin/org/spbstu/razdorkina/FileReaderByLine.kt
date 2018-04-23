package org.spbstu.razdorkina
import java.io.File

class FileReaderByLine : Reader {
    /**
     * Reading text from the file line by line and return last lines
     * @param fileNames is input files
     * @param count is a number for "n" flag
     * @return last "n" lines
     */
    override fun read(fileNames: List<String>, count: Int): String {
        val text = mutableListOf<String>()

        for (fileName in fileNames) {
            for (line in File(fileName).readLines()) {
                if (text.size == count)
                    text.removeAt(0)
                text.add(line)
            }
        }

        val firstIndex = text.size - count
        return text.subList(firstIndex, text.size).toTypedArray().joinToString("\n")
    }
}

