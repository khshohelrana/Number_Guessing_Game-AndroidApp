package com.example.Cyanideguessnumber;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button b_go, b_lower, b_higher;
    private   TextView tv_score, tv_number;

    private Random random;
    private int number,numberNew ,score=0;

    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_go=findViewById(R.id.b_go);
        b_lower=findViewById(R.id.b_lower);
        b_higher=findViewById(R.id.b_higher);

        b_go.setVisibility(View.VISIBLE);
        b_lower.setVisibility(View.INVISIBLE);
        b_higher.setVisibility(View.INVISIBLE);


        tv_score=findViewById(R.id.tv_score);
        tv_number=findViewById(R.id.tv_number);

        random=new Random();
        animation= AnimationUtils.loadAnimation(this, R.anim.shake);

        b_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=random.nextInt(100)+1;
                tv_number.setText(" "+number);
                score =0;
                tv_score.setText("Score: "+ score);


                b_go.setVisibility(View.INVISIBLE);
                b_lower.setVisibility(View.VISIBLE);
                b_higher.setVisibility(View.VISIBLE);
            }
        });

        b_lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do {
                    numberNew = random.nextInt(100) + 1;
                }while (numberNew==number);

                tv_number.setText(""+numberNew);
                tv_number.startAnimation(animation);
                if(numberNew<=number){
                    score++;
                    tv_score.setText("Score: "+ score);
                    number=numberNew;

                }else{
                    tv_score.setText("Score: "+ score+"\nYOU LOST!");
                    b_go.setVisibility(View.VISIBLE);
                    b_lower.setVisibility(View.VISIBLE);
                    b_higher.setVisibility(View.VISIBLE);

                }

            }
        });

        b_higher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                do {
                    numberNew = random.nextInt(100) + 1;
                }while (numberNew==number);
                tv_number.setText(""+numberNew);
                tv_number.startAnimation(animation);
                if(numberNew>=number){
                    score++;
                    tv_score.setText("Score: "+ score);
                    number=numberNew;

                }else{
                    tv_score.setText("Score: "+ score+"\nYOU LOST!");
                    b_go.setVisibility(View.VISIBLE);
                    b_lower.setVisibility(View.VISIBLE);
                    b_higher.setVisibility(View.VISIBLE);

                }

            }
        });
    }
}