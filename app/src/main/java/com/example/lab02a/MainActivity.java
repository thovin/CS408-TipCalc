package com.example.lab02a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.lab02a.databinding.ActivityMainBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        binding.calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                submitParams();
            }
        });
    }

    private void submitParams() {
        String totalBillString = binding.totalBillInput.getText().toString();
        String numPeopleString = binding.numPeopleInput.getText().toString();
        String percentString = binding.percentInput.getText().toString();

        if ( !( totalBillString.equals("") || numPeopleString.equals("") || percentString.equals("") ) ) {
            double totalBill = Double.parseDouble(totalBillString);
            int numPeople = Integer.parseInt(numPeopleString);
            double percentage = Integer.parseInt(percentString);
            percentage /= 100;

            if (!(totalBill == 0 || percentage == 0 || numPeople == 0)) {
                double totalPerPerson = (totalBill + totalBill * percentage) / numPeople;
                NumberFormat formatter = new DecimalFormat("#0.00");
                binding.totalText.setText('$' + formatter.format(totalPerPerson) + " per person");

            } else {
                binding.totalText.setText("ERROR: Input zero or missing");
            }

        }
        else {
            binding.totalText.setText("ERROR: Input zero or missing");
        }

    }
}