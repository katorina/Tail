package org.spbstu.razdorkina
import org.junit.*
import org.junit.Assert.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Tests {

    @Test
    fun checkArgsParser() {
        val parser = ArgsParser()

        val data = parser.parse(arrayOf("fileN", "src/test/resources/input/source.txt", "c", "8"))
        assertFalse(data.useLines)
        assertEquals(listOf("src/test/resources/input/source.txt"), data.fileNames)
        assertTrue(data.count == 8)

        val data2 = parser.parse(arrayOf())
        assertTrue(data2.count == 10)

        assertFails {
            parser.parse(arrayOf("fileN", "input/source.txt", "c", "6", "n", "5"))
        }
    }

}