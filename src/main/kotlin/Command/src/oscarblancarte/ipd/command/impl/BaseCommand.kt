package oscarblancarte.ipd.command.impl

import Command.src.oscarblancarte.ipd.command.ICommand
import java.io.OutputStream

abstract class BaseCommand : ICommand {
    abstract override val commandName: String?
    abstract override fun execute(args: Array<String>, out: OutputStream?)
    fun write(out: OutputStream, message: String) {
        try {
            out.write(message.toByteArray())
            out.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

