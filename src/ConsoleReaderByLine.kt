import java.util.*

class ConsoleReaderByLine : IReader {
    /**
     * Reading data by console and returning last lines
     * @param fileName is ignored
     * @param count is a number for "n" flag
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
        val firstIndex = lines.size - count
        return lines.subList(firstIndex, lines.size).toTypedArray().joinToString("\n")
    }
}