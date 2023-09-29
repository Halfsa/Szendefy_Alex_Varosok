package com.example.flipcoin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Button btnfej;
    private Button btniras;
    private TextView tvdobas;
    private TextView tvwin;
    private TextView tvlose;
    private Toast toast;
    private AlertDialog.Builder ali;
    private int tipp = 0;
    private int dobszam;
    private int win;
    private int lose;
    private Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btniras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 1;
                Eredmeny();
            }
        });
        btnfej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 0;
                Eredmeny();
            }
        });
    }
    public void Eredmeny()
    {
        int dobas;
        dobszam++;
        dobas = r.nextInt(2);
        /*
         if (dobas == 0) {
            img.setImageResource(R.drawable.heads);

        }
        else if (dobas == 1)
        {
            img.setImageResource(R.drawable.tails);
        }
        */
        switch (dobas){
            case 0: img.setImageResource(R.drawable.heads);
                Toast.makeText(MainActivity.this, "Fej", Toast.LENGTH_SHORT).show();
            break;
            case 1: img.setImageResource(R.drawable.tails);
                Toast.makeText(MainActivity.this, "Írás", Toast.LENGTH_SHORT).show();
            break;
        }

        if (tipp == dobas)
        {
            win++;
        }
        else
        {
            lose++;
        }
        tvdobas.setText("Dobások: "+dobszam);
        tvwin.setText("Győzelem: "+win);
        tvlose.setText("Vereség: "+lose);
        if (dobszam ==5)
        {
            if (win > lose)
            {
                ali.setTitle("Győzelem").show();
            }
            else {
                ali.setTitle("Vereség").show();
            }
        }
    }

    public void newGame()
    {
        dobszam = 0;
        win = 0;
        lose = 0;
        tvdobas.setText("Dobások: "+dobszam);
        tvwin.setText("Győzelem: "+win);
        tvlose.setText("Vereség: "+lose);
        img.setImageResource(R.drawable.heads);
    }
    public void init(){
        img =findViewById(R.id.img);
        btnfej = findViewById(R.id.btnfej);
        btniras = findViewById(R.id.btniras);
        tvdobas = findViewById(R.id.tvdobas);
        tvwin = findViewById(R.id.tvwin);
        tvlose = findViewById(R.id.tvlose);
        win = 0;
        lose = 0;
        toast = new Toast(MainActivity.this);
        ali = new AlertDialog.Builder(MainActivity.this);
        ali.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newGame();
                    }
                })
                .setNegativeButton("nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setMessage("Szeretne új játékot játszani?")
                .setCancelable(false)
                .create();

    }
}