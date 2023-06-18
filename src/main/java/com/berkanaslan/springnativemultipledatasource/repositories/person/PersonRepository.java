package com.berkanaslan.springnativemultipledatasource.repositories.person;

import com.berkanaslan.springnativemultipledatasource.models.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
