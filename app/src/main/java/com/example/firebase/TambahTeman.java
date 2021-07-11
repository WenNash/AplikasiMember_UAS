package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebase.database.Teman;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahTeman extends AppCompatActivity {
    private EditText edNama, edTelpon;
    private Button submitBtn;
    private DatabaseReference database;
    String nm, tlp;

    //perintah untuk menambahkan data member
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_teman);


        edNama = findViewById(R.id.editNama);
        edTelpon = findViewById(R.id.editTelpon);
        submitBtn = findViewById(R.id.btnOk);

        database = FirebaseDatabase.getInstance().getReference();

        //perintah untuk menyimpan data member
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(edNama.getText().toString().isEmpty()) && !(edTelpon.getText().toString().isEmpty())){
                    nm = edNama.getText().toString();
                    tlp = edTelpon.getText().toString();

                    submitTeman(new Teman(nm, tlp));

                }
                //perintah untuk menginformasikan jika data tidak boleh kosong
                else
                    Toast.makeText(TambahTeman.this, "Data tidak boleh kosong",Toast.LENGTH_SHORT).show();


            }
        });
    //perintah untuk menginformasikan jika data berhasil ditambahkan
    }
    private void  submitTeman(Teman tmn){
        database.child("Teman").push().setValue(tmn).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                edNama.setText("");
                edTelpon.setText("");
                Toast.makeText(TambahTeman.this, "Data sukses ditambahkan", Toast.LENGTH_SHORT).show();

            }
        });
    }
}