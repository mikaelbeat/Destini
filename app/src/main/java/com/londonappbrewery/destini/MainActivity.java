package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyText;
    Button buttonOne;
    Button buttonTwo;
    int buttonOneStoryPath = 0;
    int buttonTwoStoryPath = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyText = (TextView) findViewById(R.id.storyTextView);
        buttonOne = (Button) findViewById(R.id.buttonTop);
        buttonTwo = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonOneStoryPath ++;
                if (buttonOneStoryPath == 1 && buttonTwoStoryPath == 0){
                    storyText.setText(R.string.T3_Story);
                    buttonOne.setText(R.string.T3_Ans1);
                    buttonTwo.setText((R.string.T3_Ans2));
                } else if (buttonOneStoryPath == 1 && buttonTwoStoryPath == 1){
                    storyText.setText(R.string.T3_Story);
                    buttonOne.setText(R.string.T3_Ans1);
                    buttonTwo.setText(R.string.T3_Ans2);
                } else if (buttonOneStoryPath == 2 && buttonTwoStoryPath == 0){
                    storyText.setText(R.string.T6_End);
                    buttonOne.setVisibility(View.GONE);
                    buttonTwo.setVisibility(View.GONE);
                } else if (buttonOneStoryPath == 2 && buttonTwoStoryPath == 1){
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
                buttonTwoStoryPath ++;
                if (buttonOneStoryPath == 1 && buttonTwoStoryPath == 1){
                    storyText.setText(R.string.T5_End);
                    buttonOne.setVisibility(View.GONE);
                    buttonTwo.setVisibility(View.GONE);
                }
                else if (buttonOneStoryPath == 0 && buttonTwoStoryPath == 1){
                    storyText.setText(R.string.T2_Story);
                    buttonOne.setText(R.string.T2_Ans1);
                    buttonTwo.setText(R.string.T2_Ans2);
                } else if (buttonOneStoryPath == 0 && buttonTwoStoryPath == 2){
                    storyText.setText(R.string.T4_End);
                    buttonOne.setVisibility(View.GONE);
                    buttonTwo.setVisibility(View.GONE);
                } else if (buttonOneStoryPath == 1 && buttonTwoStoryPath == 1){
                    storyText.setText(R.string.T3_Story);
                    buttonOne.setText(R.string.T3_Ans1);
                    buttonTwo.setText(R.string.T3_Ans2);
                } else if (buttonOneStoryPath == 1 && buttonTwoStoryPath == 2){
                    storyText.setText(R.string.T5_End);
                    buttonOne.setVisibility(View.GONE);
                    buttonTwo.setVisibility(View.GONE);
                }


            }
        });

    }
}
