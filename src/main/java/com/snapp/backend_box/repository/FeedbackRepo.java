package com.snapp.backend_box.repository;

import com.snapp.backend_box.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback,Long>, JpaSpecificationExecutor<Feedback> {
}
