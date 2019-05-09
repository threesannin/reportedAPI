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

    public Form() {
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

    public String getIssueCategory() {
        return issueCategory;
    }

    public void setIssueCategory(String issueCategory) {
        this.issueCategory = issueCategory;
    }

    public String getDirOfTravel() {
        return dirOfTravel;
    }

    public void setDirOfTravel(String dirOfTravel) {
        this.dirOfTravel = dirOfTravel;
    }

    public String getTransMode() {
        return transMode;
    }

    public void setTransMode(String transMode) {
        this.transMode = transMode;
    }

    public String getNearestCrossStreet() {
        return nearestCrossStreet;
    }

    public void setNearestCrossStreet(String nearestCrossStreet) {
        this.nearestCrossStreet = nearestCrossStreet;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
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

    public String getDescripText() {
        return descripText;
    }

    public void setDescripText(String descripText) {
        this.descripText = descripText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isFollowUp() {
        return followUp;
    }

    public void setFollowUp(boolean followUp) {
        this.followUp = followUp;
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