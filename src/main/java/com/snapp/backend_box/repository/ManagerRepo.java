package com.snapp.backend_box.repository;

import com.snapp.backend_box.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManagerRepo extends JpaRepository<Manager,Long> {
    Manager findByUserName(String userName);
}
