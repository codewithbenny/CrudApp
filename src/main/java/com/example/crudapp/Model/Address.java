package com.example.crudapp.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zipcodes")
public class Address {
    public Address() {
    }

    @Id
    @Column(name="zip")
    int zip;
    @Column(name="city")
    String city;
    @Column(name="state")
    String state;
    @Column(name="latitude")
    float latitude;
    @Column(name="longitude")
    float longitude;
    @Column(name="timezone")
    int timezone;
    @Column(name="dst")
    int dst;


    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getDst() {
        return dst;
    }

    public void setDst(int dst) {
        this.dst = dst;
    }



    public Address(int zip, String city, int dst, float latitude, float longitude, int timezone) {
    }


    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public Address(int zip, String city, String state, int latitude, int longitude, int timezone, int dst) {
        this.zip = zip;
        this.city = city;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.dst = dst;
    }
}
