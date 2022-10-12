package com.if3b.project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etLink, etLokasi, etTeks;
    private Button btnBukaWeb, btnBukaLok, btnBagikanTeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLink = findViewById(R.id.et_link);
        etLokasi = findViewById(R.id.et_lokasi);
        etTeks = findViewById(R.id.et_teks);

        btnBukaWeb = findViewById(R.id.btn_buka_website);
        btnBukaLok = findViewById(R.id.btn_buka_lokasi);
        btnBagikanTeks = findViewById(R.id.btn_bagikan_teks);

        btnBukaWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            // Link dianggap Tidak kosong
            // Jika Kosong bisa menggunakan if atau try
            public void onClick(View view) {
                String link = etLink.getText().toString();
                Uri uriLink = Uri.parse(link);

                Intent bukaWebsite = new Intent(Intent.ACTION_VIEW, uriLink);

                try {
                    startActivity(bukaWebsite);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "ADA KESALAHAN!!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnBukaLok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lokasi = etLokasi.getText().toString();
                Uri uriLokasi = Uri.parse("geo:0,0?=" +lokasi);

                Intent bukaLokasi = new Intent(Intent.ACTION_VIEW, uriLokasi);
                startActivity(bukaLokasi);


            }
        });

        btnBagikanTeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teks = etTeks.getText().toString();

                String mimeType = "text/plain";
                new ShareCompat
                        .IntentBuilder(MainActivity.this)
                        .setType(mimeType)
                        .setChooserTitle("Bagikan Teks Ini")
                        .setText(teks)
                        .startChooser();




            }
        });


    }
}