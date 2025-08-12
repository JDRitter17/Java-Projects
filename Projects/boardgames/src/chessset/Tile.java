package chessset;

import javafx.scene.paint.Color;

public class Tile {
    private Color color;
    private Piece piece;

    public Tile(Color aColor){
        color = aColor;
    }

    public Color getColor(){
        return color;
    }

    public boolean isEmpty(){
        return piece == null;
    }

    public Piece getPiece(){
        return piece;
    }

    public void setPiece(Piece aPiece){
        piece = aPiece;
    }

    public Piece removePiece(){
        Piece tempPiece = piece;
        piece = null;
        return tempPiece;
    }
}
