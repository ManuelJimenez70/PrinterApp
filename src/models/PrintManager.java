package models;

import models.structures.Queue;

public class PrintManager implements IPrintManager{
	
	private PrintList list;
	
	public PrintManager() {
		list = new PrintList();
	}

	@Override
	public Queue<Print> getPrints() {
		return list.getPrintList();
	}

	@Override
	public int getPrintListSize() {
		return list.getPrintList().getSize();
	}

	@Override
	public void loadHeaderPrint() {
		if (list.getActualWork()!= null && !list.getActualWork().getData().isLoading()  ) {
			list.loadHeaderPrint();
			if (list.isActualWorkDone()) {
				list.deleteWork();
			}
		}
	}

	public void addWork(int numPrints) {
		list.addWork(numPrints);
	}

}
