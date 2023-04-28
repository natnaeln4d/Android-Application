package com.example.leeogezba;

public class User {
    int _id;
    String fullName;

    String work;
    String address;
    String _email;
    int photoUrl;
    public User(int id, String fullName, String work, String address, int photoUrl){
        this._id = id;
        this.address= address;
        this.fullName=fullName;
        this.work=work;
        this.photoUrl= photoUrl;

    }




    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }


    public String get_name() {
        return fullName;
    }

    public void set_name(String _name) {
        this.fullName = _name;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getWork() {
        return work;
    }

    public String getAddress() {
        return address;
    }

    public int getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(int photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
