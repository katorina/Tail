package org.spbstu.razdorkina

import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.*
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import java.io.RandomAccessFile
import java.io.IOException


class FileReaderBySymbol : Reader {
    /**
     * Reading text from the file line by line and return last symbols
     * @param fileNames are input files
     * @param count is a number for "c" flag
     * @return last "c" symbols
     */
    override fun read(fileNames: List<String>, count: Int): String {
        val symbols = ArrayDeque<Char>()
        val lines = ArrayDeque<String>()
        val result = mutableListOf<String>()
        for (file in fileNames) {
            val reader = RandomAccessFile(file, "r")
            val size = File(file).length()
            var i = size - 1
            while (i >= 0 && size - i <= count) {
                reader.seek(i)
                val c = reader.read()
                if (c == -1) break
                symbols.add(c.toChar())
                i--
            }
            lines.add(symbols.toTypedArray().joinToString(""))
            symbols.clear()
            if (fileNames.size > 1) lines.add("$file\n".reversed())
            result.add(lines.toTypedArray().joinToString(""))
            result += "\n"
            lines.clear()
        }
        result.removeAt(result.size - 1)
        return result.toTypedArray().joinToString("").reversed()

    }
}