import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.SystemOutRule
import org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream
import org.spbstu.razdorkina.*
import kotlin.test.assertEquals


class ReaderTests {

    private val file1 = "src/test/resources/input/source.txt"
    private val file2 = "src/test/resources/input/source2.txt"

    @Rule
    @JvmField
    val systemOut = SystemOutRule().enableLog()

    @Rule
    @JvmField
    val systemIn = emptyStandardInputStream()

    @Test
    fun checkFileReaderByLine() {
        val reader = FileReaderByLine()
        val files = listOf(file1, file2)
        val result = "$file1\n123\n1234\n12345\n$file2\nkotlin1\nkotlin2\nkotlin3"
        assertEquals(result, reader.read(files, 3))
    }

    @Test
    fun checkFileReaderBySymbols() {
        val reader = FileReaderBySymbol()
        val file = listOf(file1, file2)
        assertEquals("$file2\nn3\n$file1\n45", reader.read(file, 2))
    }

    @Test
    fun checkConsoleReaderByLine() {
        val reader = ConsoleReaderByLine()
        systemIn.provideLines("12345", "123", "1")
        ConsoleWriter().write(reader.read(listOf(), 2))
        assertEquals("123" + System.lineSeparator() + "1" + System.lineSeparator(), systemOut.log)
    }

    @Test
    fun checkConsoleReaderBySymbol() {
        val reader = ConsoleReaderBySymbol()
        systemIn.provideLines("1", "234", "5678")
        ConsoleWriter().write(reader.read(listOf(), 5))
        assertEquals("\n5678\n" + System.lineSeparator(), systemOut.log)
    }
}