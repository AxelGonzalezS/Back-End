package oscarblancarte.ipd.command

import Command.src.oscarblancarte.ipd.command.ICommand
import oscarblancarte.ipd.command.impl.BatchCommand
import oscarblancarte.ipd.command.impl.DateTimeCommand
import oscarblancarte.ipd.command.impl.DirCommand
import oscarblancarte.ipd.command.impl.EchoCommand
import oscarblancarte.ipd.command.impl.ErrorCommand
import oscarblancarte.ipd.command.impl.ExitCommand
import oscarblancarte.ipd.command.impl.FileCommand
import oscarblancarte.ipd.command.impl.MemoryCommand
import oscarblancarte.ipd.command.impl.NotFoundCommand
import oscarblancarte.ipd.command.impl.WaitAndSayHello
import java.util.*

class CommandManager private constructor() {
    init {
        registCommand(EchoCommand.Companion.COMMAN_NAME, EchoCommand::class.java)
        registCommand(DirCommand.Companion.COMMAND_NAME, DirCommand::class.java)
        registCommand(DateTimeCommand.Companion.COMMAND_NAME, DateTimeCommand::class.java)
        registCommand(MemoryCommand.Companion.COMMAN_NAME, MemoryCommand::class.java)
        registCommand(FileCommand.Companion.COMMAND_NAME, FileCommand::class.java)
        registCommand(ExitCommand.Companion.COMMAND_NAME, ExitCommand::class.java)
        registCommand(BatchCommand.Companion.COMMAND_NAME, BatchCommand::class.java)
        registCommand(WaitAndSayHello.Companion.COMMAND_NAME, WaitAndSayHello::class.java)
    }

    fun getCommand(commandName: String?): ICommand? {
        return if (COMMANDS.containsKey(commandName!!.uppercase(Locale.getDefault()))) {
            try {
                COMMANDS[commandName.uppercase(Locale.getDefault())]!!.newInstance()
            } catch (e: Exception) {
                e.printStackTrace()
                ErrorCommand("")
            }
        } else {
            NotFoundCommand("")
        }
    }

    fun registCommand(commandName: String, command: Class<out ICommand?>) {
        COMMANDS[commandName.uppercase(Locale.getDefault())] = command
    }

    companion object {
        fun getIntance() {

        }

        private var commandManager: CommandManager? = null
        private val COMMANDS: HashMap<String, Class<out ICommand?>> = HashMap<String, Class<out ICommand?>>()

        @get:Synchronized
        val intance: CommandManager?
            get() {
                if (commandManager == null) {
                    commandManager = CommandManager()
                }
                return commandManager
            }
    }
}