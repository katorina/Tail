fun main(args: Array<String>): Unit {
    val inputData = ArgsParser().parse(args)

    val reader:IReader = when {
        inputData.fileName == null && inputData.useLines -> ConsoleReaderByLine()
        inputData.fileName == null && !inputData.useLines -> ConsoleReaderBySymbol()
        inputData.fileName != null && inputData.useLines -> FileReaderByLine()
        inputData.fileName != null && !inputData.useLines -> FileReaderBySymbol()
        else -> throw Exception("Wrong arguments")
    }
    val result = reader.read(inputData.fileName, inputData.count)

    val writer:IWriter = if (inputData.outFileNames.isNotEmpty()) FileWriter(inputData.outFileNames) else ConsoleWriter()
    writer.write(result)
}