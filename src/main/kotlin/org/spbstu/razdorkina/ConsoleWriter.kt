/**
 * Writing a result in console
 */
package org.spbstu.razdorkina
class ConsoleWriter : Writer {
    override fun write(text: String) {
        println(text)
    }
}