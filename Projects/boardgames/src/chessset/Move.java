package chessset;

import java.io.StringWriter;

// A move represents the move of a piece on a board.
// It knows its piece, start position, and end position.
// If the piece does not start on the board, start will be null.
public class Move {
    public Piece piece;
    public Position start;
    public Position end;

    public Move(Piece aPiece, Position aPosition){
        piece = aPiece;
        start = null;
        end = aPosition;
    }

    public Move(Piece aPiece, Position startPosition, Position endPosition){
        piece = aPiece;
        start = startPosition;
        end = endPosition;
    }

    public Piece getPiece() {
        return piece;
    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    public void doOn(Board board){
        if(start != null){
            board.removePiece(start);
        }
        board.setPiece(end, piece);
    }

    public void undoOn(Board board){
        board.removePiece(end);
        if(start != null){
            board.setPiece(start, piece);
        }
    }

    @Override
    public String toString(){
        StringWriter writer = new StringWriter();
        writer.write(piece.toString());
        writer.write(' ');
        if(start != null){
            writer.write(start.toString());
            writer.write("->");
        }
        writer.write(end.toString());
        return writer.toString();
    }
}
