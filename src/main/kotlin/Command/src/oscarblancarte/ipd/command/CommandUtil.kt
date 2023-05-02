package oscarblancarte.ipd.command

object CommandUtil {
    fun tokenizerArgs(args: String): List<String> {

        val token = args.split(" ")
        return token
    }

        val tokens: MutableList<String> = ArrayList()
        val charArray = args.toCharArray()
        var contact = ""
        var inText = false
        for (c in charArray) {
            if (c == ' ' && !inText) {
                if (contact.length != 0) {
                    tokens.add(contact)
                    contact = ""
                }
            } else if (c == '"') {
                if (inText) {
                    tokens.add(contact)
                    contact = ""
                    inText = false
                } else {
                    inText = true
                }
            } else {
                contact += c
            }
        }
        if (contact.trim { it <= ' ' }.length != 0) {
            tokens.add(contact.trim { it <= ' ' })
        }
        var argsArray = arrayOf<String>(tokens.size.toString())
        //argsArray = tokens.toArray(argsArray)
        return argsArray
    }
}

private fun <E> List<E>.toArray(argsArray: Array<E?>): Array<E?> {
    TODO("Not yet implemented")
}
