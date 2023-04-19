package bridge

class NoEncryptAlgorithm: IEncryptAlgorithm {
    override fun encryprt(message: String, password: String): String {
        return message
    }
}