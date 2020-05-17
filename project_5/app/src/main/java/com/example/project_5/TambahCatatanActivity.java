package com.example.project_5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TambahCatatanActivity extends AppCompatActivity {

    EditText ed_judul, ed_jumlah, ed_tanggal;
    Button btn_simpan;

    RealmHelper realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_catatan);

        realm = new RealmHelper(TambahCatatanActivity.this);

        ed_judul = findViewById(R.id.ed_judul);
        ed_jumlah = findViewById(R.id.ed_jumlah);
        ed_tanggal = findViewById(R.id.ed_tanggal);
        btn_simpan = findViewById(R.id.btn_simpan);


        ed_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int yearNow = calendar.get(Calendar.YEAR);
                int monthNow = calendar.get(Calendar.MONTH);
                int dayNow = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(TambahCatatanActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, month, dayOfMonth);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                        ed_tanggal.setText(dateFormat.format(cal.getTime()));
                    }
                }, yearNow, monthNow, dayNow);
                    dialog.show();
            }
        });

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CatatanModel catatan = new CatatanModel();
                catatan.setId((int) realm.getNextId());
                catatan.setJudul(ed_judul.getText().toString());
                catatan.setJumlah_hutang(ed_jumlah.getText().toString());
                catatan.setTanggal(ed_tanggal.getText().toString());
                realm.insertData(catatan);
                    finish();  }
        });
    }
}





