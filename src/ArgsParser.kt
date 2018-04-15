class ArgsParser {
    fun parse(args: Array<String>): InputData {
        var fileName: String? = null
        val outFileNames: MutableList<String> = ArrayList<String>()
        var c = 0
        var n = 0

        var i = 0
        while (i < args.lastIndex) {
            when (args[i]) {
                "fileN" -> {
                    fileName = args[i + 1]
                }
                "c" -> {
                    c = args[i + 1].toInt()
                }
                "n" -> {
                    n = args[i + 1].toInt()
                }
                "o" -> {
                    for (k in i+1..args.lastIndex) {
                        outFileNames.add(args[k])
                    }
                }
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

        return InputData(fileName, count, useLines, outFileNames)
    }
}