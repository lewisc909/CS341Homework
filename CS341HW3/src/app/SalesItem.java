
package app;
public class SalesItem {
	// model each item on the sales list. a salesitem object should have a name,
	// price and
	// quantity.
	// set, get and calucalations methods
	// write toString method to construct string for a complete salesItem object
	// includes name, price, and quanityt.

	public String name;
	public double price;
	public int quantity;

	public SalesItem(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return price * quantity;
	}

	public String toString() {
		return String.format("%s $%.2f %d", name, price, quantity);
	}
}
