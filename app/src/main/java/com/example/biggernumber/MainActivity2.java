package com.example.biggernumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView wlcm,Rul,atmpt,target;
    Button Btn1,Btn2,Btn3;
    int count=0;
    int attempt=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        wlcm=findViewById(R.id.welcomeact2);
        target=findViewById(R.id.lose);
        Rul=findViewById(R.id.rules);
        atmpt=findViewById(R.id.pointattempt);
        Btn1=findViewById(R.id.button1);
        Btn3=findViewById(R.id.share);
        Btn2=findViewById(R.id.button2);
        int first=Randomnumber();
        int second=Randomnumber();
        Btn1.setText(""+first);
        Btn2.setText(""+second);

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greater(Btn1,Btn2);
                checkattempt();
                int first=Randomnumber();
                int second=Randomnumber();
                Btn1.setText(""+first);
                Btn2.setText(""+second);


            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greater(Btn2,Btn1);
                checkattempt();
                int first=Randomnumber();
                int second=Randomnumber();
                Btn1.setText(""+first);
                Btn2.setText(""+second);


            }
        });

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                String x= intent.getStringExtra("name");
                String k=atmpt.getText().toString();
                Intent intent1=new Intent();
                intent1.setAction(Intent.ACTION_SEND);
                intent1.setType("text/plainer");
                intent1.putExtra(Intent.EXTRA_TEXT,"the name of the player "+x+" the score and attempt was "+k);
                startActivity(Intent.createChooser(intent1,"choose your app"));
            }
        });


    }
    public int Randomnumber(){
        Random rand = new Random();
        int max=1000;
        int randomnumber=rand.nextInt(max);
        return randomnumber;

    }
    public void greater(Button x,Button  y){
        String f=x.getText().toString();
        String b=y.getText().toString();
        int c=Integer.parseInt(f);
        int d=Integer.parseInt(b);

        if(c>d){
            int a=countpositive();
            atmpt.setText("Score:"+a+" Attempt"+attempt);
        }
        else{
            attempt();
            int z=countnegative();
            atmpt.setText("Score:"+z+" Attempt "+attempt);

        }


        }
        public void attempt(){
            --attempt;
        }
        public int countpositive(){
            return ++count;
        }

    public int countnegative(){
        return --count;
    }
    public void checkattempt(){
        if(attempt==0){
           Btn1.setVisibility(View.INVISIBLE);
           Btn2.setVisibility(View.INVISIBLE); //to enabled button btn1.setEnabled(true);
           target.setText("Game Over");
        }

    }
}
