package Project2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Surround4Panel extends JPanel {

    private JButton[][] board;

    private JPanel panel1;
    private int player;
    private ButtonListener listen;
    private JMenuItem quitItem, newGame;
    private Surround4Game game;

    public Surround4Panel(JMenuItem pQuitItem, JMenuItem pNewGame) {
        quitItem = pQuitItem;
        listen = new ButtonListener();
        newGame = pNewGame;
        setLayout(new BorderLayout());
        panel1 = new JPanel();

        createBoard();
        add(panel1, BorderLayout.CENTER);
        game = new Surround4Game();
        quitItem.addActionListener(listen);
        newGame.addActionListener(listen);

    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == quitItem)
                System.exit(1);
            if (e.getSource() == newGame) {
                game = new Surround4Game();
                displayBoard();
            }

            for (int row = 0; row < board.length; row++)
                for (int col = 0; col < board[0].length; col++)
                    if (board[row][col] == e.getSource())
                        if (game.select(row, col)) {
                            //		board[row][col].setText(""+game.getCurrentPlayer());
                            player = game.nextPlayer();
                        } else
                            JOptionPane.showMessageDialog(null, "Not a valid square! Pick again.");

            displayBoard();
            int winner = game.getWinner();
            if (winner != -1) {
                JOptionPane.showMessageDialog(null, "Player " + winner + " Wins!");
                game = new Surround4Game();
                displayBoard();

            }
        }
    }

    private void createBoard() {

        board = new JButton[10][10];
        panel1.setLayout(new GridLayout(10, 10));

        for (int i = 0; i < 10; i++) // rows
            for (int j = 0; j < 10; j++) {
                board[i][j] = new JButton("");
                board[i][j].addActionListener(listen);
                panel1.add(board[i][j]);
            }
    }

    private void displayBoard() {

        for (int row = 0; row < 10; row++)
            for (int col = 0; col < 10; col++) {
                Cell c = game.getCell(row, col);
                if (c != null)
                    board[row][col].setText("" + c.getPlayeNumber());
                else
                    board[row][col].setText("");
            }
    }


}

