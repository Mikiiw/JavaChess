package Pieces;
import java.util.ArrayList;

import Enums.Colour;
import Enums.Piece_Rank;

public class Rook implements Piece{
	
	final private Piece_Rank rank = Piece_Rank.ROOK;
    private Colour p_colour;
    
	public Colour getColour() {
		return p_colour;
	}

	public void setColour(Colour p_colour) {
		this.p_colour = p_colour;
		
	}

	public Piece_Rank getRank() {
		return rank;
	}

	public ArrayList<String> getLegalMoves(int x, int y, Piece[][] boardPosition) {
		System.out.println("X is " + x + " Y is " + y);
		ArrayList<String> legalMoves = new ArrayList<String>();
		
		for(int i = 0; i < 8; i++ )
			for(int j = 0; j < 8; j++){
				
				if( i == x && j != y )
					legalMoves.add(i + Integer.toString(j));
				
				if( j == y && i != x )
					legalMoves.add(i + Integer.toString(j));
				
			}
		
		return legalMoves;	
	}

}
