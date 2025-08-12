package spyware;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Encrypter {
    public static void encrypt(InputStream input, OutputStream output, byte key) throws IOException {
        output.write(key);
        int data;
        while ((data = input.read()) != -1) {
            output.write(data ^ key);
        }
    }

    public static void decrypt(InputStream input, OutputStream output) throws IOException {
        int key = input.read();
        int data;
        while ((data = input.read()) != -1) {
            output.write(data ^ key);
        }
    }

    public static void encryptFile(String inputFile, String outputFile, byte key) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(inputFile);
            output = new FileOutputStream(outputFile);
            encrypt(input, output, key);

        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }

    public static void decryptFile(String inputFile, String outputFile) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(inputFile);
            output = new FileOutputStream(outputFile);
            decrypt(input, output);

        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
}
