import org.junit.Test
import org.spbstu.razdorkina.ConsoleReaderByLine
import org.spbstu.razdorkina.ConsoleReaderBySymbol
import org.spbstu.razdorkina.FileReaderByLine
import org.spbstu.razdorkina.FileReaderBySymbol
import kotlin.test.assertEquals

class ReaderTests {

    @Test
    fun checkFileReaderByLine() {
        val reader = FileReaderByLine()
        val files = listOf("src/test/resources/input/source.txt", "src/test/resources/input/source2.txt")

        val result = "1234\n12345\nkotlin1\nkotlin2\nkotlin3"
        assertEquals(result, reader.read(files, 5))
    }

    @Test
    fun checkFileReaderBySymbols() {
        val reader = FileReaderBySymbol()
        val file = listOf("src/test/resources/input/source.txt")

        assertEquals("45", reader.read(file, 2))
    }

    @Test
    fun checkConsoleReaderByLine() {
        val reader = ConsoleReaderByLine()

        val lines = ArrayList<String>()
        lines.add("12345")
        lines.add("123")
        lines.add("1")
        val result = reader.getResult(lines, 2)

        assertEquals("123\n1", result)
    }

    @Test
    fun checkConsoleReaderBySymbol() {
        val reader = ConsoleReaderBySymbol()

        val lines = ArrayList<String>()
        lines.add("1")
        lines.add("234")
        lines.add("5678")
        val result = reader.getResult(lines, 5)

        assertEquals("\n5678", result)
    }
}