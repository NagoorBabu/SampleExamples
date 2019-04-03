package co.in.mfcwl.app.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AnimationDrawableActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    AnimationDrawable batteryAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable);

        ImageView imageview = (ImageView) findViewById(R.id.imageView);
        imageview.setBackgroundResource(R.drawable.animation_drawable_example);

        batteryAnimation = (AnimationDrawable) imageview.getBackground();
    }

    @Override
    protected void onStart() {
        super.onStart();
        batteryAnimation.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        batteryAnimation.stop();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
