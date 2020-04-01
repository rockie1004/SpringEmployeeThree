package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
