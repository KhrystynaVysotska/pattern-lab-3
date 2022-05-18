package ua.lviv.iot.TripadvisorMVC.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.TripadvisorMVC.model.dal.ReviewRepository;
import ua.lviv.iot.TripadvisorMVC.model.domain.Review;

@Service
public class ReviewService extends AbstractService<Review> {


	@Autowired
	public ReviewService(ReviewRepository reviewRepository) {
		super(reviewRepository);
	}
}
