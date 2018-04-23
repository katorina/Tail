package org.spbstu.razdorkina
import java.io.File

/**
 * Writing a result in output file
 */
class FileWriter(private val outFileName: String) : Writer {
    override fun write(text: String) {
        val outputStream = File(outFileName).bufferedWriter()
        outputStream.write(text)
        outputStream.close()
    }
}