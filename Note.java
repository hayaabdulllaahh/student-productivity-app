package com.example.projectmap;

import java.io.Serializable;
public class Note implements Serializable {
    private String title;
    private String content;
    private long timestamp;


    public Note() {}


    public Note(String title, String content, long timestamp) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }


    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }


    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}