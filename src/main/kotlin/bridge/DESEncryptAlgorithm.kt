package bridge

import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec

class DESEncryptAlgorithm: IEncryptAlgorithm{

    override fun encryprt(message: String, password: String): String {
        val dks = DESKeySpec(message.toByteArray())
        val skf = SecretKeyFactory.getInstance("DES")
        val deskey = skf.generateSecret(dks)
        val desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
        desCipher.init(Cipher.ENCRYPT_MODE,deskey)

        return Base64.getEncoder().encodeToString(desCipher.doFinal(message.toByteArray()))
    }
}