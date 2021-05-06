package nLayeredDemo.business.concretes;

import java.util.List;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.concretes.AbcProductDao;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.enitites.concretes.Product;
import nLayeredDemo.jLogger.jLoggerManager;

public class ProductManager implements ProductService{
	
	private AbcProductDao productDao;
	private LoggerService loggerService;
	
	public ProductManager(AbcProductDao productDao, LoggerService loggerService) {
		super();
		this.productDao = productDao;
		this.loggerService = loggerService;
	}

	@Override
	public void add(Product product) {
		if(product.getCategoryId() == 1 ) {
			System.out.println("Bu kategoride �r�n kabul edilmiyor.");
			return;
		}
		

		this.productDao.add(product);
		this.loggerService.logToSystem("�r�n eklendi : " + product.getName());;
	
		
		//�al���r ama do�ru bir sistem de�il. 
		//Alternatif sistem dahil edilemez.
		//HibernateProductDao dao = new HibernateProductDao();
		//dao.add(product);
		
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
