package Pieces;

import java.util.ArrayList;

import Enums.Colour;
import Enums.Piece_Rank;

public class Knight implements Piece {
	
	final private Piece_Rank rank = Piece_Rank.KNIGHT;
    private Colour p_colour;

	@Override
	public Colour getColour() {
		return p_colour;
	}

	@Override
	public void setColour(Colour p_colour) {
		this.p_colour = p_colour;
	}

	@Override
	public Piece_Rank getRank() {
		return rank;
	}

	@Override
	public ArrayList<String> getLegalMoves(int x, int y, Piece[][] boardPosition) {
		System.out.println("X is " + x + " Y is " + y);
		ArrayList<String> legalMoves = new ArrayList<String>();
						
				if ( x + 2 < 8 && y + 1 < 8)
					legalMoves.add(Integer.toString(x+2) + Integer.toString(y+1));
				
				if ( x + 1 < 8 && y + 2 < 8)
					legalMoves.add(Integer.toString(x+1) + Integer.toString(y+2));
				
				if ( x + 2 < 8 && y - 1 >= 0)
					legalMoves.add(Integer.toString(x+2) + Integer.toString(y-1));
				
				if ( x + 1 < 8 && y - 2 >= 0)
					legalMoves.add(Integer.toString(x+1) + Integer.toString(y-2));
				
				if ( x - 2 >= 0 && y + 1 < 8)
					legalMoves.add(Integer.toString(x-2) + Integer.toString(y+1));
				
				if ( x - 1 >= 0 && y + 2 < 8)
					legalMoves.add(Integer.toString(x-1) + Integer.toString(y+2));
				
				if ( x - 2 >= 0 && y - 1 >= 0)
					legalMoves.add(Integer.toString(x-2) + Integer.toString(y-1));
				
				if ( x - 1 >= 0 && y - 2 >= 0)
					legalMoves.add(Integer.toString(x-1) + Integer.toString(y-2));
			
		return legalMoves;
	}

}