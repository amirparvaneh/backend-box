package com.snapp.backend_box.repository;

import com.snapp.backend_box.model.Biker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BikerRepo extends JpaRepository<Biker,Long> {
}
