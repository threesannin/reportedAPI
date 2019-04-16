package com.cst495.reportedAPI.entities;

public class Form {
    private String category;
    private String dirOfTravel;
    private String modeOfTrans;
    private String crossStreet;
    private String date;
    private String time;
    private String latitude;
    private String longitude;
    private String description;
    private String name;
    private String email;
    private String phone;
    private String descriptionGeoLoc;
    private boolean receiveResponse;

    public Form( ) {
        this.category = "";
        this.dirOfTravel = "";
        this.modeOfTrans = "";
        this.crossStreet = "";
        this.date = "";
        this.time = "";
        this.latitude = "";
        this.longitude = "";
        this.description = "";
        this.name = "";
        this.receiveResponse = false;
        this.email = "";
        this.phone = "";
        this.descriptionGeoLoc = "";
    }

    public Form(String category, String dirOfTravel, String modeOfTrans, String crossStreet,
                String date, String time, String latitude, String longitude, String description,
                String username, boolean receiveResponse, String email, String phone, String descriptionGeoLoc) {
        this.category = category;
        this.dirOfTravel = dirOfTravel;
        this.modeOfTrans = modeOfTrans;
        this.crossStreet = crossStreet;
        this.date = date;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.name = username;
        this.receiveResponse = receiveResponse;
        this.email = email;
        this.phone = phone;
        this.descriptionGeoLoc = descriptionGeoLoc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirOfTravel() {
        return dirOfTravel;
    }

    public void setDirOfTravel(String dirOfTravel) {
        this.dirOfTravel = dirOfTravel;
    }

    public String getModeOfTrans() {
        return modeOfTrans;
    }

    public void setModeOfTrans(String modeOfTrans) {
        this.modeOfTrans = modeOfTrans;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public boolean isReceiveResponse() {
        return receiveResponse;
    }

    public void setReceiveResponse(boolean receiveResponse) {
        this.receiveResponse = receiveResponse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescriptionGeoLoc() {
        return descriptionGeoLoc;
    }

    public void setDescriptionGeoLoc(String descriptionGeoLoc) {
        this.descriptionGeoLoc = descriptionGeoLoc;
    }

    @Override
    public String toString() {
        return "Form{" +
                "category='" + category + '\'' +
                ", dirOfTravel='" + dirOfTravel + '\'' +
                ", modeOfTrans='" + modeOfTrans + '\'' +
                ", crossStreet='" + crossStreet + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", description='" + description + '\'' +
                ", username='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", descriptionGeoLoc='" + descriptionGeoLoc + '\'' +
                ", receiveResponse=" + receiveResponse +
                '}';
    }
}
