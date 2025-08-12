package chessset;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javafx.scene.paint.Color;

public class KnightsTourSolverTest {
    private Position a1;
    private Position b3;
    private Position c2;
    private Board board;
    private KnightsTourSolver solver;

    @BeforeEach
    public void setUp(){
        a1 = new Position('a', 1);
        b3 = new Position('b', 3);
        c2 = new Position('c', 2);
        board = new Board(6, Color.DARKGREEN, Color.BEIGE);
        solver = new KnightsTourSolver(board, a1);
    }

    @AfterEach
    public void tearDown(){
        solver = null;
        board = null;
        a1 = null;
        b3 = null;
        c2 = null;
    }

    @Test
    public void testHasSolvedPuzzle() {
        Move dummyMove = new Move(new Knight(), null, a1);
        for( int i = 1; i < board.size() * board.size(); ++i ){
            assertFalse(solver.hasSolvedPuzzle());
            solver.getMoves().add(dummyMove);
        }
        assertTrue(solver.hasSolvedPuzzle());
    }

    @Test
    public void testNextLegalMoves() {
        List<Move> nextMoves = solver.nextLegalMoves();
        assertEquals(2, nextMoves.size());
        Move secondMove = new Move(new Knight(), a1, b3);
        solver.makeMove(secondMove);
        nextMoves = solver.nextLegalMoves();
        assertEquals(5, nextMoves.size());
    }

    @Test
    public void testSolve(){
        assertTrue(solver.solve());
        System.out.print("done");
    }

    @Test
    public void testNextPositionsOnBoard(){
        List<Position> nextPositions = solver.nextPositionsOnBoard(a1);
        assertEquals(2, nextPositions.size());
        assertTrue(nextPositions.contains(b3));
        assertTrue(nextPositions.contains(c2));
    }

    @Test
    public void testHasVisited(){
        assertFalse(solver.hasVisited(c2));
        assertTrue(solver.hasVisited(a1));
    }
}
