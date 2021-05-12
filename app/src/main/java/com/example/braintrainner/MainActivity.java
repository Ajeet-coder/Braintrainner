package com.example.braintrainner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    int rightans;
    int score=0;
    int questioncount=0;
    ArrayList<Integer> answer=new ArrayList<Integer>();
    TextView resulttextView ;
    TextView scoreTextView ;
    TextView sumTextView;
    TextView timerTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playagainButton;
    public void playagain(View view){
        score=0;
        questioncount=0;
        timerTextView.setText("30s");

        playagainButton.setVisibility(View.INVISIBLE);
        scoreTextView.setText(Integer.toString(score)+ "/" +Integer.toString(questioncount));
        newQuestion();
        new CountDownTimer(30100, 1100) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                resulttextView.setText("Time up!");
                playagainButton.setVisibility(View.VISIBLE);
            }
        }.start();

    }
   public void chooseAnswer(View view){
        if(Integer.toString(rightans).equals(view.getTag().toString())){
          resulttextView.setText("correct!");
          score++;
           //Log.i("sahi hai","babu");
        }
        else {

            resulttextView.setText("Wrong");
        }
        questioncount++;
        scoreTextView.setText(Integer.toString(score)+ "/" +Integer.toString(questioncount));
      //playagain(findViewById(R.id.timerTextView));
       newQuestion();
      /* new CountDownTimer(5100, 1000) {
           @Override
           public void onTick(long millisUntilFinished) {
               timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");
           }

           @Override
           public void onFinish() {
               resulttextView.setText("Time up!");

              // playagainButton.setVisibility(View.VISIBLE);
           }
       }.start();*/
    }
    public void start(View view){
        button.setVisibility(View.INVISIBLE);
    }
    public void newQuestion(){
        Random random=new Random();
       answer.clear();

        int a=random.nextInt(45);
        int b=random.nextInt(45);
        sumTextView.setText(Integer.toString(a)+ " + " +Integer.toString(b));
        rightans=random.nextInt(4);
        for (int i=0;i<4;i++){
            if(i == rightans){
                answer.add(a+b);
            }
            else{
                int wrongans =random.nextInt(80);
                while (wrongans == a+b){
                    wrongans=random.nextInt(80);
                }
                answer.add(wrongans);
            }
        }
        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));
       // chooseAnswer( findViewById(R.id.timerTextView));
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sumTextView =findViewById(R.id.sumTextView);
        resulttextView=findViewById(R.id.resulttextView);
        scoreTextView=findViewById(R.id.scoreTextView);
        button =findViewById(R.id.button);
         button0 = findViewById(R.id.button0);
         button1 = findViewById(R.id.button1);
         button2 = findViewById(R.id.button2);
         button3 = findViewById(R.id.button3);
         playagainButton=findViewById(R.id.playagainButton);
         timerTextView=findViewById(R.id.timerTextView);
        Random random=new Random();


        int a=random.nextInt(45);
        int b=random.nextInt(45);
        sumTextView.setText(Integer.toString(a)+ " + " +Integer.toString(b));
        rightans=random.nextInt(4);
        for (int i=0;i<4;i++){
            if(i == rightans){
                answer.add(a+b);
            }
            else{
                int wrongans =random.nextInt(80);
                while (wrongans == a+b){
                    wrongans=random.nextInt(80);
                }
                answer.add(wrongans);
            }
        }
        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));
    }

}
