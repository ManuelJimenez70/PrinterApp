package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import models.PrintManager;
import views.View;

public class Presenter implements ActionListener {

	private View view;
	private PrintManager manager;

	public Presenter() {
		this.manager = new PrintManager();
		this.view = new View(this);
		updateView();
	}
	


	private void updateView() {
		final Timer timerUpdater = new Timer(1, e -> {
			if (view.isVisible()) {
				manager.loadHeaderPrint();
				view.updateView(manager);
			}else {
				((Timer) e.getSource()).stop();
			}
		});
		timerUpdater.start();		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Events.ADD_PRINT:
			int numPrints = Integer.parseInt(view.getNumPrints());
			manager.addWork(numPrints);
			break;
		default:
			break;
		}
	}

}
