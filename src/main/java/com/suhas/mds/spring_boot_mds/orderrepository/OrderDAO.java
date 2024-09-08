package com.suhas.mds.spring_boot_mds.orderrepository;

import com.suhas.mds.spring_boot_mds.orderentity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<Order,Integer> {
}
