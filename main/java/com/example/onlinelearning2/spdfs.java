package com.example.onlinelearning2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class spdfs extends AppCompatActivity {
    ImageView btn;
    LinearLayout urdu,english,science1,science2,math1,math2,marathi,history1,history2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spdfs);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        urdu = findViewById(R.id.urdu);
        btn=findViewById(R.id.btn);
        english=findViewById(R.id.english);
        science1=findViewById(R.id.science1 );
        science2=findViewById(R.id.science2 );
        math1=findViewById(R.id.math1);
        math2=findViewById(R.id.math2);
        marathi=findViewById(R.id.marathi);
        history1=findViewById(R.id.history1);
        history2=findViewById(R.id.history2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(spdfs.this, home.class);
                startActivity(intent);
            }
        });

        urdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(spdfs.this, displaypdf.class);
                intent.putExtra("pdf_url", "https://drive.google.com/file/d/15VgBKIWd5V8utgB0h3CPbwdBlmANBPZh");
                startActivity(intent);
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(spdfs.this, displaypdf.class);
                intent.putExtra("pdf_url", "https://gaana.com/");
                startActivity(intent);
            }
        });
        science1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(spdfs.this, displaypdf.class);
                intent.putExtra("pdf_url", "https://drive.google.com/file/d/1EHw90C17LCFizZM59f0jHTtpUahLTnEu");
                startActivity(intent);
            }
        });
        science2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(spdfs.this, displaypdf.class);
                intent.putExtra("pdf_url", "https://drive.google.com/file/d/1EHw90C17LCFizZM59f0jHTtpUahLTnEu");
                startActivity(intent);
            }
        });
        math1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(spdfs.this, displaypdf.class);
                intent.putExtra("pdf_url", "https://drive.google.com/file/d/1EHw90C17LCFizZM59f0jHTtpUahLTnEu");
                startActivity(intent);
            }
        });
        math2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(spdfs.this, displaypdf.class);
                intent.putExtra("pdf_url", "https://drive.google.com/file/d/1EHw90C17LCFizZM59f0jHTtpUahLTnEu");
                startActivity(intent);
            }
        });
        marathi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(spdfs.this, displaypdf.class);
                intent.putExtra("pdf_url", "https://drive.google.com/file/d/1EHw90C17LCFizZM59f0jHTtpUahLTnEu");
                startActivity(intent);
            }
        });
        history1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(spdfs.this, displaypdf.class);
                intent.putExtra("pdf_url", "https://drive.google.com/file/d/1EHw90C17LCFizZM59f0jHTtpUahLTnEu");
                startActivity(intent);
            }
        });
        history2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(spdfs.this, displaypdf.class);
                intent.putExtra("pdf_url", "https://drive.google.com/file/d/1EHw90C17LCFizZM59f0jHTtpUahLTnEu");
                startActivity(intent);
            }
        });


    }
}