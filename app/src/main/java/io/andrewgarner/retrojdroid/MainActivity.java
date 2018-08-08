package io.andrewgarner.retrojdroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.andrewgarner.retrojdroid.model.ImageData;
import io.andrewgarner.retrojdroid.net.ImageApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageApi.getImage(new Callback<ImageData>() {
            @Override
            public void onResponse(final Call<ImageData> call, final Response<ImageData> response) {
                Log.d(LOG_TAG, "Response with imageUrl: " + response.body().getUrl());
            }

            @Override
            public void onFailure(final Call<ImageData> call, final Throwable t) {
                Log.e(LOG_TAG, "Failure!" + t.toString());
            }
        });
    }
}
