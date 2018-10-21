import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Pieces.Piece;

public class ChessMain {
	
	public static void main (String[] args){
	
//	System.out.println("back to programming");
		GUIChessBoard board = new GUIChessBoard();
		JPanel mainPanel = new JPanel();
		InfoPanel infoPanel = new InfoPanel();
		
		
		JFrame f = new JFrame();
		
		f.setSize(800, 800);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Options");
		menu.add(new JMenuItem("Play"));
		menu.add(new JMenuItem("Edit"));
		menuBar.add(menu);
		
		mainPanel.setLayout(new BorderLayout());	
		f.add(mainPanel);
		mainPanel.add(menuBar, BorderLayout.PAGE_START);
		mainPanel.add(board, BorderLayout.CENTER);
		mainPanel.add(infoPanel, BorderLayout.LINE_END);
		f.pack();
		
		board.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				System.out.println("board clicked");
				Piece testPiece = board.getClicked();
				infoPanel.setTextBox(testPiece.getRank().toString());
			}
		});
		
		f.setVisible(true);
		f.revalidate();
	}
}
