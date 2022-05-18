package ua.lviv.iot.TripadvisorMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ua.lviv.iot.TripadvisorMVC.model.domain.Contact;
import ua.lviv.iot.TripadvisorMVC.model.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/contacts")
	public String getAll(Model model) {
		model.addAttribute("contacts", contactService.findAll());
		return "contacts";
	}

	@GetMapping("/showNewContactForm")
	public String showNewContactForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "create_contact";
	}

	@GetMapping("/showUpdateContactForm/{id}")
	public String showUpdateContactForm(@PathVariable("id") Integer id, Model model) {
		Contact contact = contactService.getById(id);
		model.addAttribute("contact", contact);
		return "update_contact";
	}

	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contact") Contact contact, Model model) {
		contactService.saveToDatabase(contact);
		return "redirect:/contacts";
	}
	
	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable("id") Integer id) {
		contactService.deleteById(id);
		return "redirect:/contacts";
	}
}