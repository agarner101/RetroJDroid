package io.andrewgarner.retrojdroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import io.andrewgarner.retrojdroid.model.ImageData;
import io.andrewgarner.retrojdroid.net.ImageApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.image);

        ImageApi.getImage(new Callback<ImageData>() {
            @Override
            public void onResponse(final Call<ImageData> call, final Response<ImageData> response) {
                ImageData data = response.body();
                if (data != null) {
                    Log.d(LOG_TAG, "Response with imageUrl: " + data.getUrl());
                    showImage(data);
                } else {
                    Log.e(LOG_TAG, "Image data null.");
                }
            }

            @Override
            public void onFailure(final Call<ImageData> call, final Throwable t) {
                Log.e(LOG_TAG, "Failure!" + t.toString());
            }
        });
    }

    private void showImage(@NonNull final ImageData imageData) {
        String url = imageData.getUrl();
        Picasso.get().load(url).into(mImageView);
    }
}
