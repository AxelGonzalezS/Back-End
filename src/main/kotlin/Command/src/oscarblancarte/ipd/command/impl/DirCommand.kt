package oscarblancarte.ipd.command.impl

import java.io.File
import java.io.OutputStream
import java.util.*

class DirCommand(override val commandName: String?) : BaseCommand() {
    private fun deleteDir(url: String): String {
        return try {
            val file = File(url)
            if (!file.exists()) {
                return "File not found"
            }
            if (!file.canWrite()) {
                return "Insufficient privileges"
            }
            file.delete()
            ""
        } catch (e: Exception) {
            "ERROR: " + e.message
        }
    }

    private fun newDir(url: String): String {
        return try {
            val file = File(url)
            if (file.exists()) {
                return "File not found"
            }
            file.mkdirs()
            ""
        } catch (e: Exception) {
            "ERROR: " + e.message
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
        const val commandName = "dir"
    }

    override fun execute(args: Array<String>, out: OutputStream?) {
        if (args == null || args.size < 2) {
            write(out!!, "$commandName insufficient arguments")
        }
        val operation = args!![0]
        if ("-D" == operation.uppercase(Locale.getDefault())) {
            write(out!!, deleteDir(args[1]))
        } else if ("-N" == operation.uppercase(Locale.getDefault())) {
            write(out!!, newDir(args[1]))
        } else {
            write(out!!, "Invalid argument {-d | -n}")
        }
    }


}