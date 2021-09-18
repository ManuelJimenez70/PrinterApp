package models;

import models.structures.Node;
import models.structures.NotFoundException;
import models.structures.Queue;

public class Print {
	
	private Queue<Integer> prints;
	private int numPrints;
	private boolean isLoading;
	
	public Print(int numPrints) {
		this.numPrints = numPrints;
		prints = new Queue<>();
		addPrints(numPrints);
	}

	private void addPrints(int numPrints) {
		for (int i = 0; i < numPrints; i++) {
			prints.add(new Node<Integer>(i+1));
		}
	}
	
	public int getPrintSize() {
		return numPrints;
	}
	
	
	public Node<Integer> getActualPrintNum(){
		return prints.peek();
	}
	
	public void loadPrints() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (prints.peek()!= null) {
					try {
						Thread.sleep(1000*numPrints);
						prints.poll();
					} catch (NotFoundException | InterruptedException e) {
					}
				}				
			}
		}).start();
		
	}

	public boolean isLoading() {
		return isLoading;
	}
	
	public void setLoading(boolean isLoading) {
		this.isLoading = isLoading;
	}
}
