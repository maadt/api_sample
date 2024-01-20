package com.example.resource;

// リクエストされたデータを受け取る
// DTO（Data Transfer Object）クラス：異なるソフトウェアアプリケーションやアプリケーションの層間でデータを転送するために使われる

public class RequestItem {
	
    private String name;

    private Integer price;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return this.price;
    }
}
