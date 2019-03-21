package com.rainier.prototypepattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Article article = new Article();
        article.setTile("原型模式");
        article.setAuthor("Bobby Zhang");
        article.setContent("设计模式学习系列文章");
        article.setPublishDate(new Date());
        List<String> tags = new ArrayList<>();
        tags.add("设计模式");
        tags.add("原型模式");
        tags.add("面向对象编程");

        article.setTags(tags);

        Article article1 = (Article) article.clone();
        article1.setTile("单例模式");
        article1.getTags().add("单例模式");


        System.out.println("Article:" + article);
        System.out.println("Article1:" + article1);
        System.out.println(article.getTags() == article1.getTags());


        Article article2 = (Article)article.deepClone();
        article2.setTile("工厂模式");
        List<String> tagList = article2.getTags();
        tagList.clear();;
        tags.add("工厂模式");
        article2.setTags(tagList);
        System.out.println("Article2:" + article2);
        System.out.println(article.getTags() == article2.getTags());

    }
}
