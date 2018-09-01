package Pieces;

import java.util.ArrayList;

import Enums.Colour;
import Enums.Piece_Rank;

public class King implements Piece {
	
	final private Piece_Rank rank = Piece_Rank.KING;
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
		
		//Top Right checker
		if(x + 1 < 8){
			legalMoves.add(Integer.toString(x + 1) + Integer.toString(y));
			if(y + 1 < 8){
				legalMoves.add(Integer.toString(x + 1) + Integer.toString(y + 1));
			}
		}
		
		//Top Left checker
		if(y + 1 < 8){
			legalMoves.add(Integer.toString(x) + Integer.toString(y + 1));
			if(x - 1 >= 0){
				legalMoves.add(Integer.toString(x - 1) + Integer.toString(y + 1));
			}
		}
		
		//Bottom Left Checker
		if(x - 1 >= 0){
			legalMoves.add(Integer.toString(x - 1) + Integer.toString(y));
			if(y - 1 >= 0){
				legalMoves.add(Integer.toString(x - 1) + Integer.toString(y - 1));
			}
		}
		
		//Bottom Right Checker
		if(y - 1 >= 0){
			legalMoves.add(Integer.toString(x) + Integer.toString(y - 1));
			if(x + 1 < 8){
				legalMoves.add(Integer.toString(x + 1) + Integer.toString(y - 1));
			}
		}
		
		
		return legalMoves;
	}

}