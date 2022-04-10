package com.practice.java.model;

import java.util.List;

public class MovieSummary {

    private String id;
    private String title;
    private String overview;
    CollectionList belongs_to_collection;

    public CollectionList getBelongs_to_collection() {
        return new CollectionList();
    }

    public void setBelongs_to_collection(CollectionList belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
