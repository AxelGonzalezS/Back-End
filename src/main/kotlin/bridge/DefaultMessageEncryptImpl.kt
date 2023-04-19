package bridge

import kotlin.jvm.Throws

class DefaultMessageEncryptImpl(private var encryptAlgorithm: IEncryptAlgorithm): IMessageEncrypt {
    @Throws(Exception::class)
    override fun encryptMessage(message: String?, password: String?): String? {
        return encryptAlgorithm!!.encryprt(message!!,password!!)
    }
}