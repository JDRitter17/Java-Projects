package disputation;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Collections;
public class Streamer {

    public int countBytes(byte[] data) throws IOException {
        InputStream input = null;
        try {
            input = new ByteArrayInputStream(data);
            int nextByte;
            int count = 0;
            while ((nextByte = input.read()) != -1) {

                ++count;
            }
            return count;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public void writeAllBytesValuesToFile(String filename) throws IOException {
        OutputStream output = null;
        try {
            output = new FileOutputStream(filename);
            for (int value = -128; value < 128; ++value) {
                output.write(value);

            }
        } finally {
            if (output != null) {
                output.close();
            }
        }

    }

    public void writeAllBytesValuesZeroBased(String filename) throws IOException {
        OutputStream output = null;
        try {
            output = new FileOutputStream(filename);
            for (int i = 0; i < 256; ++i) {
                output.write(i);
            }

        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public void writeAlphabet(String filename) throws IOException {
        Writer output = null;
        try {
            output = new FileWriter(filename);
            for (char letter = 'A'; letter <= 'Z'; ++letter) {
                output.write(letter);
            }
        } finally {
            if (output != null) {
                output.close();
            }

        }
    }

    public int occurencesOf(char aChar, String filename) throws IOException {
        Reader input = null;
        try {
            input = new FileReader(filename);
            int count = 0;
            int nextChar;
            while ((nextChar = input.read()) != -1) {
                if ((char) nextChar == aChar) {
                    count++;
                }
            }
            return count;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public void copyFile(String srcFilename, String dstFilename) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(srcFilename);
            output = new FileOutputStream(dstFilename);
            int nextByte;
            while ((nextByte = input.read()) != -1) {
                output.write(nextByte);

            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }

    }

    public List<String> vocabulary(String filename)throws IOException{
        Scanner input = null;
        try{
            input = new Scanner(new FileReader(filename));
            input.useDelimiter("[\t \r \n ,\\.}]+");
            Set<String> uniqueWords = new HashSet<String>();
            while(input.hasNext()){
                uniqueWords.add(input.next().toLowerCase());
            }
            List<String> vocabulary = new ArrayList<String>(uniqueWords);
            Collections.sort(vocabulary);
            return vocabulary;
        }finally{
            if (input != null){
                input.close();
            }
        }
    }
}
