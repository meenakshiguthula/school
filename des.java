import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DES {
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpecmyKeySpec;
    private SecretKeyFactorymySecretKeyFactory;
    private Cipher cipher;
byte[] keyAsBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
SecretKey key;
    static BufferedReaderbr = new BufferedReader(new InputStreamReader(System.in));

    public DES() throws Exception {
myEncryptionKey = "ThisIsSecretEncryptionKey";
myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
myKeySpec = new SecretKeySpec(keyAsBytes, myEncryptionScheme);
mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = mySecretKeyFactory.generateSecret(myKeySpec);
    }

    public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
cipher.init(Cipher.ENCRYPT_MODE, key);
byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
byte[] encryptedText = cipher.doFinal(plainText);
            Base64.Encoder base64Encoder = Base64.getEncoder();
encryptedString = new String(base64Encoder.encode(encryptedText), UNICODE_FORMAT);
        } catch (Exception e) {
e.printStackTrace();
        }
        return encryptedString;
    }

    public String decrypt(String encryptedString) {
        String decryptedText = null;
        try {
cipher.init(Cipher.DECRYPT_MODE, key);
            Base64.Decoder base64Decoder = Base64.getDecoder();
byte[] encryptedText = base64Decoder.decode(encryptedString.getBytes(UNICODE_FORMAT));
byte[] plainText = cipher.doFinal(encryptedText);
decryptedText = new String(plainText, UNICODE_FORMAT);
        } catch (Exception e) {
e.printStackTrace();
        }
        return decryptedText;
    }

    public static void main(String[] args) throws Exception {
System.out.print("Enter the string: ");
        DES myEncryptor = new DES();
        String stringToEncrypt = br.readLine();
        String encrypted = myEncryptor.encrypt(stringToEncrypt);
        String decrypted = myEncryptor.decrypt(encrypted);
System.out.println("\nString To Encrypt: " + stringToEncrypt);
System.out.println("Encrypted Value: " + encrypted);
System.out.println("Decrypted Value: " + decrypted);
    }
}


