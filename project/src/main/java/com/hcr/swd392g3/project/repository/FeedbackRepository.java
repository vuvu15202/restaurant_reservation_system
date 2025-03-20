package com.hcr.swd392g3.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcr.swd392g3.project.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
Feedback findOneByFeedbackID(int feedbackID);
	List<Feedback> findAll();

}