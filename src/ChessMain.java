import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class ChessMain {
	
	public static void main (String[] args){
	
//	System.out.println("back to programming");
		GUIChessBoard board = new GUIChessBoard();
		
		JFrame f = new JFrame();
		
		f.setSize(800, 800);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Options");
		menuBar.add(menu);
		
		f.add(menuBar);
		f.add(board);
		f.pack();
		f.setVisible(true);
		
		f.revalidate();
	
	
	}
}
