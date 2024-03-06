package com.mruruc.repositories;

import com.mruruc.models.embeded.Order;
import com.mruruc.models.embeded.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
