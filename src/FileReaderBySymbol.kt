import java.io.File

class FileReaderBySymbol : IReader {
    /**
     * Reading text from the file line by line and return last symbols
     * @param fileName is input file
     * @param count is a number for "c" flag
     * @return last "c" symbols
     */
    override fun read(fileName: String?, count: Int): String {
        var text = ""
        for (line in File(fileName).readLines()) {
            text += line + "\n"
        }

        val endIndex = text.lastIndex
        val startIndex = Math.max(endIndex - count, 0)
        return text.substring(startIndex, endIndex)
    }
}