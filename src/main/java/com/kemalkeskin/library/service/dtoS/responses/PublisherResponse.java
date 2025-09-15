package com.kemalkeskin.library.service.dtoS.responses;

public class PublisherResponse {

    private int id;

    private String publisherName;

    public PublisherResponse() {
    }

    public PublisherResponse(int id, String publisherName) {
        this.id = id;
        this.publisherName = publisherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
