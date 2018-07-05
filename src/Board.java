import Enums.Colour;
import Enums.Piece_Rank;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Rook;

public class Board {
	
	Piece[][] boardPosition = new Piece[8][8];

	public Board(){
		
		System.out.println("Board is being setup");
		
		//this.setPiece(1, 1, Piece_Rank.PAWN);
		//System.out.println("Piece is " + boardPosition[1][1].getRank());
		
		//if (boardPosition[0][0] == null) System.out.println("Null Tile");

	}
	
	
	public void setPiece(int pos_x, int pos_y, Piece_Rank rank){
		/*
		 * Set the Piece to a rank
		 */
		
		boardPosition[pos_y][pos_x] = new Pawn();
		
	}
	
	public Piece_Rank getPiece(int pos_x, int pos_y){
		/*
		 * Returns Piece based on coordinate of the board 
		 */
		if (boardPosition[pos_y][pos_x] == null )
			return Piece_Rank.EMPTY;
		return boardPosition[pos_y][pos_x].getRank();
	}
	
	public void setupBoard(){
		/*
		 * Setting up the board to the default setup
		 * 
		 */
		for ( int i = 0; i < 8; i++ )
			for ( int j = 0; j < 8; j++ ){
				if (i == 1){
					boardPosition[i][j] = new Pawn();
					boardPosition[i][j].setColour(Colour.WHITE);
				}
				
				if (i == 0 && j == 0){
					boardPosition[i][j] = new Rook();
					boardPosition[i][j].setColour(Colour.WHITE);
				}
			}
	}
	
	public void displayBoard(){
		for ( int j = 7; j >= 0; j-- ){
			for ( int i = 0; i < 7; i++ ){
				if(this.getPiece(i, j) == Piece_Rank.EMPTY){
					System.out.print("- ");
					}else{
						Piece_Rank p_rank = this.getPiece(i, j);
						switch (p_rank){
						case PAWN:
							System.out.print("P ");
							break;
						case BISHOP:
							break;
						case EMPTY:
							break;
						case KING:
							break;
						case KNIGHT:
							break;
						case QUEEN:
							break;
						case ROOK:
							System.out.print("R ");
							break;
						default:
							break;
						}
					}
				}	
			System.out.println("");
			}
		
	}
}
