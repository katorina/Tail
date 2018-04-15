import java.util.*

class ConsoleReaderBySymbol: IReader {
    override fun read(filename: String?, count: Int): String {
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
        val text = lines.toTypedArray().joinToString("")
        val firstIndex = text.length - count
        return text.substring(firstIndex, text.length)
    }
}