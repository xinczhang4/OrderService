package com.example.orderservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  // Use customerId as a plain field without @ManyToOne annotation
  private Long customerId;

//  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//  private List<Map<String, Integer>> orderItems = new ArrayList<>();

  private Double totalAmount = 0.0;

  private String status;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  // Getters and Setters
  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long id) {
    this.orderId = id;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

//  public List<Map<String, Integer>> getOrderItems() {
//    return orderItems;
//  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }


//  // Method to add or update product quantity in the list of maps
//  public void addProduct(List<Map<String, Integer>> orderItems, String productId, int quantity) {
//    boolean productExists = false;
//
//    // Iterate over the list to find if the productId already exists
//    for (Map<String, Integer> item : orderItems) {
//      if (item.containsKey(productId)) {
//        // Update the quantity of the existing product
//        int updatedQuantity = item.get(productId) + quantity;
//        item.put(productId, updatedQuantity);
//        productExists = true;
//        break;
//      }
//    }
//
//    // If product doesn't exist in the list, add a new entry
//    if (!productExists) {
//      Map<String, Integer> newItem = new HashMap<>();
//      newItem.put(productId, quantity);
//      orderItems.add(newItem);
//    }
//  }
//
//  // Method to deduct quantity or remove product from the list of maps
//  public static void removeProduct(List<Map<String, Integer>> orderItems, String productId) {
//    // Iterate through the list to find the productId
//    Iterator<Map<String, Integer>> iterator = orderItems.iterator();
//
//    while (iterator.hasNext()) {
//      Map<String, Integer> item = iterator.next();
//
//      if (item.containsKey(productId)) {
//        int currentQuantity = item.get(productId);
//
//        if (currentQuantity > 1) {
//          // Deduct the quantity
//          item.put(productId, currentQuantity - 1);
//        } else {
//          // Remove the product if the quantity is less than or equal to the deduction
//          iterator.remove();
//        }
//        break;
//      }
//    }
//  }
}
