package com.marton.tamas.funnychuck.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.marton.tamas.funnychuck.endless_list.model.Item;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class Joke extends Item implements Parcelable {

    @Expose
    private Integer id;
    @Expose
    private String joke;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.joke);
    }

    public Joke() {
    }

    protected Joke(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.joke = in.readString();
    }

    public static final Parcelable.Creator<Joke> CREATOR = new Parcelable.Creator<Joke>() {
        @Override
        public Joke createFromParcel(Parcel source) {
            return new Joke(source);
        }

        @Override
        public Joke[] newArray(int size) {
            return new Joke[size];
        }
    };
}