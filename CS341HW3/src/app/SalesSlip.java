package app;

import java.util.ArrayList;
public class SalesSlip {
	// Mode list of items
	// use arraylist or linked list to create the SalesItem objects as they are
	// added
	// to the list.
	// use methods for adding sales item, computing total sales
	// write toString method construct the complete list of sales items.
	private ArrayList<SalesItem> items;

	public SalesSlip() {
		items = new ArrayList<SalesItem>();
	}

	public void addItem(SalesItem item) {
		items.add(item);
	}

	public double getTotalSales() {
		double total = 0;
		for (SalesItem item : items) {
			total += item.getTotal();
		}
		return total;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (SalesItem item : items) {
			sb.append(item.toString()).append("\n");
		}
		//sb.append(String.format("Total Sales: $%.2f", getTotalSales()));
		return sb.toString();
	}
}
