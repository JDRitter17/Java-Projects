package chessset;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javafx.scene.paint.Color;

public class NQueensSolverTest {

    private Board board;
    private NQueensSolver solver;
    private Position a1;
    private Position d2;
    
    @BeforeEach
    public void setUp(){
        board = new Board(8, Color.DARKGREEN, Color.BEIGE);
        solver = new NQueensSolver(board);
        a1 = new Position('a', 1);
        d2 = new Position('d', 2);
    }

    @AfterEach
    public void tearDown(){
        board = null;
        solver = null;
        a1 = null;
        d2 = null;
    }

    @Test
    void testHasSolvedPuzzle() {
        Move dummyMove = new Move(new Queen(), a1);
        for(int index = 0; index < board.size(); ++index){
            assertFalse(solver.hasSolvedPuzzle());
            solver.getMoves().add(dummyMove);
        }
        assertTrue(solver.hasSolvedPuzzle());
    }

    @Test
    void testNextLegalMoves() {
        List<Move> nextMoves = solver.nextLegalMoves();
        assertEquals(8, nextMoves.size());
        // should check coords on nextMoves
        Move Qa1 = new Move(new Queen(), a1);
        solver.makeMove(Qa1);
        nextMoves = solver.nextLegalMoves();
        assertEquals(6, nextMoves.size());
        // should check coords on nextMoves
        Move Qd2 = new Move(new Queen(), d2);
        solver.makeMove(Qd2);
        nextMoves = solver.nextLegalMoves();
        assertEquals(4, nextMoves.size()); 
    }

    @Test
    void testIsSafe(){
        Move Qa1 = new Move(new Queen(), null, a1);
        solver.makeMove(Qa1);
        Position a2 = new Position('a', 2);
        Position b2 = new Position('b', 2);
        Position c2 = new Position('c', 2);
        Position f2 = new Position('f', 2);
        assertFalse(solver.isSafe(a2));
        assertFalse(solver.isSafe(b2));
        assertTrue(solver.isSafe(c2));
        assertTrue(solver.isSafe(f2));
    } 

    @Test
    void testIsThreatening(){
        Position a4 = new Position('a', 4);
        Position g7 = new Position('g', 7);
        Position h7 = new Position('h', 7);
        assertFalse(solver.isThreatening(a1, d2));
        assertTrue(solver.isThreatening(a1, a4));
        assertTrue(solver.isThreatening(a1, g7));
        assertFalse(solver.isThreatening(a1, h7));
    }

    @Test
    void testSolve(){
        assertTrue(solver.solve());
    }
}
