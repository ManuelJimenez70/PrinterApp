package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.IPrintManager;
import models.Print;
import models.structures.Node;

public class PrintShower extends JPanel {

	private static final String PAPER_IMAGE = "/resources/images/paper.png";

	private static final int PADDING = 100;

	public BufferedImage canvas;

	public PrintShower() {
		setPreferredSize(new Dimension(390, 530));
		setSize(new Dimension(390, 530));
		canvas = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
	}

	public void updateView(IPrintManager manager) {
		paintBackgroud();
		paintPrint(manager);
		repaint();
	}

	private void paintPrint(IPrintManager manager) {
		Graphics g = canvas.getGraphics();
		Image paper = new ImageIcon(Toolkit.getDefaultToolkit().getImage(View.class.getResource(PAPER_IMAGE)))
				.getImage();
		g.drawImage(paper, PADDING/2, PADDING/2, getWidth()-PADDING, getHeight()-PADDING, this);
		Node<Print> actual = manager.getPrints().peek();
		if (actual != null) {
			showPrint(actual.getData().getActualPrintNum().getData());
		}
	}

	private void showPrint(Integer data) {
		Graphics g = canvas.getGraphics();
		g.setColor(Color.WHITE);
		g.setFont(new Font("SansSerif", Font.BOLD, 28));
		g.fillRect((getWidth()/2)-20, (getHeight()/2)-20, 20, 20);
		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(data), (getWidth()/2)-10, (getHeight()/2)-10);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(canvas, 0, 0, this);
	}

	private void paintBackgroud() {
		Graphics g = canvas.getGraphics();
		g.setColor(Color.decode("#161B22"));
		g.fillRect(15, 0, 5, getHeight());

	}

}
