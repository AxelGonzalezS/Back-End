package Command.src.oscarblancarte.ipd.command

import java.io.OutputStream

interface ICommand {
    val commandName: String?
    fun execute(args: Array<String>, out: OutputStream?)
}