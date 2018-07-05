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

public class GUIChessBoard extends JPanel{
	
	public Image img;
	public GUITile[][] tileList = new GUITile[8][8];
	
	public GUIChessBoard(){
		System.out.println("Board GUI is being setup");		
		
		this.setLayout(new GridLayout(8, 8));

		//Due to how gridlayout adds objects left to right, bottom to top, j and i are switched
		for(int i = 7; i >= 0; i--)
			for(int j = 0; j < 8; j++){
			tileList[j][i] = new GUITile();
			if(((i+j)%2) == 0){
				tileList[j][i].setBackground(Color.LIGHT_GRAY);
			}else{
				tileList[j][i].setBackground(Color.WHITE);
			}
			this.add(tileList[j][i]);
		}

	    
        this.setVisible(true);
        
       
	}
	
	public void setPiece(int i, int j, Piece_Rank rank){
		System.out.println(rank +" " + i + j);
		tileList[i][j].addPiece(rank, Colour.BLACK);
		
	}

	
}
