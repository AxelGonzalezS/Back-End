package oscarblancarte.ipd.command.impl

import java.io.OutputStream

class WaitAndSayHello(override val commandName: String?) : AsyncCommand() {
    fun executeOnBackground(args: Array<String>?, out: OutputStream?) {
        if (args.isNullOrEmpty()) {
            write(out!!, "Insufficient parameters")
            return
        }
        var time: Long? = null
        time = try {
            args[0].toLong()
        } catch (e: Exception) {
            write(out!!, "Invalid time")
            return
        }
        try {
            if (time != null) {
                Thread.sleep(time)
            }
            write(out!!, "Hello!!")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        val COMMAND_NAME: String
            get() {
                TODO()
            }
        private val field: String = ""
        const val commandName = "waithello"
    }

    override fun executeOnBackground(args: Array<String?>?, out: OutputStream?) {
        TODO("Not yet implemented")
    }
}
