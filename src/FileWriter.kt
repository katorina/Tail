import java.io.File

class FileWriter(private val fileNames: List<String>): IWriter {
    override fun write(text: String) {
        for (fileName in fileNames) {
            val outputStream = File(fileName).bufferedWriter()
            outputStream.write(text)
            outputStream.close()
        }
    }
}