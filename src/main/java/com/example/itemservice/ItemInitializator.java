package com.example.itemservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemInitializator {

    private ItemRepository repository;

    public ItemInitializator(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("init")
    public String init(@RequestParam(name = "count", defaultValue = "10") int count) {
        for (int i = 0; i < count; i++) {
            repository.save(new Item("item-" + i, "description of the item-" + i));
        }
        return "Created " + count + " item(s).";
    }

}
