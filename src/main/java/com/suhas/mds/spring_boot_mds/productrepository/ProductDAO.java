package com.suhas.mds.spring_boot_mds.productrepository;

import com.suhas.mds.spring_boot_mds.productentity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends JpaRepository<Product,Integer> {
}
