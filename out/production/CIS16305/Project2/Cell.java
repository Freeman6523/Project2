package Project2;

import javax.swing.*;

public class Cell {

    private int playeNumber;
    /*
     *  First, the Surround4 game class will only use the player
     *   number to determine a winner.
     *  Second, you are allowed to add new properties that you will
     *   need for the later steps in your project.
     *  	for example: add on a property color that changes with
     *      show different risk levels.
     *  		use red if the cell is about to surrounded, i.e., at high risk
     *  		or use green if the cell is at low risk.
     *
     *  for example: add on a int property color that indicates
     *  			1 means this would be a ok choose.
     *  			3 means this would be a poor choose.
     *
     */

    public Cell(int playeNumber) {
        super();
        this.playeNumber = playeNumber;
    }

    public int getPlayeNumber() {
        return playeNumber;
    }
}
