package models;

import models.structures.Queue;

public interface IPrintManager {
	
	public Queue<Print> getPrints();
	
	public int getPrintListSize();
	
	public void loadHeaderPrint();
	
}
