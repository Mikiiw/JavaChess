package Pieces;
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
	
	public int move(){
		
		
		return 0;		
	}

}
