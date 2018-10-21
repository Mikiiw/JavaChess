import java.util.ArrayList;

import Enums.Colour;
import Enums.Piece_Rank;
import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;

public class BoardLogic {
	
	Piece[][] boardPosition = new Piece[8][8];

	public BoardLogic(){
		System.out.println("Board is being setup");
	}
	
	
	public void setPiece(int pos_x, int pos_y, Piece_Rank rank, Colour p_Colour){
	/*
	* Set the Piece to a rank, some form of class factory
	*/
		
		switch (rank){
		case PAWN:
			boardPosition[pos_y][pos_x] = new Pawn();
			break;
		case BISHOP:
			boardPosition[pos_y][pos_x] = new Bishop();
			break;
		case EMPTY:
			break;
		case KING:
			boardPosition[pos_y][pos_x] = new King();
			break;
		case KNIGHT:
			boardPosition[pos_y][pos_x] = new Knight();
			break;
		case QUEEN:
			boardPosition[pos_y][pos_x] = new Queen();
			break;
		case ROOK:
			boardPosition[pos_y][pos_x] = new Rook();
			break;
		default:
			break;
		}
		boardPosition[pos_y][pos_x].setColour(p_Colour);
		
	}
	
	/*
	 * Returns Piece based on coordinate of the board 
	 */
	public Piece getPiece(int pos_x, int pos_y){
		if (boardPosition[pos_y][pos_x] == null )
			return null;
		return boardPosition[pos_y][pos_x];
	}
	
	/*
	 * Returns Piece Rank based on coordinate of the board 
	 */
	public Piece_Rank getRank(int pos_x, int pos_y){
		if (boardPosition[pos_y][pos_x] == null )
			return Piece_Rank.EMPTY;
		return boardPosition[pos_y][pos_x].getRank();
	}
	
	/*
	 * Setting up the board to the default setup
	 */
	public void setupBoard(){
		for ( int i = 0; i < 8; i++ )
			for ( int j = 0; j < 8; j++ ){
				//White Setup
				if (i == 1){
					boardPosition[i][j] = new Pawn();
					boardPosition[i][j].setColour(Colour.WHITE);
				}
				
				if (i == 0 && (j == 0 || j == 7)){
					boardPosition[i][j] = new Rook();
					boardPosition[i][j].setColour(Colour.WHITE);
				}
				
				if (i == 0 && (j == 1 || j == 6)){
					boardPosition[i][j] = new Knight();
					boardPosition[i][j].setColour(Colour.WHITE);
				}
				
				if (i == 0 && (j == 2 || j == 5)){
					boardPosition[i][j] = new Bishop();
					boardPosition[i][j].setColour(Colour.WHITE);
				}
				
				if (i == 0 && j == 3){
					boardPosition[i][j] = new Queen();
					boardPosition[i][j].setColour(Colour.WHITE);
				}
				
				if (i == 0 && j == 4){
					boardPosition[i][j] = new King();
					boardPosition[i][j].setColour(Colour.WHITE);
				}
				
				//Black Setup
				if (i == 6){
					boardPosition[i][j] = new Pawn();
					boardPosition[i][j].setColour(Colour.BLACK);
				}
				
				if (i == 7 && (j == 0 || j == 7)){
					boardPosition[i][j] = new Rook();
					boardPosition[i][j].setColour(Colour.BLACK);
				}
				
				if (i == 7 && (j == 1 || j == 6)){
					boardPosition[i][j] = new Knight();
					boardPosition[i][j].setColour(Colour.BLACK);
				}
				
				if (i == 7 && (j == 2 || j == 5)){
					boardPosition[i][j] = new Bishop();
					boardPosition[i][j].setColour(Colour.BLACK);
				}
				
				if (i == 7 && j == 3){
					boardPosition[i][j] = new Queen();
					boardPosition[i][j].setColour(Colour.BLACK);
				}
				
				if (i == 7 && j == 4){
					boardPosition[i][j] = new King();
					boardPosition[i][j].setColour(Colour.BLACK);
				}
				
				
			}
	}
	
	public void displayBoard(){
		for ( int j = 7; j >= 0; j-- ){
			for ( int i = 0; i < 8; i++ ){
						Piece_Rank p_rank = this.getRank(i, j);
						switch (p_rank){
						case PAWN:
							System.out.print("P ");
							break;
						case BISHOP:
							System.out.print("B ");
							break;
						case EMPTY:
							System.out.print("- ");
							break;
						case KING:
							System.out.print("K ");
							break;
						case KNIGHT:
							System.out.print("N ");
							break;
						case QUEEN:
							System.out.print("Q ");
							break;
						case ROOK:
							System.out.print("R ");
							break;
						default:
							break;
						}
				}	
			System.out.println("");
			}
		
	}
	
	public void removePiece(int pos_x, int pos_y){
		boardPosition[pos_y][pos_x] = null;
	}
	
	public ArrayList<String> getLegalMoves(int x, int y){
//		System.out.println(x + " " + y);
		ArrayList<String> legalMoves = boardPosition[y][x].getLegalMoves(x, y, boardPosition);
		return legalMoves;
	}
}
