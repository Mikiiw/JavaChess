import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InfoPanel extends JPanel {

	private JTextArea testText;
	
	public InfoPanel(){
		testText = new JTextArea(4, 38);
		JButton testButton = new JButton("Test");
		  testButton.setBounds(50,100,95,30);
		
		this.add(testButton);
		this.setVisible(true);
		this.add(testText);
		
		testText.setSize(800,800);
	}
	
	public void setTextBox(String a){
		testText.setText(a);
	}
}
