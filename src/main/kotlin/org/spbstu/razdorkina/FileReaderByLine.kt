package org.spbstu.razdorkina

import java.io.File
import java.io.RandomAccessFile
import java.util.ArrayDeque

class FileReaderByLine : Reader {
    /**
     * Reading text from the file line by line and return last lines
     * @param fileNames is input files
     * @param count is a number for "n" flag
     * @return last "n" lines
     */
    override fun read(fileNames: List<String>, count: Int): String {
        val lines = ArrayDeque<String>()
        val result = mutableListOf<String>()

        for (file in fileNames) {
            var str = StringBuilder()
            val reader = RandomAccessFile(file,"r")
            val size = File(file).length()
            var i = size - 1
            var line = 0
            loop@ while(i >= 0 && line < count){
                reader.seek(i)
                val c = reader.read()
                when(c) {
                    -1 -> {
                        lines.add(str.toString())
                        break@loop
                    }
                    '\n'.toInt() -> {
                        line++
                        lines.add(str.toString())
                        str = StringBuilder()
                    }
                    '\r'.toInt() -> {
                        i--
                        continue@loop
                    }
                }
                str.append(c.toChar())
                i--
            }
            lines.add(str.toString())
            if (count == lines.size) lines.add("\n")
            if (fileNames.size > 1) {
                lines.add(file.reversed())
            }
            result.add(lines.toTypedArray().joinToString("").reversed())
            result += "\n"
            lines.clear()
        }
        result.removeAt(result.size - 1)
        return result.toTypedArray().joinToString("")
    }
}
