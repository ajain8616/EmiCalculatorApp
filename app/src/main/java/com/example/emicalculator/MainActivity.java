package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button ConBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);
        ConBtn = findViewById(R.id.ConBtn);
        ConBtn.setEnabled(false);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_twoWheeler)
                {
                    ConBtn.setBackgroundColor(getResources().getColor(R.color.richPurple));
                }
                else if (checkedId == R.id.rb_fourWheeler)
                {

                   ConBtn.setBackgroundColor(getResources().getColor(R.color.navyBlue));
                }
                else if (checkedId == R.id.rb_homeLoan)
                {
                    ConBtn.setBackgroundColor(getResources().getColor(R.color.neonGreen));
                }
                ConBtn.setEnabled(true);
            }
        });
        ConBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}





