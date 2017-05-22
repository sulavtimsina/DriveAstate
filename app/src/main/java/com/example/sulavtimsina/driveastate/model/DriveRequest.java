package com.example.sulavtimsina.driveastate.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Sulav.Timsina on 5/22/2017.
 */

public class DriveRequest implements Parcelable {
    int hr;
    int min;

    int year;
    int month;
    int day;

    String from;
    String to;

    String key,uid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriveRequest)) return false;

        DriveRequest that = (DriveRequest) o;

        if (getHr() != that.getHr()) return false;
        if (getMin() != that.getMin()) return false;
        if (getYear() != that.getYear()) return false;
        if (getMonth() != that.getMonth()) return false;
        if (getDay() != that.getDay()) return false;
        if (getFrom() != null ? !getFrom().equals(that.getFrom()) : that.getFrom() != null)
            return false;
        if (getTo() != null ? !getTo().equals(that.getTo()) : that.getTo() != null) return false;
        if (getKey() != null ? !getKey().equals(that.getKey()) : that.getKey() != null)
            return false;
        return getUid() != null ? getUid().equals(that.getUid()) : that.getUid() == null;

    }

    @Override
    public int hashCode() {
        int result = getHr();
        result = 31 * result + getMin();
        result = 31 * result + getYear();
        result = 31 * result + getMonth();
        result = 31 * result + getDay();
        result = 31 * result + (getFrom() != null ? getFrom().hashCode() : 0);
        result = 31 * result + (getTo() != null ? getTo().hashCode() : 0);
        result = 31 * result + (getKey() != null ? getKey().hashCode() : 0);
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        return result;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public DriveRequest() {
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.hr);
        dest.writeInt(this.min);
        dest.writeInt(this.year);
        dest.writeInt(this.month);
        dest.writeInt(this.day);
        dest.writeString(this.from);
        dest.writeString(this.to);
        dest.writeString(this.key);
        dest.writeString(this.uid);
    }

    protected DriveRequest(Parcel in) {
        this.hr = in.readInt();
        this.min = in.readInt();
        this.year = in.readInt();
        this.month = in.readInt();
        this.day = in.readInt();
        this.from = in.readString();
        this.to = in.readString();
        this.key = in.readString();
        this.uid = in.readString();
    }

    public static final Creator<DriveRequest> CREATOR = new Creator<DriveRequest>() {
        @Override
        public DriveRequest createFromParcel(Parcel source) {
            return new DriveRequest(source);
        }

        @Override
        public DriveRequest[] newArray(int size) {
            return new DriveRequest[size];
        }
    };
}
