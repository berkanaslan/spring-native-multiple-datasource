package com.berkanaslan.springnativemultipledatasource.repository.person;

import com.berkanaslan.springnativemultipledatasource.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
