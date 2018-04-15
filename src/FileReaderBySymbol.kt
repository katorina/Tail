import java.io.File

class FileReaderBySymbol: IReader {
    override fun read(fileName: String?, count: Int): String {
        var text = ""
        for (line in File(fileName).readLines()) {
            text += line + "\n"
        }

        // todo handle startIndex < 0
        val endIndex = text.lastIndex
        val startIndex = endIndex - count
        return  text.substring(startIndex, endIndex)
    }
}