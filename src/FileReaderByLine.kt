import java.io.File

class FileReaderByLine: IReader {
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