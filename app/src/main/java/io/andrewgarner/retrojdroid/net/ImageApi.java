package io.andrewgarner.retrojdroid.net;

import android.support.annotation.NonNull;

import io.andrewgarner.retrojdroid.model.ImageData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Api for {@link ImageApiService}
 * Created by andrewgarner on 8/8/18.
 */
public final class ImageApi {

    //TODO: Use your own URL below
    private static final String BASE_URL = "TODO Replace me";

    private ImageApi() {
        throw new IllegalAccessError("Class is fully static!");
    }

    public static void getImage(@NonNull final Callback<ImageData> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ImageApiService service = retrofit.create(ImageApiService.class);
        Call<ImageData> call = service.getImageData();

        call.enqueue(callback);
    }
}
