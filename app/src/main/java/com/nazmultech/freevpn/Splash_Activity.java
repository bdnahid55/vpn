package com.nazmultech.freevpn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.airbnb.lottie.LottieAnimationView;

public class Splash_Activity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Replace with your XML layout name

        // Initialize Lottie Animation
        LottieAnimationView lottieAnimationView = findViewById(R.id.lotti);
        lottieAnimationView.playAnimation();

        // Handler to delay the next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start your main activity
                Intent intent = new Intent(Splash_Activity.this, MainActivity.class);
                startActivity(intent);

                // Close this activity
                finish();

                // Apply smooth transition
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    protected void onDestroy() {
        // Cancel animation when activity is destroyed to prevent memory leaks
        LottieAnimationView lottieAnimationView = findViewById(R.id.lotti);
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        super.onDestroy();
    }


}