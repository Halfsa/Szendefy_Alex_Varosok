package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;

public class MasodikActivity extends AppCompatActivity {

    private TextInputLayout etData;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masodik);
        init();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etData.getEditText().getText().toString().isEmpty()){
                    etData.setError("Nem lehet üres");
                }
                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("adat",etData.getEditText().getText().toString());
                    editor.apply();
                    Toast.makeText(MasodikActivity.this,"Sikeres adat mentés",Toast.LENGTH_SHORT).show();



                Intent intent = new Intent(MasodikActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                }
            }
        });
    }

    public void init(){
        etData = findViewById(R.id.etData);
        btnBack = findViewById(R.id.btnBack);
    }
}