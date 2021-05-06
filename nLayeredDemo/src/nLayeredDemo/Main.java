package nLayeredDemo;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.business.concretes.ProductManager;
import nLayeredDemo.core.JLoggerManagerAdapter;
import nLayeredDemo.dataAccess.concretes.AbcProductDao;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.enitites.concretes.Product;
import nLayeredDemo.jLogger.jLoggerManager;

public class Main {

	public static void main(String[] args) {
		
		//Entity hari� new yapma ilerisi i�in s�k�nt�.
		
		//ToDo: Spring IoC ile ��z�lecek
		ProductService productService = new ProductManager(new AbcProductDao(),
														   new JLoggerManagerAdapter());
		
		Product product = new Product(1,2,"Elma",12,50);
		
		productService.add(product);
		
	}

}
