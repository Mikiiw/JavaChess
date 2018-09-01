import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enums.Colour;
import Enums.Piece_Rank;
import Pieces.Piece;

public class GUIChessBoard extends JPanel{
	
	public Image img;
	public GUITile[][] tileList = new GUITile[8][8];
	public BoardLogic Chessboard = new BoardLogic();
	public String state = "unclicked";
	
	public int lastClicked_x, lastClicked_y;
	public Piece lastClicked_Piece;
	
	public GUIChessBoard(){
		System.out.println("Board GUI is being setup");		
				
		this.setLayout(new GridLayout(8, 8));
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++){
			tileList[j][i] = new GUITile();
		}	
		
		this.resetGridColour();

		Chessboard.setupBoard();
		
//		Chessboard.setPiece(0, 4, Piece_Rank.KING, Colour.WHITE);
		
		for ( int i = 0; i < 8; i++ )
			for ( int j = 0; j < 8; j++ ){
				Piece temp_piece = Chessboard.getPiece(i, j);
				System.out.println(i + " " + j);
				if (temp_piece != null){
					tileList[i][j].addPiece(temp_piece.getRank(), temp_piece.getColour());
				}else
					tileList[i][j].addPiece(Piece_Rank.EMPTY, Colour.WHITE);
			}	
	    
        this.setVisible(true);
        

		this.addMouseListener(new MouseAdapter(){
			Color background;
			
			 public void mousePressed(MouseEvent e) {
				 //System.out.println(e.getX() + " " + e.getY());
				 //fix this
				 int pos_x = (e.getX() / 70);
				 int pos_y = 7 - ((e.getY() / 70)) ;
				 tileList[pos_x][pos_y].tileClicked();
				 
				 switch (state){
				 case "unclicked":
					 // System.out.println(pos_x + " " + pos_y);
					 
					 if (tileList[pos_x][pos_y].getOccupied() == true){
						 lastClicked_x = pos_x;
						 lastClicked_y = pos_y;
						 lastClicked_Piece = Chessboard.getPiece(pos_x, pos_y);
						 
						 System.out.println("New Piece Clicked");
						 ArrayList<String> legalMoves = Chessboard.getLegalMoves(pos_x, pos_y);
						 System.out.println("Available moves: " + legalMoves.size());
						 state = "clicked";
						 for(int i = 0; i < legalMoves.size(); i++){
							 tileList[Integer.parseInt(legalMoves.get(i).substring(0, 1))][Integer.parseInt(legalMoves.get(i).substring(1, 2))].availableMovePath();
							 }
						 }
					 repaint();
					 break;
				 case "clicked":
					 if (tileList[pos_x][pos_y].getBackground() == Color.RED ){
						 tileList[pos_x][pos_y].addPiece(lastClicked_Piece.getRank(), lastClicked_Piece.getColour());
						 
						 Chessboard.setPiece(pos_x, pos_y, lastClicked_Piece.getRank(), lastClicked_Piece.getColour());
						 Chessboard.removePiece(lastClicked_x, lastClicked_y);
						 tileList[lastClicked_x][lastClicked_y].removePiece();
						 Chessboard.displayBoard();
						 resetGridColour();
					 }else{
						 resetGridColour();
					 }
					 state = "unclicked";
					 break;
				 }
				 System.out.println("Mouse state is: " + state);
				 }

	            @Override
	            public void mouseReleased(MouseEvent e) {
	                //setBackground(background);
	            }
		});		
		
		Chessboard.displayBoard();
       
	}

	
	public void resetGridColour(){
		//Due to how gridlayout adds objects left to right, bottom to top, j and i are switched
		System.out.println("Resetting grid colour");
		for(int i = 7; i >= 0; i--)
			for(int j = 0; j < 8; j++){
			if(((i+j)%2) == 0){
				tileList[j][i].setBackground(Color.LIGHT_GRAY);
			}else{
				tileList[j][i].setBackground(Color.WHITE);
			}
			this.add(tileList[j][i]);
		}		
	}
	
	

	
}
