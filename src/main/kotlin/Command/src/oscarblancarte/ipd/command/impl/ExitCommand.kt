package oscarblancarte.ipd.command.impl

import Command.src.oscarblancarte.ipd.command.ICommand
import java.io.OutputStream
import kotlin.system.exitProcess

abstract class ExitCommand : ICommand {
    override fun execute(args: Array<String?>?, out: OutputStream?) {
        exitProcess(0)
    }

    companion object {
        val COMMAND_NAME: String
            get() {
                TODO()
            }
        private val field: String
            get() {
                TODO()
            }
        const val commandName = "exit"
    }
}