package com.verizon.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.verizon.dao.ProductDao;
import com.verizon.model.Product;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductService {
	@Autowired
	ProductDao productDao;
	public String addProduct(Product product) {
		productDao.save(product);
		return "Added";
	}
	public   List<Product> getProducts() {
		//
		List<Product> productList=productDao.findAll();
		return productList;
	}
	public Product updatePlan(Integer pid,Product product) {
		Product pro=productDao.findById(pid).get();
		pro.setPrice(product.getPrice());
		
		return productDao.findById(pid).get();
	}
	public Product deletePlan(Integer pid) {
		Product pro2=productDao.findById(pid).get();
		if(pid!=null)
			productDao.deleteById(pid);
		return pro2;
		}
	}
