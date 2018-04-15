class ConsoleWriter: IWriter {
    override fun write(text: String) {
        println(text)
    }
}