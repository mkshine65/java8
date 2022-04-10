package com.practice.java.model;

public class Movie {

    String id;
    String overView;

    public Movie() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public Movie(String id, String overView) {
        this.id = id;
        this.overView = overView;
    }
}
