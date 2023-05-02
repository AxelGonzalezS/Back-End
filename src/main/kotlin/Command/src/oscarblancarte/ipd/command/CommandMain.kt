package oscarblancarte.ipd.command

import oscarblancarte.ipd.command.CommandManager
import oscarblancarte.ipd.command.CommandUtil
import Command.src.oscarblancarte.ipd.command.ICommand
import java.util.*




object CommandMain {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Command Line is Start")
        val manager: Unit = CommandManager.getIntance()
        val `in` = Scanner(System.`in`)
        while (true) {
            val line = `in`.nextLine()
            if (line.trim { it <= ' ' }.isEmpty()) {
                continue
            }
            val commands: Array<String> = CommandUtil.tokenizerArgs(arrayOf(line))
            val commandName = commands[0]
            var commandArgs: Array<String> = arrayOf("uno","dos")
            if (commands.size > 1) {
                commandArgs = Arrays.copyOfRange(commands, 1, commands.size)
            }
            val command: ICommand? = manager!!.getCommand(commandName)
            command!!.execute(commandArgs, System.out)
            println("")
        }
    }
}

private fun Unit.getCommand(commandName: String?): ICommand? {

    return TODO("Provide the return value")
}





