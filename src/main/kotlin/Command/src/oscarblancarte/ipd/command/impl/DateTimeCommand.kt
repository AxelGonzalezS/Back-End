package oscarblancarte.ipd.command.impl

import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*

class DateTimeCommand(override val commandName: String?) : BaseCommand() {
    override fun execute(args: Array<String?>?, out: OutputStream?) {
        var dateFormater: SimpleDateFormat? = null
        dateFormater = if (args == null) {
            SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
        } else {
            try {
                SimpleDateFormat(args[0])
            } catch (e: Exception) {
                write(out!!, "invalid format")
                return
            }
        }
        val date = dateFormater.format(Date())
        write(out!!, date)
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
        const val commandName = "date"
    }
}