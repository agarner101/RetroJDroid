package io.andrewgarner.retrojdroid.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Describes simple image data. Has a url and a timestamp.
 * Created by andrewgarner on 8/8/18.
 */
public class ImageData {

    @SerializedName("imageUrl")
    @NonNull
    private final String mUrl;
    @SerializedName("lastUpdated")
    @NonNull
    private final String mTimeStamp;

    public ImageData(@NonNull final String url,
                     @NonNull final String timeStamp) {
        mUrl = url;
        mTimeStamp = timeStamp;
    }

    @NonNull
    public String getUrl() {
        return mUrl;
    }

    @NonNull
    public String getTimeStamp() {
        return mTimeStamp;
    }
}
