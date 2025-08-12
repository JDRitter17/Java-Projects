package chessset;

import java.util.ArrayList;
import java.util.List;

public class KnightsTourSolver extends PuzzleSolver {

    private Knight knight = new Knight();

    public KnightsTourSolver(Board aBoard, Position firstPosition) {
        super(aBoard);
        Move firstMove = new Move(knight, null, firstPosition);
        makeMove(firstMove);
    }

    @Override
    public boolean hasSolvedPuzzle() {
        return moves.size() == board.size() * board.size();
    }

    @Override
    public List<Move> nextLegalMoves() {
        List<Move> nextMoves = new ArrayList<Move>();
        Position knightPosition = moves.get(moves.size()-1).end;
        List<Position> nextPositions =  nextPositionsOnBoard(knightPosition);
        for(Position eachPosition : nextPositions){
            if(!hasVisited(eachPosition)){
                nextMoves.add(new Move(knight, knightPosition, eachPosition));
            }
        }
        return nextMoves;
    }

    public boolean hasVisited(Position aPosition){
        for(Move eachMove : moves){
            if(eachMove.end.equals(aPosition)){
                return true;
            }
        }
        return false;
    }

    public List<Position> nextPositionsOnBoard(Position knightPosition){
        List<Position> nextPositions = new ArrayList<Position>();
        // for each knight offset
        //    if new position is on board
        //        create position object and put in nextPositions
        for(int[] eachJump : Knight.possibleJumps){
            int fileIndex = eachJump[0] + knightPosition.fileIndex;
            int rankIndex = eachJump[1] + knightPosition.rankIndex;
            if(fileIndex >= 0 && fileIndex < board.size()
                && rankIndex >= 0 && rankIndex < board.size()){
                    nextPositions.add(new Position(fileIndex, rankIndex));
            }
        }
        return nextPositions;
    }
    
}
