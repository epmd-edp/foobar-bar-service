package com.epam.edp.order.repository;

import com.epam.edp.order.model.SimpleMessageModel;
import org.springframework.data.repository.CrudRepository;

public interface SimpleMessageRepository extends CrudRepository<SimpleMessageModel, Integer> {
}
