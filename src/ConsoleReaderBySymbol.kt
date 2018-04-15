import java.util.*

class ConsoleReaderBySymbol : IReader {
    /**
     * Reading data by console and returning last symbols
     * @param fileName is ignored
     * @param count is a number for "c" flag
     * @return last lines in console
     */
    override fun read(fileName: String?, count: Int): String {
        val input = Scanner(System.`in`)
        val lines = ArrayList<String>()
        var lineNew: String

        while (input.hasNextLine()) {
            lineNew = input.nextLine()
            if (lineNew.isEmpty()) {
                break
            }
            lines.add(lineNew)
        }
        return getResult(lines, count)
    }

    fun getResult(lines: List<String>, count: Int): String {
        val text = lines.toTypedArray().joinToString("")
        val firstIndex = text.length - count
        return text.substring(firstIndex, text.length)
    }
}