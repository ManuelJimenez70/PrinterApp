package models;

import models.structures.Node;
import models.structures.NotFoundException;
import models.structures.Queue;

public class PrintList {

	private Queue<Print> printList;

	public PrintList() {
		printList = new Queue<>();
		checkActualWork();
	}

	public void addWork(int numPrints) {
		printList.add(new Node<Print>(new Print(numPrints)));
	}

	public Queue<Print> getPrintList() {
		return printList;
	}

	public void deleteWork() {
		try {
			printList.poll();
		} catch (NotFoundException e) {
		}
	}

	public void checkActualWork() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (getActualWork() != null) {
						deleteWork();
					}
				}
			}
		}).start();

	}

	public Node<Print> getActualWork() {
		return printList.peek();
	}

	public boolean isActualWorkDone() {
		if (getActualWork().getData().getActualPrintNum() == null) {
			return true;
		}
		return false;
	}

	public void loadHeaderPrint() {
		printList.peek().getData().loadPrints();
	}

}
