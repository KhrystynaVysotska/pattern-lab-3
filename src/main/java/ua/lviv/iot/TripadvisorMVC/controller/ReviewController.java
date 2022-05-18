package ua.lviv.iot.TripadvisorMVC.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ua.lviv.iot.TripadvisorMVC.model.domain.Restaurant;
import ua.lviv.iot.TripadvisorMVC.model.domain.Review;
import ua.lviv.iot.TripadvisorMVC.model.domain.User;
import ua.lviv.iot.TripadvisorMVC.model.service.RestaurantService;
import ua.lviv.iot.TripadvisorMVC.model.service.ReviewService;
import ua.lviv.iot.TripadvisorMVC.model.service.UserService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private UserService userService;

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("/reviews")
	public String getAll(Model model) {
		model.addAttribute("reviews", reviewService.findAll());
		return "reviews";
	}

	@GetMapping("/showNewReviewForm")
	public String showNewReviewForm(Model model) {
		Review review = new Review();
		model.addAttribute("newReview", review);
		return "create_review";
	}

	@GetMapping("/showUpdateReviewForm/{id}")
	public String showUpdateReviewForm(@PathVariable("id") Integer id, Model model) {
		Review review = reviewService.getById(id);
		model.addAttribute("newReview", review);
		return "update_review";
	}

	@PostMapping("/saveReview")
	public String saveReview(@ModelAttribute("newReview") Review review, Model model) {
		User author = userService.getById(review.getAuthor().getId());
		Restaurant restaurant = restaurantService.getById(review.getRestaurant().getId());
		review.setAuthor(author);
		review.setRestaurant(restaurant);
		reviewService.saveToDatabase(review);
		return "redirect:/reviews";
	}

	@GetMapping("/deleteReview/{id}")
	public String deleteReview(@PathVariable("id") Integer id) {
		reviewService.deleteById(id);
		return "redirect:/reviews";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}