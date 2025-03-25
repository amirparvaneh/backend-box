package com.snapp.backend_box.repository;

import com.snapp.backend_box.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryRepo extends JpaRepository<Delivery,Long> {
}
