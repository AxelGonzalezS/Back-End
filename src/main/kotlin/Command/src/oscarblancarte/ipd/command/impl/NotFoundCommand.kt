package oscarblancarte.ipd.command.impl

import java.io.OutputStream

class NotFoundCommand(override val commandName: String?) : BaseCommand() {
    override fun execute(args: Array<String?>?, out: OutputStream?) {
        write(out!!, "Command not found")
    }

    companion object {
        private val field: String
            get() {
                TODO()
            }
        const val commandName = "NOT FOUND"
    }
}
