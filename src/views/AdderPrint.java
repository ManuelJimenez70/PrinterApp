package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import presenters.Events;

public class AdderPrint extends JPanel{

	private static final int STROKE = 3;
	private JButton btadder;
	private JTextField adder;

	public AdderPrint(ActionListener actionListener) {
		setPreferredSize(new Dimension(View.WIDTH, 70));
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
		initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		this.btadder = new JButton("Añadir");
		btadder.setFocusable(false);
		btadder.setToolTipText("Añade la cantidad de Paguinas");
		btadder.setFont(new Font("SansSerif", Font.BOLD, 15));
		btadder.setPreferredSize(new Dimension(80,40));
		btadder.addActionListener(actionListener);
		btadder.setActionCommand(Events.ADD_PRINT);
		btadder.setHorizontalAlignment(SwingConstants.CENTER);
		add(btadder);
		
		this.adder = new JTextField();
		adder.setDocument(new AdderPrint.JTextFieldLimit(2));
		adder.setPreferredSize(new Dimension(80,40));
		adder.setFont(new Font("SansSerif", Font.BOLD, 23));
		adder.setToolTipText("Añade la cantidad de Paguinas");
		adder.setHorizontalAlignment(SwingConstants.CENTER);
		adder.setBackground(Color.decode("#0D1117"));
		adder.setForeground(Color.WHITE);
		add(adder);
	}
	
	public String getPrintQuantity() {
		return adder.getText();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.decode("#161B22"));
		g.fillRect(0, 0, getWidth(), STROKE);
	}
	
	class JTextFieldLimit extends PlainDocument {
		  private int limit;

		  JTextFieldLimit(int limit) {
		   super();
		   this.limit = limit;
		   }

		  public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
		    if (str == null) return;

		    if ((getLength() + str.length()) <= limit) {
		      super.insertString(offset, str, attr);
		    }
		  }
		}
}
