package com.hcr.swd392g3.project.repository;

import com.hcr.swd392g3.project.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {


    Person getByPersonID(int personID);
	List<Person> findAll();
	Person getPersonByUserName(String userName);
	Person findByUserName(String username);
	Person findByEmail(String email);


}
