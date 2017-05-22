package com.example.sulavtimsina.driveastate.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Sulav.Timsina on 5/22/2017.
 */

public class DriverRegRequest implements Parcelable {
    String vin,phone,uid,key;

    public DriverRegRequest(String vin, String phone, String uid, String key) {
        this.vin = vin;
        this.phone = phone;
        this.uid = uid;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriverRegRequest)) return false;

        DriverRegRequest that = (DriverRegRequest) o;

        if (getVin() != null ? !getVin().equals(that.getVin()) : that.getVin() != null)
            return false;
        if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null)
            return false;
        if (getUid() != null ? !getUid().equals(that.getUid()) : that.getUid() != null)
            return false;
        return getKey() != null ? getKey().equals(that.getKey()) : that.getKey() == null;

    }

    @Override
    public int hashCode() {
        int result = getVin() != null ? getVin().hashCode() : 0;
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getKey() != null ? getKey().hashCode() : 0);
        return result;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public DriverRegRequest() {
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.vin);
        dest.writeString(this.phone);
        dest.writeString(this.uid);
        dest.writeString(this.key);
    }

    protected DriverRegRequest(Parcel in) {
        this.vin = in.readString();
        this.phone = in.readString();
        this.uid = in.readString();
        this.key = in.readString();
    }

    public static final Creator<DriverRegRequest> CREATOR = new Creator<DriverRegRequest>() {
        @Override
        public DriverRegRequest createFromParcel(Parcel source) {
            return new DriverRegRequest(source);
        }

        @Override
        public DriverRegRequest[] newArray(int size) {
            return new DriverRegRequest[size];
        }
    };
}
