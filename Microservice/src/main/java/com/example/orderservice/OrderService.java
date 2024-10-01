package com.example.orderservice;

import com.example.orderservice.Order;
import com.example.orderservice.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  // Place an order
  public Order placeOrder(Order order) {
    order.setStatus("PENDING");
    order.setCreatedDate(new java.util.Date());
    return orderRepository.save(order);
  }

  // Get order by ID
  public Optional<Order> getOrderById(Long id) {
    return orderRepository.findById(id);
  }

  // Get all orders
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  // Update order status
  public Order updateOrderStatus(Long id, String status) {
    Optional<Order> orderOpt = orderRepository.findById(id);
    if (orderOpt.isPresent()) {
      Order order = orderOpt.get();
      order.setStatus(status);
      return orderRepository.save(order);
    }
    return null;
  }

  // Cancel order
  public void cancelOrder(Long id) {
    orderRepository.deleteById(id);
  }
}
