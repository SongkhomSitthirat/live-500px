package com.prew.liveat500px.DAO;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Prew on 2/7/2017.
 */

public class PhotoItemDao implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("link")
    private String link;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("caption")
    private String caption;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("tags")
    private List<String> tags = new ArrayList<>();
    @SerializedName("created_time")
    private Date createdTime;
    @SerializedName("camera")
    private String camera;
    @SerializedName("lens")
    private String lens;
    @SerializedName("focal_length")
    private String focalLength;
    @SerializedName("iso")
    private String iso;
    @SerializedName("shutter_speed")
    private String shtterSpeed;
    @SerializedName("aperture")
    private String apertue;

    public PhotoItemDao() {
    }

    protected PhotoItemDao(Parcel in) {
        id = in.readInt();
        link = in.readString();
        imageUrl = in.readString();
        caption = in.readString();
        userId = in.readInt();
        tags = in.createStringArrayList();
        camera = in.readString();
        lens = in.readString();
        focalLength = in.readString();
        iso = in.readString();
        shtterSpeed = in.readString();
        apertue = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(link);
        dest.writeString(imageUrl);
        dest.writeString(caption);
        dest.writeInt(userId);
        dest.writeStringList(tags);
        dest.writeString(camera);
        dest.writeString(lens);
        dest.writeString(focalLength);
        dest.writeString(iso);
        dest.writeString(shtterSpeed);
        dest.writeString(apertue);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhotoItemDao> CREATOR = new Creator<PhotoItemDao>() {
        @Override
        public PhotoItemDao createFromParcel(Parcel in) {
            return new PhotoItemDao(in);
        }

        @Override
        public PhotoItemDao[] newArray(int size) {
            return new PhotoItemDao[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getShtterSpeed() {
        return shtterSpeed;
    }

    public void setShtterSpeed(String shtterSpeed) {
        this.shtterSpeed = shtterSpeed;
    }

    public String getApertue() {
        return apertue;
    }

    public void setApertue(String apertue) {
        this.apertue = apertue;
    }
}
