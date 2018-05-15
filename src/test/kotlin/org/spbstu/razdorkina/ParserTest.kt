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
        val parser = ArgsParser(listOf("-c", "5", "source.txt", "source2.txt"))
        var data = parser.parse()
        assertFalse(data.useLines)
        assertEquals(listOf("source.txt", "source2.txt"), data.fileNames)
        assertTrue(data.count == 5)
        val parser2 = ArgsParser(listOf("source.txt"))
        data = parser2.parse()
        assertTrue(data.count == 10)

        assertFails {
            ArgsParser(listOf("input/source.txt", "-c", "6", "-n", "5")).parse()
        }
    }
}