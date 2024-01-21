package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Item;
import com.example.resource.RequestItem;
import com.example.service.ItemService;

@RestController
// @RestController：全てのメソッドは@ResponseBodyを設定した時と同じようにreturn値がレスポンスボディとして扱われます
// @ResponseBody：テンプレートを返さずreturn文がそのまま結果として表示される
@RequestMapping(value = "/item", produces="application/json;charset=UTF-8")
// value：応答するリクエストのパスを定義する
// produces：クライアントへのレスポンス方法を定義する
// application/json：JSON形式のデータを返す
// charset=UTF-8：UTF-8でエンコーディングする
public class ItemController {

    private final ItemService itemService;

    @Autowired
    // ItemServiceをインジェクションします
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // データ取得用のWeb APIです
    @GetMapping("/list")
    public List<Item> list() {
        // List<Item>の形式で取得した値を返します
        return this.itemService.findAll();
    }
    
    @PostMapping("/create")
    // データ保存用のWeb APIです
    public Item create(@RequestBody RequestItem requestItem) {
    // create：CRUD操作のCreate（新規作成）を実行する
    // @RequestBody：JSON形式のデータを受け取る
    // RequestItem requestItem：JSON形式のリクエストボディをRequestItemオブジェクトに変換
        return this.itemService.insert(requestItem);
        // itemService.insert()：ItemServiceクラスのinsert()メソッドを実行する
        // requestItem：受け取ったデータを「requestItem」としてItemServiceクラスに渡す
    }
}