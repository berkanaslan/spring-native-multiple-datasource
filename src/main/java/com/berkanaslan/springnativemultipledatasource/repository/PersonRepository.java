package com.berkanaslan.springnativemultipledatasource.repository;

import com.berkanaslan.springnativemultipledatasource.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
