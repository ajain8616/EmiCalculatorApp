package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private List<Bank> bankList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bankList.add(new Bank("Bank A", 2.5f));
        bankList.add(new Bank("Bank B", 3.0f));
        bankList.add(new Bank("Bank C", 3.5f));
        bankList.add(new Bank("Bank D", 4.0f));
        bankList.add(new Bank("Bank E", 4.5f));
        bankList.add(new Bank("Bank F", 5.0f));
        bankList.add(new Bank("Bank G", 5.5f));
        bankList.add(new Bank("Bank H", 6.0f));
        bankList.add(new Bank("Bank I", 6.5f));
        bankList.add(new Bank("Bank J", 7.0f));
        bankList.add(new Bank("Bank K", 7.5f));
        bankList.add(new Bank("Bank L", 8.0f));
        bankList.add(new Bank("Bank M", 8.5f));
        bankList.add(new Bank("Bank N", 9.0f));
        bankList.add(new Bank("Bank O", 9.5f));

        ListView listView = findViewById(R.id.list_item);
        BankAdapter adapter = new BankAdapter(this, bankList);

        // Set an item click listener for the ListView
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected bank
            Bank selectedBank = bankList.get(position);

            // Navigate to MainActivity3 and pass the interest rate
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("INTEREST_RATE", selectedBank.getInterestRate());
            startActivity(intent);
        });

        listView.setAdapter(adapter);
        Button PreBtn = findViewById(R.id.PreBtn);
        PreBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
