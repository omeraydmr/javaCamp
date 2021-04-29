package inheritance2;

public class CustomerManager {
	
	public void add(Logger logger) {
		
		//adding customer codes
		System.out.println("Müþteri eklendi.");	
		
		//not necessarily the new Logger because we gave input Logger logger
		logger.log();
	}
}
