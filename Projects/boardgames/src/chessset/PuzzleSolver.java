package chessset;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class PuzzleSolver {
    protected Board board;
    protected ObservableList<Move> moves;

    public PuzzleSolver(Board aBoard){
        board = aBoard;
        moves = FXCollections.observableArrayList();
    }

    public Board getBoard(){
        return board;
    }

    public ObservableList<Move> getMoves(){
        return moves;
    }

    public abstract boolean hasSolvedPuzzle();
    public abstract List<Move> nextLegalMoves();

    public boolean solve(){
        if(hasSolvedPuzzle()){
            return true;
        }
        List<Move> nextMoves = nextLegalMoves();
        for(Move eachMove : nextMoves){
            makeMove(eachMove);
            if(solve()){
                return true;
            }
            unMakeLastMove();
        }
        return false;
    }

    public void makeMove(Move aMove){
        aMove.doOn(board);
        moves.add(aMove);
    }

    public void unMakeLastMove(){
        moves.get(moves.size() - 1).undoOn(board);
        moves.remove(moves.size() - 1);
    }
}
