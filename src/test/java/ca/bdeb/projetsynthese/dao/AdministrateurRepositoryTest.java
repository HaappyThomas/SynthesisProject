package ca.bdeb.projetsynthese.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdministrateurRepositoryTest {
    @Autowired
    private AdministrateurRepository administrateurRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll(){
        System.out.println(administrateurRepository.findById(1).get());
    }

}