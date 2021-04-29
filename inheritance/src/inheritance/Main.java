package inheritance;

public class Main {

	public static void main(String[] args) {
		
		//A class should be able to do whatever it can do.
		
		//SOLID -> Open Closed Principle
		
		IndividualCustomer engin = new IndividualCustomer();
		engin.customerNumber = "12345";
		
		CorporateCustomer hepsiBurada = new CorporateCustomer();
		hepsiBurada.customerNumber= "78910";
		
		UnionCustomer abc = new UnionCustomer();
		abc.customerNumber = "99999";
		
		//polymorphism : same multiple codes working with same method and different variables.
		CustomerManager customerManager = new CustomerManager();
		//customerManager.add(hepsiBurada);
		//customerManager.add(engin);
		//customerManager.add(abc);
		
		Customer[] customers = {engin, abc, hepsiBurada};
		
		customerManager.addMultiple(customers);

	}

}
