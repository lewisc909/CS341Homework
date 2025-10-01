package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.SalesSlip;
import app.SalesItem;

class SalesSlipTest {

	private SalesSlip salesSlip;
	@Test
	void testAddItemAndTotal() {
		salesSlip=new SalesSlip();
		SalesItem item1=new SalesItem("Apple",0.5,2);//name,qty,price
		SalesItem item2=new SalesItem("Banana",0.75,3);
		salesSlip.addItem(item1);
		salesSlip.addItem(item2);
		assertEquals(3.25,salesSlip.getTotalSales(),0.001);
		
	}
	@Test
	void testToString() {
		salesSlip=new SalesSlip();
		SalesItem item1=new SalesItem("Apple",0.5, 2);//name,qty,price
		SalesItem item2=new SalesItem("Banana",0.75, 3);
		salesSlip.addItem(item1);
		salesSlip.addItem(item2);
		String expected="Apple $0.50 2\nBanana $0.75 3\n";
		assertEquals(expected,salesSlip.toString());
		
	}
	@Test
	void testEmptySalesSlip() {
		salesSlip=new SalesSlip();
		assertEquals(0.0,salesSlip.getTotalSales(),0.001);
		assertEquals("",salesSlip.toString());
	}

}
