package com.epam.edp.order.repository;

import com.epam.edp.order.model.OrderModel;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderModel, Integer> {
}
