package oscarblancarte.ipd.command.impl

import java.io.OutputStream

class MemoryCommand(override val commandName: String?) : BaseCommand() {
    override fun execute(args: Array<String?>?, out: OutputStream?) {
        val heap = Runtime.getRuntime().totalMemory() / 1000000.0
        val heapMax = Runtime.getRuntime().maxMemory() / 1000000.0
        val heapFree = Runtime.getRuntime().freeMemory() / 1000000.0
        val salida = "Heap: $heap\nMax Heap: $heapMax\nFree Heap: $heapFree"
        write(out!!, salida)
    }

    companion object {
        private val field: String
            get() {
                TODO()
            }
        val COMMAN_NAME: String
            get() {
                TODO()
            }
        const val commandName = "memory"
    }
}