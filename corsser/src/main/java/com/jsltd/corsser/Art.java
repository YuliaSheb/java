package com.jsltd.corsser;

public class Art {
    private String id,artName,artCount,price,category,author;

    public Art()
    {

    }

    public Art(String id,String artName, String artCount, String price, String category, String author) {
        this.id = id;
        this.artName = artName;
        this.artCount = artCount;
        this.price = price;
        this.category = category;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public String getArtCount() {
        return artCount;
    }

    public void setArtCount(String artCount) {
        this.artCount = artCount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
