package com.cst495.reportedAPI.entities;

public class Form {
    private String issueCategory;
    private String dirOfTravel;
    private String transMode;
    private String nearestCrossStreet;
    private String dateTime;
    private String latitude;
    private String longitude;
    private String descripText;
    private String name;
    private String email;
    private String phone;
    private String descriptionGeoLoc;
    private boolean followUp;

    public Form( ) {
        this.issueCategory = "";
        this.dirOfTravel = "";
        this.transMode = "";
        this.nearestCrossStreet = "";
        this.dateTime = "";
        this.latitude = "";
        this.longitude = "";
        this.descripText = "";
        this.name = "";
        this.followUp = false;
        this.email = "";
        this.phone = "";
        this.descriptionGeoLoc = "";
    }

    public Form(String issueCategory, String dirOfTravel, String transMode,
                String nearestCrossStreet, String dateTime, String latitude,
                String longitude, String descripText, String name, String email,
                String phone, String descriptionGeoLoc, boolean followUp) {
        this.issueCategory = issueCategory;
        this.dirOfTravel = dirOfTravel;
        this.transMode = transMode;
        this.nearestCrossStreet = nearestCrossStreet;
        this.dateTime = dateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descripText = descripText;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.descriptionGeoLoc = descriptionGeoLoc;
        this.followUp = followUp;
    }

    public String getCategory() {
        return issueCategory;
    }

    public void setCategory(String category) {
        this.issueCategory = category;
    }

    public String getDirOfTravel() {
        return dirOfTravel;
    }

    public void setDirOfTravel(String dirOfTravel) {
        this.dirOfTravel = dirOfTravel;
    }

    public String getModeOfTrans() {
        return transMode;
    }

    public void setModeOfTrans(String modeOfTrans) {
        this.transMode = modeOfTrans;
    }

    public String getCrossStreet() {
        return nearestCrossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.nearestCrossStreet = crossStreet;
    }

    public String getDate() {
        return dateTime;
    }

    public void setDate(String date) {
        this.dateTime = date;
    }

    public String getTime() {
        return "000";
    }

//    public void setTime(String time) {
//
//    }

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
        return descripText;
    }

    public void setDescription(String description) {
        this.descripText = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public boolean isReceiveResponse() {
        return followUp;
    }

    public void setReceiveResponse(boolean receiveResponse) {
        this.followUp = receiveResponse;
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
                "issueCategory='" + issueCategory + '\'' +
                ", dirOfTravel='" + dirOfTravel + '\'' +
                ", transMode='" + transMode + '\'' +
                ", nearestCrossStreet='" + nearestCrossStreet + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", descripText='" + descripText + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", descriptionGeoLoc='" + descriptionGeoLoc + '\'' +
                ", followUp=" + followUp +
                '}';
    }
}
