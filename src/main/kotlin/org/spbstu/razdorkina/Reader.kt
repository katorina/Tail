package org.spbstu.razdorkina
interface Reader {
    fun read(fileNames: List<String>, count: Int): String
}