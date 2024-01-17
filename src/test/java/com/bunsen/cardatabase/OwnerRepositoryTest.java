package com.bunsen.cardatabase;

import com.bunsen.cardatabase.domain.Owner;
import com.bunsen.cardatabase.domain.OwnerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class OwnerRepositoryTest {
    @Autowired
    private OwnerRepository repository;

    @Test
    void saveOwner(){
        repository.save(new Owner("Lucy","Smith"));
        Assertions.assertThat(
                repository.findByFirstname("Lucy").isPresent()).isTrue();
    }

    @Test
    void deleteOwners(){
        repository.save(new Owner("Lisa", "Morrison"));
        repository.deleteAll();
        Assertions.assertThat(repository.count()).isEqualTo(0);
    }
}
