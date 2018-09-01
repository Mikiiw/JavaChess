package Pieces;

import java.util.ArrayList;

import Enums.Colour;
import Enums.Piece_Rank;

public class Bishop implements Piece {
	
	final private Piece_Rank rank = Piece_Rank.BISHOP;
    private Colour p_colour;

	@Override
	public Colour getColour() {
		// TODO Auto-generated method stub
		return p_colour;
	}

	@Override
	public void setColour(Colour p_colour) {
		// TODO Auto-generated method stub
		this.p_colour = p_colour;
	}

	@Override
	public Piece_Rank getRank() {
		// TODO Auto-generated method stub
		return rank;
	}

	@Override
	public ArrayList<String> getLegalMoves(int x, int y, Piece[][] boardPosition) {
		System.out.println("X is " + x + " Y is " + y);
		ArrayList<String> legalMoves = new ArrayList<String>();
		
		for(int i = 0; i < 8; i++ )
			for(int j = 0; j < 8; j++){
				if (x + y == i + j && (j != y))
					legalMoves.add(i + Integer.toString(j));
				
				
				if (x - y == i - j && (j != y))
					legalMoves.add(i + Integer.toString(j));
			}
		
		return legalMoves;
	}

}
