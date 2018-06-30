package Pieces;
import Enums.Colour;
import Enums.Piece_Rank;

public class Rook implements Piece{
	
	final private Piece_Rank rank = Piece_Rank.ROOK;
    private Colour p_colour;
    
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

}
