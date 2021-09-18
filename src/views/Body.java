package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.IPrintManager;

public class Body extends JPanel{
	
	private PrintQueue printQueue;
	private AdderPrint adderPrint;
	private PrintShower printShower;

	public Body(ActionListener actionListener) {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(500,400));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.printQueue = new PrintQueue();
		add(printQueue, BorderLayout.WEST);
		
		this.printShower = new PrintShower();
		add(printShower, BorderLayout.EAST);
		
		this.adderPrint = new AdderPrint(actionListener);
		add(adderPrint, BorderLayout.SOUTH);
		
	}

	public String getNumPrints() {
		return adderPrint.getPrintQuantity();
	}

	public void updateView(IPrintManager manager) {
		printQueue.updateView(manager);
		printShower.updateView(manager);
	}
	
}
