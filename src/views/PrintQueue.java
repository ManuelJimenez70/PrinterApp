package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import models.IPrintManager;
import models.Print;
import models.structures.Node;

public class PrintQueue extends JPanel {

	private static final int STROKE = 3;
	private static final int PADDING = 10;
	public BufferedImage canvas;

	public PrintQueue() {
		setPreferredSize(new Dimension(210, 530));
		setSize(new Dimension(210, 530));
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		canvas = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(canvas, 0, 0, this);
		g.setColor(Color.decode("#161B22"));
	}

	public void updateView(IPrintManager manager) {
		paintBackgroud();
		paintWorks(manager);
		repaint();
	}

	private void paintWorks(IPrintManager manager) {
		int counter = 0;
		Node<Print> actual = manager.getPrints().peek();
		while (actual != null) {
			printWork(actual.getData().getPrintSize(), counter);
			System.out.println(actual.getData().getPrintSize());
			counter++;
			actual = actual.getNext();
		}

	}

	private void printWork(int printSize, int counter) {
		Graphics g = canvas.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(PADDING, PADDING + PADDING* counter + 70 * counter, getWidth() - 26, 70);
		g.setColor(Color.BLACK);
		g.setFont(new Font("SansSerif", Font.BOLD, 30));
		g.drawString("Trabajo", getWidth() / 4, PADDING + PADDING* counter + 35 + 70 * counter);
		g.setFont(new Font("SansSerif", Font.BOLD, 11));
		g.drawString(String.valueOf(printSize), getWidth() - 10- PADDING*2, 60 + 70 * counter + PADDING* counter);
	}

	private void paintBackgroud() {
		Graphics g = canvas.getGraphics();
		g.setColor(Color.decode("#0D1117"));
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}
