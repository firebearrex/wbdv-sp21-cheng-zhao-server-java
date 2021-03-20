package com.example.wbdvsp2102chengserverjava.models;

public class Widget {
    private String name;
    private Integer id;
    private String type;
    private Integer widgetOrder;
    private String text;
    private String src;
    private Integer size;
//    private String topicId;
    private Integer width;
    private Integer height;
    private String cssClass;
    private String style;
    private String value;
    private String topicId;

    public Widget() {
    }

    public Widget(Integer id, String topicId, String type, Integer size, String text) {
        this.id = id;
        this.topicId = topicId;
        this.type = type;
        this.size = size;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
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
}
