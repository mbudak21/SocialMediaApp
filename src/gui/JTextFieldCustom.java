package gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JTextFieldCustom extends JTextField {
	
	private String placeHolder;
	private JTextFieldCustom obj;
	JTextFieldCustom(String placeHolder) {
		this.placeHolder = placeHolder;
		this.setText(this.placeHolder);
		this.setForeground(Color.GRAY);
		this.setBorder(new EmptyBorder(1, 1, 1, 1));
		obj = this;
		
		
		this.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (obj.getText().equals(placeHolder)) {
		        	obj.setText("");
		        	obj.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (obj.getText().isEmpty()) {
		        	obj.setForeground(Color.GRAY);
		        	obj.setText(placeHolder);
		        }
		    }
		    }); // End of FocusListener
		
	}// end of constructor
	
	public void runPlaceHolder(FocusEvent e) {
	}
	
    
}
