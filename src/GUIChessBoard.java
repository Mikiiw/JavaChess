import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIChessBoard extends JPanel{
	
	public static Board Chessboard = new Board();
	
	public GUIChessBoard(){
		System.out.println("Board GUI is being setup");
		JFrame chessFrame = new JFrame();
		
		chessFrame.setSize(800, 800);
		chessFrame.setVisible(true);
		chessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Chessboard.setupBoard();
		Chessboard.displayBoard();
	}
	
	
}
