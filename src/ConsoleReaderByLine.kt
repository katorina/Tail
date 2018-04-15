
import java.util.*


class ConsoleReaderByLine: IReader {
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
        val firstIndex = lines.size - count
        return lines.subList(firstIndex, lines.size).toTypedArray().joinToString("\n")
    }
}