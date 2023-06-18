package com.berkanaslan.springnativemultipledatasource;

import com.berkanaslan.springnativemultipledatasource.models.person.Person;
import com.berkanaslan.springnativemultipledatasource.repositories.person.PersonRepository;
import com.berkanaslan.springnativemultipledatasource.repositories.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SpringNativeMultipleDatasourceApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void assertPersonTableIsNotEmpty() {
        Assert.isTrue(personRepository.count() > 0, "Assertion failed. Person table has no record.");
    }

    @Test
    public void assertProductTableIsNotEmpty() {
        Assert.isTrue(productRepository.count() > 0, "Assertion failed. Product table has no record.");
    }

    @Test
    public void assertPersonNameIsEqualBerkan() {
        final Person person  = personRepository.findById(1L).orElse(null);
        Assert.notNull(person, "Assertion failed. No person found with this ID: 1");
        Assert.isTrue("Berkan".equals(person.getName()), "Assertion failed. Person name of ID:1 is not equal 'Berkan'.");
    }
}
