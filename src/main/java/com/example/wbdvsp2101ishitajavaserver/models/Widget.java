package com.example.wbdvsp2101ishitajavaserver.models;
import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String type;
    private Integer size;
    private String text;
    private String src;
    private Integer width, height;
    private Boolean ordered;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String name;


    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    private String topicId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Widget() {
    }

    public Widget(Long id, String topicId, String type, Integer size, String text) {
        this.id = id;
        this.topicId = topicId;
        this.type = type;
        this.size = size;
        this.text = text;
    }
}


   /* create table widgets (
        id bigint not null auto_increment,
        height integer,
        ordered bit not null,
        size integer,
        src varchar(255),
    text varchar(255),
    topic_id varchar(255),
    type varchar(255),
    width integer,
    primary key (id)
    ) engine=InnoDB


       alter table widgets
       add column name varchar(255)
*/