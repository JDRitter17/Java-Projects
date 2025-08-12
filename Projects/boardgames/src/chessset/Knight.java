package chessset;

public class Knight extends Piece {
    // move offsets from a given knight position
    public static int[][] possibleJumps = 
        {{-1, 2}, {1,2}, {2,1}, {2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1}};

    @Override
    public String toString(){
        return "Kn";
    }

}
