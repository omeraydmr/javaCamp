package interfaces;

public class CustomerManager {
	
	private Logger[] loggers;
	
	public CustomerManager(Logger[] loggers) {
		this.loggers = loggers;
	}

	//loosly coupled  : gev�ek ba�l� --> bu hale d�nd�r�lmeli
	//tightly coupled : kat� ba�l�
	
	public void add(Customer customer) {
		System.out.println("M��teri eklendi " +customer.getFirstName());
		
		Utils.runLoggers(loggers, customer.getFirstName());
	}
	
	public void delete(Customer customer) {
		System.out.println("M��teri silindi " +customer.getFirstName());
		
		Utils.runLoggers(loggers, customer.getLastName());
	}
}
