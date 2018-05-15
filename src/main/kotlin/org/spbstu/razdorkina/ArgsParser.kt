package org.spbstu.razdorkina

import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.Option
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser


class ArgsParser(args: List<String>) {
    /**
     * Parsing and checking arguments
     * @param args array of original arguments
     * @return InputData with fileName, count for a flag, using or not lines and outFileName parameters
     */
    @Option(name = "-c", usage = "Last lines number")
    private var c = -1

    @Option(name = "-n", usage = "Last symbols number")
    private var n = -1

    @Option(name = "-o", usage = "Output file name")
    private var outFileName: String? = null

    @Argument(usage = "Input files names")
    private var fileNames: MutableList<String> = mutableListOf()

    init {
        val parser = CmdLineParser(this)
        try {
            parser.parseArgument(args)
        } catch (e: CmdLineException) {
            System.err.println(e.message)
            parser.printUsage(System.err)
        }
        if (c != -1 && n != -1) {
            throw Exception("Wrong c, n arguments")
        }
        if (c == -1 && n == -1) {
            n = 10
        }
    }

    fun parse(): InputData {
        val count = if (n > 0) n else c
        val useLines = n > 0

        return InputData(fileNames, count, useLines, outFileName)
    }
}