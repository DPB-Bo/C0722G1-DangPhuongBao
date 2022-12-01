package com.codegym.service;

import com.codegym.model.OrderB;

public interface IOrderService {
    boolean existsById(String id);

    void deleteById(String id);

    void save(OrderB order);
}
