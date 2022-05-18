package ua.lviv.iot.TripadvisorMVC.model.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.TripadvisorMVC.model.domain.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}