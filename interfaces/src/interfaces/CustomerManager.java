package interfaces;

public class CustomerManager {
	
	private Logger[] loggers;
	
	public CustomerManager(Logger[] loggers) {
		this.loggers = loggers;
	}

	//loosly coupled  : gevþek baðlý --> bu hale döndürülmeli
	//tightly coupled : katý baðlý
	
	public void add(Customer customer) {
		System.out.println("Müþteri eklendi " +customer.getFirstName());
		
		Utils.runLoggers(loggers, customer.getFirstName());
	}
	
	public void delete(Customer customer) {
		System.out.println("Müþteri silindi " +customer.getFirstName());
		
		Utils.runLoggers(loggers, customer.getLastName());
	}
}
