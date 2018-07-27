package com.londonappbrewery.destini;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer backgroundMusic;
    MediaPlayer clickButton;

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyText;
    Button buttonOne;
    Button buttonTwo;
    int storyIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundMusic = MediaPlayer.create(getApplicationContext(), R.raw.far);
        backgroundMusic.start();

        clickButton = MediaPlayer.create(getApplicationContext(),R.raw.button);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyText = (TextView) findViewById(R.id.storyTextView);
        buttonOne = (Button) findViewById(R.id.buttonTop);
        buttonTwo = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickButton.start();
                Toast buttonsToast = Toast.makeText(getApplicationContext(), "Story continues!", Toast.LENGTH_SHORT);
                buttonsToast.show();
                if (storyIndex == 1 || storyIndex == 2){
                    storyText.setText(R.string.T3_Story);
                    buttonOne.setText(R.string.T3_Ans1);
                    buttonTwo.setText(R.string.T3_Ans2);
                    storyIndex = 3;
                } else {
                    storyText.setText(R.string.T6_End);
                    buttonOne.setVisibility(View.GONE);
                    buttonTwo.setVisibility(View.GONE);
                }

            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickButton.start();
                Toast buttonToast = Toast.makeText(getApplicationContext(), "Story continues!", Toast.LENGTH_SHORT);
                buttonToast.show();
                if(storyIndex == 1){
                    storyText.setText(R.string.T2_Story);
                    buttonOne.setText(R.string.T2_Ans1);
                    buttonTwo.setText(R.string.T2_Ans2);
                    storyIndex = 2;
                } else if (storyIndex == 2){
                    storyText.setText(R.string.T4_End);
                    buttonOne.setVisibility(View.GONE);
                    buttonTwo.setVisibility(View.GONE);
                } else {
                    storyText.setText(R.string.T5_End);
                    buttonOne.setVisibility(View.GONE);
                    buttonTwo.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        backgroundMusic.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        backgroundMusic.start();
    }
}