package chessset;
import javafx.scene.paint.Color;

public class Board {
    private Tile[][] tiles;

    public Board(int size, Color darkColor, Color lightColor){
        Color[] colors = { darkColor, lightColor };
        tiles = new Tile[size][size];
        for(int fileIndex = 0; fileIndex < tiles.length; ++fileIndex){
            for(int rankIndex = 0; rankIndex < tiles[fileIndex].length; ++rankIndex){
                tiles[fileIndex][rankIndex] = 
                    new Tile(colors[(fileIndex + rankIndex)%2]);
            }
        }
    }

    public int size(){
        return tiles.length;
    }

    public Tile getTile(Position aPos){
        return tiles[aPos.fileIndex][aPos.rankIndex];
    }

    public Color getColor(Position aPos){
        return getTile(aPos).getColor();
    }

    public boolean isEmpty(Position aPos){
        return getTile(aPos).isEmpty();
    }

    public Piece getPiece(Position aPos){
        return getTile(aPos).getPiece();
    }

    public void setPiece(Position aPos, Piece aPiece){
        getTile(aPos).setPiece(aPiece);
    }
    public Piece removePiece(Position aPos){
        return getTile(aPos).removePiece();
    }   
}
