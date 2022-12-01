package com.codegym.service.impl;

import com.codegym.model.OrderB;
import com.codegym.repository.OrderRepository;
import com.codegym.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean existsById(String id) {
        return orderRepository.existsById(id);

    }

    @Override
    public void deleteById(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void save(OrderB order) {
        orderRepository.save(order);
    }
}
