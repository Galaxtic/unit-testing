package com.lemnisk.unittesting.unittesting.business;

import Business.SomeBusinessImpl;
import Data.SomeDataService;
import com.lemnisk.unittesting.unittesting.data.ItemRepository;
import com.lemnisk.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {
    @InjectMocks
    private ItemBusinessService business;
    @Mock
    private ItemRepository repository;

    @Test
    public void retrieveAllItems_basic() {
        when(repository.findAll()).thenReturn( Arrays.asList(new Item(2, "Item2", 10, 10),
                new Item(3, "Item3", 30, 20)));
        List<Item> items = business.retrieveAllItems();
        Assertions.assertEquals(100, items.get(0).getValue());
        Assertions.assertEquals(600, items.get(1).getValue());
    }

}
