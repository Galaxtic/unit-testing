package com.lemnisk.unittesting.unittesting.data;

import com.lemnisk.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll(){
        List<Item> items = repository.findAll();
        Assertions.assertEquals(3, items.size());
    }
}
