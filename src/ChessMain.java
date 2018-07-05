import javax.swing.JFrame;

import Enums.Piece_Rank;

public class ChessMain {
	public static void main (String[] args){
	
//	System.out.println("back to programming");
		GUIChessBoard board = new GUIChessBoard();
		Board Chessboard = new Board();
		
		JFrame f = new JFrame();
		
		f.setSize(800, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(board);
		
		f.setVisible(true);
		
		Chessboard.setupBoard();
		Chessboard.displayBoard();
		
		for ( int i = 0; i < 8; i++ )
			for ( int j = 0; j < 8; j++ ){
				Piece_Rank temp_rank = Chessboard.getPiece(i, j);
				board.setPiece(i, j, temp_rank);
			}

		f.revalidate();
	}
}
