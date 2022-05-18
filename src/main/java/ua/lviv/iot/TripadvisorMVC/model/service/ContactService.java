package ua.lviv.iot.TripadvisorMVC.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.TripadvisorMVC.model.dal.ContactRepository;
import ua.lviv.iot.TripadvisorMVC.model.domain.Contact;

@Service
public class ContactService extends AbstractService<Contact> {

	@Autowired
	public ContactService(ContactRepository repository) {
		super(repository);
	}
}
