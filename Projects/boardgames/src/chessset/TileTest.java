package chessset;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import javafx.scene.paint.Color;

public class TileTest {
    private Tile darkTile;
    private Tile lightTile;

    @BeforeEach
    public void setUp(){
        darkTile = new Tile(Color.BLACK);
        lightTile = new Tile(Color.WHITE);
    }

    @AfterEach
    public void tearDown(){
        darkTile = null;
        lightTile = null;
    }

    @Test
    public void testConstructor(){
        assertEquals(Color.BLACK, darkTile.getColor());
        assertTrue(darkTile.isEmpty());
        assertNull(darkTile.getPiece());
        assertEquals(Color.WHITE, lightTile.getColor());
        assertTrue(lightTile.isEmpty());
        assertNull(lightTile.getPiece());
    }

    @Test
    public void testPieceAction(){
        Piece piece = new Piece();
        darkTile.setPiece(piece);
        assertFalse(darkTile.isEmpty());
        assertTrue(lightTile.isEmpty());
        assertEquals(piece, darkTile.getPiece());
        assertFalse(darkTile.isEmpty());
        Piece returnedPiece = darkTile.removePiece();
        assertTrue(darkTile.isEmpty());
        assertEquals(piece, returnedPiece);
    }
}
