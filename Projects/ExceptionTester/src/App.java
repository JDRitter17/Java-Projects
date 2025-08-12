import disputation.Streamer;
import disputation.Disputer;
import disputation.SassyException;
import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {
        /* 
        Disputer aDisputer = new Disputer();
        try {
            System.out.println(aDisputer.doIt());

        } catch (SassyException ex) {
            System.out.println("Failed in style");

        } catch (Exception ex) {
            System.out.println("An unspecified error occured");
        } finally {
            System.out.println("This is the real end");
        }
        */
        Streamer aStreamer = new Streamer();
        aStreamer.writeAllBytesValuesToFile("byteValues.data");
        aStreamer.writeAllBytesValuesZeroBased("byteValues1.data");
        aStreamer.writeAlphabet("pirmer.txt");
        System.out.println(aStreamer.occurencesOf('A', "pirmer.txt"));
        aStreamer.copyFile("pirmer.txt", "copyofpirmer.txt");
        aStreamer.vocabulary("seuus.txt");
        List<String> vocab = aStreamer.vocabulary("seuus.txt");
        System.out.print(vocab.size());
        
    }
}
