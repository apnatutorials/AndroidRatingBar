package com.apnatutorials.androidratingbar;

import android.icu.text.DecimalFormat;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {
    int count = 0;
    int customCount = 0;
    float customCurrenRating = 0;
    float currenRating = 0;
    TextView tvDefaultRatingMessage, tvCustomRatingMessage;
    RatingBar rbDefaultRatingIndicator, rbDefault, rbCustom, rbCustomRatingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbDefaultRatingIndicator = (RatingBar) findViewById(R.id.rbDefaultRatingIndicator);
        rbDefault = (RatingBar) findViewById(R.id.rbDefault);
        rbDefault.setOnRatingBarChangeListener(this);
        rbCustom = (RatingBar) findViewById(R.id.rbCustom);
        rbCustom.setOnRatingBarChangeListener(this);
        rbCustomRatingIndicator = (RatingBar) findViewById(R.id.rbCustomRatingIndicator);


        tvDefaultRatingMessage = (TextView) findViewById(R.id.tvDefaultRatingMessage);
        tvCustomRatingMessage = (TextView) findViewById(R.id.tvCustomRatingMessage);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        switch (ratingBar.getId()) {
            case R.id.rbDefault:
                currenRating = Float.valueOf(decimalFormat.format((currenRating * count + rating)
                        / ++count));
                Toast.makeText(MainActivity.this, "New default rating: " + currenRating, Toast.LENGTH_SHORT).show();
                rbDefaultRatingIndicator.setRating(currenRating);
                tvDefaultRatingMessage.setText(count + " Ratings");
                break;
            case R.id.rbCustom:
                customCurrenRating = Float.valueOf(decimalFormat.format((customCurrenRating * customCount + rating)
                        / ++customCount));
                Toast.makeText(MainActivity.this, "New cusstom rating: " + customCurrenRating, Toast.LENGTH_SHORT).show();
                rbCustomRatingIndicator.setRating(customCurrenRating);
                tvCustomRatingMessage.setText(customCount + " Ratings");
                break;
        }

    }
}
