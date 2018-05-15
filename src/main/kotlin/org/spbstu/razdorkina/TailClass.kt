package org.spbstu.razdorkina
/**
 * Checking what flags do we have from an original string
 * @param args are parts of an original string
 *
 * Then choosing what strategy do we need to take
 */
fun main(args: Array<String>): Unit {
    val inputData = ArgsParser(args.toList()).parse()

    val reader: Reader = when {
        inputData.fileNames.isEmpty() && inputData.useLines -> ConsoleReaderByLine()
        inputData.fileNames.isEmpty() && !inputData.useLines -> ConsoleReaderBySymbol()
        inputData.fileNames.isNotEmpty() && inputData.useLines -> FileReaderByLine()
        inputData.fileNames.isNotEmpty() && !inputData.useLines -> FileReaderBySymbol()
        else -> throw Exception("Wrong arguments")
    }
    val result = reader.read(inputData.fileNames, inputData.count)

    val writer: Writer = if (inputData.outFileName != null) FileWriter(inputData.outFileName) else ConsoleWriter()
    writer.write(result)
}