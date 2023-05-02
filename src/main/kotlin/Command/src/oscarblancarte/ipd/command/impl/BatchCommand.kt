package oscarblancarte.ipd.command.impl

import oscarblancarte.ipd.command.CommandManager
import oscarblancarte.ipd.command.CommandUtil
import Command.src.oscarblancarte.ipd.command.ICommand
import java.io.File
import java.io.FileInputStream
import java.io.OutputStream
import java.util.*


class BatchCommand(override val commandName: String?) : BaseCommand() {
    override fun execute(args: Array<String>, out: OutputStream?) {
        if (args.isNullOrEmpty()) {
            write(out!!, "Insufficient arguments")
            return
        }
        val manager: Unit = CommandManager.getIntance()
        val lines = readLinesFromFile(args[0])
        for (line in lines) {
            val argsCommand: Array<String?> = CommandUtil.tokenizerArgs(line)
            val command: ICommand? = manager!!.getCommand(argsCommand[0])
            val reduce = Arrays.copyOfRange(argsCommand, 1, argsCommand.size)
            command!!.execute(reduce, out)
            write(out!!, "\n")
        }
        write(out!!, "Batch executed")
    }

    @Throws(RuntimeException::class)
    private fun readLinesFromFile(filePath: String?): Array<String> {
        val file = File(filePath)
        var stream: FileInputStream? = null
        return try {
            if (!file.exists()) {
                throw RuntimeException("File not Found")
            }
            stream = FileInputStream(file)
            val byteArray = ByteArray(stream.available())
            stream.read(byteArray)
            val commands = String(byteArray)
            commands.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray<String>()
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        } finally {
            try {
                stream!!.close()
            } catch (e2: Exception) {
            }
        }
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
        const val commandName = "batch"
    }
}
private fun Any.getCommand(s: String?): ICommand? {

    return TODO("Provide the return value")
}

