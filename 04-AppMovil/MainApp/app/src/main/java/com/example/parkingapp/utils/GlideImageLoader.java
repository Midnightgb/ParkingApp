package com.example.parkingapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

public class GlideImageLoader {



    public static void loadImageWithRotation(Context context, String imageUrl, final ImageView imageView, final int rotationDegrees) {
        Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate(rotationDegrees);
                        Bitmap rotatedBitmap = Bitmap.createBitmap(resource, 0, 0, resource.getWidth(), resource.getHeight(), matrix, true);

                        Drawable drawable = new BitmapDrawable(context.getResources(), rotatedBitmap);

                        imageView.setImageDrawable(drawable);
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }

                    @Override
                    public void onLoadCleared(Drawable placeholder) {
                    }
                });
    }
}
