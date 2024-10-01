package com.example.orderservice;

import com.example.orderservice.Order;
import com.example.orderservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class Router {

  @Autowired
  private OrderService orderService;

  // Place an order
  @PostMapping
  public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
    return ResponseEntity.ok(orderService.placeOrder(order));
  }

  // Get order by ID
  @GetMapping("/{id}")
  public ResponseEntity<Optional<Order>> getOrderById(@PathVariable Long id) {
    return ResponseEntity.ok(orderService.getOrderById(id));
  }

  // Get all orders
  @GetMapping
  public ResponseEntity<List<Order>> getAllOrders() {
    return ResponseEntity.ok(orderService.getAllOrders());
  }

  // Update order status
  @PutMapping("/{id}/status")
  public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
    return ResponseEntity.ok(orderService.updateOrderStatus(id, status));
  }

  // Cancel order
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> cancelOrder(@PathVariable Long id) {
    orderService.cancelOrder(id);
    return ResponseEntity.noContent().build();
  }
}
