import java.io.File

class FileReaderByLine : IReader {
    /**
     * Reading text from the file line by line and return last lines
     * @param fileName is input file
     * @param count is a number for "n" flag
     * @return last "n" lines
     */
    override fun read(fileName: String?, count: Int): String {
        val text = ArrayList<String>()
        for (line in File(fileName).readLines()) {
            text.add(line)
        }

        val firstIndex = text.size - count
        var result = ""
        for (i in firstIndex..text.lastIndex) {
            result += text[i] + "\n"
        }
        return result
    }
}