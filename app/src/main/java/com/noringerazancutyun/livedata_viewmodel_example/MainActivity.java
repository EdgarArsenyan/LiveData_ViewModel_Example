package com.noringerazancutyun.livedata_viewmodel_example;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button incrementButton;
    private Button decrementButton;
    private TextView numberText;
    private CustomViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initViewModel();
        clickButtons();
    }

    private void init() {
        incrementButton = findViewById(R.id.button2);
        decrementButton = findViewById(R.id.button);
        numberText = findViewById(R.id.textView);
    }

    private void initViewModel(){
        viewModel = ViewModelProviders.of(MainActivity.this).get(CustomViewModel.class);
        viewModel.getLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                numberText.setText(String.valueOf(integer));
            }
        });
    }

    private void clickButtons(){

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.increment();
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.decrement();
            }
        });
    }
}
