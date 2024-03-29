import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Enums.Colour;
import Enums.Piece_Rank;

public class GUITile extends JPanel{
	
	public boolean isOccupied = false;
	public JLabel pic1 = new JLabel();

	public GUITile(){
	//	this.setBorder(new LineBorder(Color.black, 2));
	}
	/*
	 * Adds a piece onto the user interface
	 */
	public void addPiece(Piece_Rank rank, Colour colour){
	    isOccupied = true;
	    
	    if(colour == Colour.WHITE){
	    	switch (rank) {
	    	case BISHOP:
	    		pic1.setIcon(new ImageIcon("img/bishop_white.png"));
	    		break;
	    	case EMPTY:
	    		isOccupied = false;
	    		break;
	    	case KING:
	    		pic1.setIcon(new ImageIcon("img/king_white.png"));
				break;
				case KNIGHT:
			    pic1.setIcon(new ImageIcon("img/knight_white.png"));
				break;
			case PAWN:
			    pic1.setIcon(new ImageIcon("img/pawn_white.png"));
				break;
			case QUEEN:
			    pic1.setIcon(new ImageIcon("img/queen_white.png"));
				break;
			case ROOK:
			    pic1.setIcon(new ImageIcon("img/rook_white.png"));
				break;
			default:
				System.out.println("White piece not found");
				break;
		    }
	    }
	    
	    if(colour == Colour.BLACK){
	    	switch(rank){
	    	case BISHOP:
		    	pic1.setIcon(new ImageIcon("img/bishop_blk.png"));
		    	break;
		    case EMPTY:
	    		 isOccupied = false;
		    	break;
		    case KING:
					pic1.setIcon(new ImageIcon("img/king_blk.png"));
					break;
				case KNIGHT:
				    pic1.setIcon(new ImageIcon("img/knight_blk.png"));
					break;
				case PAWN:
				    pic1.setIcon(new ImageIcon("img/pawn_blk.png"));
					break;
				case QUEEN:
				    pic1.setIcon(new ImageIcon("img/queen_blk.png"));
					break;
				case ROOK:
				    pic1.setIcon(new ImageIcon("img/rook_blk.png"));
					break;
				default:
					System.out.println("Black piece not found");
					break;
			    }
	    }
	    this.add(pic1);		
	}
	
	public void removePiece(){
		this.removeAll();
		this.isOccupied = false;
	}
	
	public void tileClicked(){
		if(isOccupied){
			this.setBackground(Color.GREEN);
			System.out.println("Tile is occupied");
		}
	}
	
	public void availableMovePath(){
		this.setBackground(Color.RED);
	}
	
	public boolean getOccupied(){
		return isOccupied;
	}
}
