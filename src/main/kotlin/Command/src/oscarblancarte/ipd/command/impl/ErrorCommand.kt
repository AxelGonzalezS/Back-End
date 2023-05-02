package oscarblancarte.ipd.command.impl

import java.io.OutputStream

class ErrorCommand(override val commandName: String?) : BaseCommand() {
    override fun execute(args: Array<String?>?, out: OutputStream?) {
        val message = "Invocation error"
        write(out!!, message)
    }

    companion object {
        private val field: String
            get() {
                TODO()
            }
        const val commandName = "ERROR"
    }
}