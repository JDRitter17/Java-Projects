package spyware;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncrypterTest {

    private byte[] plain = { (byte)0xE6, 0x2A };
    private byte key = 0x42;
    private byte[] crypt = { 0x42, (byte)0xA4, 0x68};

    @Test
    public void testEncrypt() throws IOException {
        InputStream input = null;
        ByteArrayOutputStream output = null;
        try {
            input = new ByteArrayInputStream(plain);
            output = new ByteArrayOutputStream();
            Encrypter.encrypt(input, output, key);
            byte[] cryptBytes = output.toByteArray();
            assertTrue(areArraysEqual(crypt, cryptBytes));
        } catch(IOException ex){
            fail("Caught an unexpected exception!");
        } finally {
            if(input != null){
                input.close();
            }
            if(output != null){
                output.close();
            }
        }
    }

    @Test
    public void testDecrypt() throws IOException {
        InputStream input = null;
        ByteArrayOutputStream output = null;
        try {
            input = new ByteArrayInputStream(crypt);
            output = new ByteArrayOutputStream();
            Encrypter.decrypt(input, output);
            byte[] plainBytes = output.toByteArray();
            assertTrue(areArraysEqual(plain, plainBytes));
        } catch(IOException ex){
            fail("Caught an unexpected exception!");
        } finally {
            if(input != null){
                input.close();
            }
            if(output != null){
                output.close();
            }
        }
    }

    @Test
    public void testEncryptDecryptFile(){
        try {
            // Make sure create files have been deleted.
            Path storyPath = Paths.get("./story.txt");
            Path cryptoPath = Paths.get("./crypto");;
            Files.deleteIfExists(storyPath);
            Files.deleteIfExists(cryptoPath);
            // On to the test.
            Encrypter.decryptFile("coded","story.txt");
            assertTrue(Files.exists(storyPath));
            // Make sure that story is readable.
            byte key =  0x73; // initialize key with first byte of coded
            Encrypter.encryptFile("story.txt", "crypto", key);
            assertTrue(Files.exists(cryptoPath));
            // Make sure crypto and coded have the same contents.
        } catch(IOException ex){
            fail("Caught an unexpected IOException.");
        }
    }

    public boolean areArraysEqual(byte[] array1, byte[] array2){
        if(array1.length != array2.length){
            return false;
        }
        for(int i = 0; i < array1.length; ++i){
            if(array1[i] != array2[i]){
                return false;
            }
        }
        return true;
    }
}
