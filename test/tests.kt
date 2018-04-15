import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class tests {

    @Test
    fun checkArgsParser() {
        val parser = ArgsParser()

        val data = parser.parse(arrayOf("fileN", "input/source.txt", "c", "8"))
        assertFalse(data.useLines)
        assertEquals(data.fileName, "input/source.txt")
        assertTrue(data.count == 8)

        val data2 = parser.parse(arrayOf())
        assertTrue(data2.count == 10)

        assertFails {
            parser.parse(arrayOf("fileN", "input/source.txt", "c", "6", "n", "5"))
        }
    }

    @Test
    fun checkConsoleReaderBySymbol() {
        val reader = ConsoleReaderBySymbol()

        val lines = ArrayList<String>()
        lines.add("1")
        lines.add("234")
        lines.add("5678")
        val result = reader.getResult(lines, 5)

        assertEquals(result, "45678")
    }

    @Test
    fun checkFileWriter() {
        val fileNames = ArrayList<String>()
        fileNames.add("output.txt")

        val writer = FileWriter(fileNames)
        writer.write("Test Text" +
                "\n" +
                "Next Line")

        val text = ArrayList<String>()
        for (line in File("output.txt").readLines()) {
            text.add(line)
        }
        val result = text.joinToString("\n")
        assertEquals(result, "Test Text\nNext Line")
    }
}