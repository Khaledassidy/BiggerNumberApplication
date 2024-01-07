package com.example.biggernumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView welcome;
    EditText name;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome=findViewById(R.id.Welcome);
        name=findViewById(R.id.Name);
        btn=findViewById(R.id.Btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=name.getText().toString();
                if(x.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your name!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                    intent.putExtra("name",""+x);
                    startActivity(intent);

                }
            }
        });
    }
}