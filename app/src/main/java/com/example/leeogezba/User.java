package com.example.leeogezba;

public class User {
    private int id;
    private String fullName;
    private String job;
    private String address;
    private int photoUrl;

    public User(int id, String fullName, String job, String address, int photoUrl) {
        this.id = id;
        this.fullName = fullName;
        this.job = job;
        this.address = address;
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(int photoUrl) {
        this.photoUrl = photoUrl;
    }
}
