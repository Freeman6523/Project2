package Project2;

import static org.junit.Assert.*;

import org.junit.Test;

public class testingSurrGame {

    @Test
    public void testCornersUL() {
        Surround4Game g = new Surround4Game();
        g.select(0, 1);
        g.nextPlayer();
        g.select(0,0);
        g.nextPlayer();
        g.select(1, 0);
        assertTrue(g.getWinner() == 0);
    }

    @Test
    public void testCornersUR() {
        Surround4Game g = new Surround4Game();
        g.select(0, 2);
        g.nextPlayer();
        g.select(0,3);
        g.nextPlayer();
        g.select(1, 3);
        assertTrue(g.getWinner() == 0);
    }

}