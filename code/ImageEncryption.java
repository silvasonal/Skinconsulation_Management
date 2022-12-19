import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ImageEncryption {

    public static void main(String[] args) throws Exception {
        // Read the image file into memory
        File imageFile = new File("image.png");
        FileInputStream fis = new FileInputStream(imageFile);
        byte[] imageData = new byte[(int) imageFile.length()];
        fis.read(imageData);
        fis.close();

        // Select an encryption algorithm and create a key
        String algorithm = "AES";
        Key key = new SecretKeySpec("secret-key-123".getBytes(), algorithm);

        // Initialize the cipher and encrypt the image data
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedImageData = cipher.doFinal(imageData);

        // Write the encrypted image data to a new file
        FileOutputStream fos = new FileOutputStream("encrypted-image.png");
        fos.write(encryptedImageData);
        fos.close();
    }
}