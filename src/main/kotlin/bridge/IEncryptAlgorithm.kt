package bridge

interface IEncryptAlgorithm {

    fun encryprt (message:String, password:String): String
}