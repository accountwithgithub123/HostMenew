package com.example.hostme;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;

public class TourismPlaces implements Parcelable {
    private String placeName;
    private Integer imgURl;
//    private LatLng latLng;
    private double latitude, longitude;


//    public TourismPlaces(String placeName, Integer imgURl, LatLng latLng) {
//        this.placeName = placeName;
//        this.imgURl = imgURl;
//        this.latLng = latLng;
//    }

    public TourismPlaces(String placeName, Integer imgURl, double latitude, double longitude) {
        this.placeName = placeName;
        this.imgURl = imgURl;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    protected TourismPlaces(Parcel in) {
        placeName = in.readString();
        if (in.readByte() == 0) {
            imgURl = null;
        } else {
            imgURl = in.readInt();
        }
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    public static final Creator<TourismPlaces> CREATOR = new Creator<TourismPlaces>() {
        @Override
        public TourismPlaces createFromParcel(Parcel in) {
            return new TourismPlaces(in);
        }

        @Override
        public TourismPlaces[] newArray(int size) {
            return new TourismPlaces[size];
        }
    };

    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    //    public void setLatLng(LatLng latLng) {
//        this.latLng = latLng;
//    }

//    public LatLng getLatLng() {
//        return latLng;
//    }




    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getImgURl() {
        return imgURl;
    }

    public void setImgURl(Integer imgURl) {
        this.imgURl = imgURl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(placeName);
        if (imgURl == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imgURl);
        }
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }
}
