import org.junit.Test
import org.spbstu.razdorkina.ConsoleWriter
import org.spbstu.razdorkina.FileWriter
import java.io.File
import kotlin.test.assertEquals

class WriterTests {

    @Test
    fun checkConsoleWriter() {
        val writer = ConsoleWriter()
        writer.write("9764316497")

        val result = "9764316497"
        assertEquals(result, "9764316497")
    }

    @Test
    fun checkFileWriter() {
        val fileName = "output.txt"

        val writer = FileWriter(fileName)
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