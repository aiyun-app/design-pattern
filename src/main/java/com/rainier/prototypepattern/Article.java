package com.rainier.prototypepattern;

import java.io.*;
import java.util.Date;
import java.util.List;

public class Article implements Prototype, Serializable {

    private String tile;
    private String author;
    private String content;
    private Date publishDate;

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    private List<String> tags;

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public Prototype clone() {
        Article article = new Article();
        article.setTile(this.tile);
        article.setAuthor(this.author);
        article.setContent(this.content);
        article.setPublishDate(new Date());
        article.setTags(this.tags);
        return article;
    }

    @Override
    public Prototype deepClone() {
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Article article = (Article)ois.readObject();
            article.setPublishDate(new Date());
            return article;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
