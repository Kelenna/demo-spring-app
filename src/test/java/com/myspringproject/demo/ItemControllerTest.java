package com.myspringproject.demo;

import com.myspringproject.demo.entity.Item;
import com.myspringproject.demo.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ItemControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        itemRepository.deleteAll();
    }

    @Test
    void testAddAndGetItem() {
        Item newItem = new Item();
        newItem.setName("Integration Test Item");
        newItem.setDescription("Integration Test Description");

        ResponseEntity<Item> response = restTemplate.postForEntity("/api/items", newItem, Item.class);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("Integration Test Item", response.getBody().getName());

        Item[] items = restTemplate.getForObject("/api/items", Item[].class);
        Assertions.assertEquals(1, items.length);
    }
}
