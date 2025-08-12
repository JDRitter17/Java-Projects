package chessset;

import java.util.ArrayList;
import java.util.List;

public class NQueensSolver extends PuzzleSolver {
    private Queen queen = new Queen();

    public NQueensSolver(Board board) {
        super(board);
    }

    @Override
    public boolean hasSolvedPuzzle() {
        return moves.size() == board.size();
    }

    public boolean isThreatening(Position p1, Position p2) {
        if (p1.fileIndex == p2.fileIndex)
            return true;
        return Math.abs(p1.rankIndex - p2.rankIndex) == Math.abs(p1.fileIndex - p2.fileIndex);
    }

    public boolean isSafe(Position pos) {
        for (Move move : moves) {
            if (isThreatening(move.getEnd(), pos)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Move> nextLegalMoves() {
        List<Move> legalMoves = new ArrayList<>();
        int rank = moves.size();

        for (int file = 0; file < board.size(); file++) {
            Position pos = new Position(file, rank);
            if (isSafe(pos)) {
                legalMoves.add(new Move(queen, pos));
            }
        }

        return legalMoves;
    }
}