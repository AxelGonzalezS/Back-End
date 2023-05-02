package oscarblancarte.ipd.command.impl

import java.io.File
import java.io.FileWriter
import java.io.OutputStream
import java.util.*

abstract class FileCommand : BaseCommand() {
    fun execute(args: Array<String>, out: OutputStream?) {
        if (args.size < 2) {
            write(out!!, "Insufficient parameters")
            return
        }
        val operation = args[0].uppercase(Locale.getDefault())
        val reduce = Arrays.copyOfRange(args, 1, args.size)
        if (WRITE_APPEND == operation) {
            write(out!!, writeAppend(reduce))
        } else if (WRITE_NEW == operation) {
            write(out!!, writeNew(reduce))
        } else if (WRITE_OVERRIDE == operation) {
            write(out!!, writeOverride(reduce))
        } else if (RENAME_FILE == operation) {
            write(out!!, renameFile(reduce))
        } else if (DELETE_FILE == operation) {
            write(out!!, deleteFile(reduce))
        } else {
            write(
                out!!,
                "Invalid operation {$WRITE_APPEND|$WRITE_NEW|$WRITE_OVERRIDE|$RENAME_FILE|DELETE_FILE}"
            )
        }
    }

    private fun renameFile(args: Array<String>): String {
        val filePath = args[0]
        val newFileName = args[1]
        return try {
            val file = File(filePath)
            file.renameTo(File(newFileName))
            ""
        } catch (e: Exception) {
            "ERROR: " + e.message
        }
    }

    private fun writeOverride(args: Array<String>): String {
        val filePath = args[0]
        val fileContent = args[1]
        return try {
            val file = File(filePath)
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    return "ERROR: Error creating the file"
                }
            }
            val fileW = FileWriter(file)
            fileW.write(fileContent.toCharArray())
            fileW.flush()
            fileW.close()
            ""
        } catch (e: Exception) {
            "ERROR: " + e.message
        }
    }

    private fun writeAppend(args: Array<String>): String {
        val filePath = args[0]
        val fileContent = args[1]
        return try {
            val file = File(filePath)
            if (!file.exists()) {
                return "ERRRO: File not found"
            }
            val fileW = FileWriter(file, true)
            fileW.append(fileContent)
            fileW.flush()
            fileW.close()
            ""
        } catch (e: Exception) {
            "ERROR: " + e.message
        }
    }

    private fun writeNew(args: Array<String>): String {
        if (args.size < 2) {
            return "Invalid arguments"
        }
        val filePath = args[0]
        val fileContent = args[1]
        return try {
            val file = File(filePath)
            if (file.exists()) {
                return "ERRRO: The file already exists"
            }
            if (!file.createNewFile()) {
                return "ERROR: It was not possible to create the file"
            }
            val fileW = FileWriter(file)
            fileW.write(fileContent.toCharArray())
            fileW.flush()
            fileW.close()
            ""
        } catch (e: Exception) {
            "ERROR: " + e.message
        }
    }

    private fun deleteFile(args: Array<String>): String {
        val filePath = args[0]
        val file = File(filePath)
        return if (!file.delete()) {
            "It was not possible to create the file"
        } else ""
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
        val commandName = "file"
        private const val WRITE_APPEND = "-WA"
        private const val WRITE_OVERRIDE = "-WO"
        private const val WRITE_NEW = "-WN"
        private const val RENAME_FILE = "-R"
        private const val DELETE_FILE = "-D"
    }
}