package com.dinhtrongdat.truyencuoi.model;

import java.io.Serializable;

public class StoryEntity implements Serializable {
    private String topicName;
    private String name;
    private String content;

    public StoryEntity(String topicName, String name, String content) {
        this.topicName = topicName;
        this.name = name;
        this.content = content;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
