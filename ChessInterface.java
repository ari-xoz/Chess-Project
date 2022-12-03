package Project;

import java.awt.*;
import javax.swing.*;
 
public class ChessInterface extends JFrame{
  JLayeredPane layeredPane;
  JPanel chessBoard;
  public ChessInterface(){
  Dimension boardSize = new Dimension(600, 600);
  layeredPane = new JLayeredPane();
  getContentPane().add(layeredPane);
  layeredPane.setPreferredSize(boardSize);
 
  chessBoard = new JPanel();
  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
  chessBoard.setLayout( new GridLayout(8, 8) );
  chessBoard.setPreferredSize(boardSize);
  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
 
  for (int i = 0; i < 64; i++) {
  JPanel square = new JPanel( new BorderLayout() );
  chessBoard.add( square );
 
  int row = (i / 8) % 2;
  if (row == 0)
  square.setBackground( i % 2 == 0 ? Color.black : Color.white );
  else
  square.setBackground( i % 2 == 0 ? Color.white : Color.black );
  }

  }

  public static void main(String[] args) {
  JFrame frame = new ChessInterface();
  frame.pack();
  frame.setResizable(false);
  frame.setVisible(true);
 }
}