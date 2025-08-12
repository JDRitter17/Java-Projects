package chessset;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javafx.scene.paint.Color;

public class BoardTest {

    private Board board;
    private Position a1;
    private Position b1;
    private Position f6;

    @BeforeEach
    public void setUp(){
        board = new Board(6, Color.BLACK, Color.WHITE);
        a1 = new Position('a', 1);
        b1 = new Position('b', 1);
        f6 = new Position('f', 6);
    }

    @AfterEach
    public void tearDown(){
        board = null;
    }

    @Test
    public void testConstructor(){
        assertEquals(6, board.size());
        Tile aTile = board.getTile(b1);
        assertEquals(Color.WHITE, aTile.getColor());
        assertEquals(Color.BLACK, board.getColor(a1));
        assertTrue(board.isEmpty(a1));
        assertEquals(Color.BLACK, board.getColor(f6));
    }

    @Test
    public void testPieceAction(){
        Piece aPiece = new Piece();
        board.setPiece(b1, aPiece);
        assertFalse(board.isEmpty(b1));
        assertTrue(board.isEmpty(a1));
        assertEquals(aPiece, board.getPiece(b1));
        assertFalse(board.isEmpty(b1));
        assertEquals(aPiece, board.removePiece(b1));
        assertTrue(board.isEmpty(b1));
    }
}
