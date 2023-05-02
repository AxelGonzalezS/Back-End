package oscarblancarte.ipd.command.impl

import java.io.OutputStream
import java.util.*

class EchoCommand(override val commandName: String?) : BaseCommand() {
    override fun execute(args: Array<String?>?, out: OutputStream?) {
        val message: String = commandName + " " + Arrays.toString(args)
        write(out!!, message)
    }

    companion object {
        private val field: String = ""
        val COMMAN_NAME: String
            get() {
                TODO()
            }
        const val commandName = "echo"
    }
}