package com.suhas.mds.spring_boot_mds;


import com.suhas.mds.spring_boot_mds.orderentity.Order;
import com.suhas.mds.spring_boot_mds.orderrepository.OrderDAO;
import com.suhas.mds.spring_boot_mds.productentity.Product;
import com.suhas.mds.spring_boot_mds.productrepository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootMdsApplication implements CommandLineRunner {

	@Autowired
	ProductDAO productDAO;
	@Autowired
	OrderDAO orderDAO;

/*	@Autowired
	Student student;*/

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMdsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("*******Inserting Product************");
		Product product = new Product(2,"Watch using Custom EntityManager ",555);
		productDAO.save(product);
		System.out.println("**********Product Inserted Successfully*****");

		System.out.println("****Inserting Order********");
		Order order = new Order(17,"Ordered smart watch Custom EntityManager", LocalDate.now());
		orderDAO.save(order);
		System.out.println("**********Order Inserted*********");

		/*System.out.println("Printing Student Map");
		Map<String,String> stMap = student.getStudentMap();
		for(String key:stMap.keySet()){
			System.out.println(key + "  " + stMap.get(key));
		}*/
	}
}
