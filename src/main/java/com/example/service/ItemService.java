package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Item;
import com.example.repository.ItemRepository;
import com.example.resource.RequestItem;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    // 商品の取得結果をレスポンスしたい
    public List<Item> findAll() {
        return this.itemRepository.findAll();
    }
    
    public Item insert(RequestItem requestItem) {
        Item item = new Item(); // Entityクラスのインスタンスを生成
        item.setName(requestItem.getName()); // リクエストされたデータをEntityクラスにセット
        item.setPrice(requestItem.getPrice());
        return this.itemRepository.save(item); // Entityクラスをもとに、データベースにデータを保存
    }
}