package Pieces;
import java.util.ArrayList;

import Enums.Colour;
import Enums.Piece_Rank;

public interface Piece {
/*
 * Piece Class:
 * Has a position, E5, J6, A2 etc.
 * Has a piece on it
 */
	
	public Colour getColour();
	
	public void setColour(Colour p_colour);
	
	public Piece_Rank getRank();
	
	public ArrayList<String> getLegalMoves(int x, int y, Piece[][] boardPosition);
	
}
