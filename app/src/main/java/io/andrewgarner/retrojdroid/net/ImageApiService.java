package io.andrewgarner.retrojdroid.net;

import io.andrewgarner.retrojdroid.model.ImageData;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by andrewgarner on 8/8/18.
 */
public interface ImageApiService {
    @GET("image")
    Call<ImageData> getImageData();
}
