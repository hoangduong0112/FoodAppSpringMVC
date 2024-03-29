/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hd.service.impl;

import com.hd.pojo.OrderItems;
import com.hd.repository.OrderItemRepository;
import com.hd.service.OrderItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duong Hoang
 */
@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public List<OrderItems> getOrderItemsByOrderId(int orderId) {
        return this.orderItemRepository.getOrderItemsByOrderId(orderId);
    }

    @Override
    public List<OrderItems> getOrderItemsByStoreId(int storeId, String status) {
        return this.orderItemRepository.getOrderItemsByStoreId(storeId, status);
    }

    @Override
    public OrderItems getOrderById(int id) {
        return this.orderItemRepository.getOrderById(id);
    }

    @Override
    public Boolean updateStatusAccept(int itemId) {
        return this.orderItemRepository.updateStatusAccept(itemId);
    }

    @Override
    public Boolean updateStatusDecline(int itemId) {
        return this.orderItemRepository.updateStatusDecline(itemId);
    }
    
    
    
}
