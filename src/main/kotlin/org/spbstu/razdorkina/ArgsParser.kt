package org.spbstu.razdorkina

import java.util.*

class ArgsParser {
    /**
     * Parsing and checking arguments
     * @param args array of original arguments
     * @return InputData with fileName, count for a flag, using or not lines and outFileName parameters
     */
    fun parse(args: Array<String>): InputData {
        val fileNames: MutableList<String> = ArrayList<String>()
        var outFileName: String? = null

        var c = 0
        var n = 0

        var i = 0
        while (i < args.lastIndex) {
            when (args[i]) {
                "fileN" -> {
                    for (k in i + 1..args.lastIndex) {
                        if (args[k] == "n" || args[k] == "c" || args[k] == "o") break
                        fileNames.add(args[k])

                    }
                }
                "c" -> c = args[i + 1].toInt()
                "n" -> n = args[i + 1].toInt()
                "o" -> outFileName = args[i + 1]
            }
            i++
        }

        if (c != 0 && n != 0) {
            throw Exception("Wrong c, n arguments")
        }

        if (c == 0 && n == 0) {
            n = 10
        }

        val count = if (n > 0) n else c
        val useLines = n > 0

        return InputData(fileNames, count, useLines, outFileName)
    }
}