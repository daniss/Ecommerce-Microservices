package com.ecommerce.ecommerce.Order;

import java.util.List;
import com.ecommerce.ecommerce.Order.OrderItem;
import com.ecommerce.ecommerce.User.User;
import com.ecommerce.ecommerce.Order.OrderItem;

import java.util.ArrayList;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(nullable = false)
    private Float totalAmount;

    @Column(nullable = false)
    private String status;  // e.g., "PENDING", "SHIPPED", "DELIVERED", "CANCELLED"

    private LocalDateTime orderDate;
}

