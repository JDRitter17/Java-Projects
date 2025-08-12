package disputation;

import java.util.Random;

public class Disputer {
    private static Random chooser = new Random();

    public String doIt() throws Exception {
        int choice = chooser.nextInt(3);
        try{
            switch (choice) {
                case 0:
                    return "done";
                case 1:
                    Exception ex = new Exception();
                    throw ex;

                case 2:
                    throw new SassyException();
                
                default:
                    // This should be unreachable
            }
            return "code is yet to be written";
        } finally {
            System.out.println("This is the end of the method");
        }
        

    }
}
