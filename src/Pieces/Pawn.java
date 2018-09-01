package Pieces;
import java.util.ArrayList;

import Enums.Colour;
import Enums.Piece_Rank;

public class Pawn implements Piece {

	
	final private Piece_Rank rank = Piece_Rank.PAWN;
    private Colour p_colour;
	
	public Pawn(){
	}

	public Colour getColour() {
		return p_colour;
	}

	public void setColour(Colour p_colour) {
		this.p_colour = p_colour;
	}
	
	public Piece_Rank getRank() {
		return rank;
	}
	
	public ArrayList<String> getLegalMoves(int x, int y, Piece[][] boardPosition){
		System.out.println("X is " + x + " Y is " + y);
		ArrayList<String> legalMoves = new ArrayList<String>();
		if (p_colour == Colour.WHITE){
			switch(y){
			case 1: 
				legalMoves.add(Integer.toString(x) + "2");
				legalMoves.add(Integer.toString(x) + "3");
				System.out.println("2 legal moves");
				break;
			case 7:
				break;
			default:
				legalMoves.add(x + Integer.toString(y + 1));
				break;
			}
		}
		
		if (p_colour == Colour.BLACK){
			switch(y){
			case 6: 
				legalMoves.add(Integer.toString(x) + "4");
				legalMoves.add(Integer.toString(x) + "5");
				System.out.println("2 legal moves");
				break;
			case 0:
				break;
			default:
				legalMoves.add(x + Integer.toString(y - 1));
				break;
			}
		}
		
		return legalMoves;		
	}

}
