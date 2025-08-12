package chessset;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javafx.scene.paint.Color;

public class MoveTest {

    private Board board;
    private Piece knight;
    private Move placePiece;
    private Move movePiece;
    private Position a1;
    private Position c2;

    @BeforeEach
    public void setUp(){
        board = new Board(6, Color.BLACK, Color.WHITE);
        knight = new Knight();
        a1 = new Position('a', 1);
        c2 = new Position('c', 2);
        placePiece = new Move(knight, a1);
        movePiece = new Move(knight, a1, c2);
    }

    @AfterEach
    public void tearDown(){
        board = null;
    }

    @Test
    public void testConstructor(){
        assertEquals(knight, placePiece.getPiece());
        assertNull(placePiece.getStart());
        assertEquals(a1, placePiece.getEnd());
        assertEquals(knight, movePiece.getPiece());
        assertEquals(a1, movePiece.getStart());
        assertEquals(c2, movePiece.getEnd());
    }
    @Test
    public void testPlacePiece(){
        placePiece.doOn(board);
        assertEquals(knight, board.getPiece(a1));
        placePiece.undoOn(board);
        assertTrue(board.isEmpty(a1));
    }

    @Test
    public void testMovePiece(){
        placePiece.doOn(board);
        movePiece.doOn(board);
        assertTrue(board.isEmpty(a1));
        assertEquals(knight, board.getPiece(c2));
        movePiece.undoOn(board);
        assertEquals(knight, board.getPiece(a1));
        assertTrue(board.isEmpty(c2));
    }
}
