package com.berkanaslan.springnativemultipledatasource;

import com.berkanaslan.springnativemultipledatasource.models.person.Person;
import com.berkanaslan.springnativemultipledatasource.models.product.Product;
import com.berkanaslan.springnativemultipledatasource.repositories.person.PersonRepository;
import com.berkanaslan.springnativemultipledatasource.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class Initializer implements ApplicationListener<ApplicationReadyEvent> {

    private final PersonRepository personRepository;
    private final ProductRepository productRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        savePerson();
        saveProduct();
    }

    private void savePerson() {
        if (personRepository.count() > 0) {
            return;
        }

        personRepository.save(new Person("Berkan", Person.Gender.MALE));
    }

    private void saveProduct() {
        if (productRepository.count() > 0) {
            return;
        }

        productRepository.save(new Product("AZ001", "Razer Kraken V3 PRO", BigDecimal.valueOf(299.90)));
    }
}
