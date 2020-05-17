package com.example.project_5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DetailCatatanActivity extends AppCompatActivity {

    EditText ed_judul, ed_jumlah, ed_tanggal;
    Button btn_simpan, btn_update, btn_delete;

    public static final String MY_ID = "my_id";
    RealmHelper realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_catatan);

        realm = new RealmHelper(DetailCatatanActivity.this);
        final int idData = getIntent().getIntExtra(MY_ID, 0);

        CatatanModel data = realm.showOneData(Integer.parseInt(String.valueOf(idData)));

        ed_judul = findViewById(R.id.ed_judul);
        ed_jumlah = findViewById(R.id.ed_jumlah);
        ed_tanggal = findViewById(R.id.ed_tanggal);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        ed_judul.setText(data.getJudul());
        ed_jumlah.setText(data.getJumlah_hutang());
        ed_tanggal.setText(data.getTanggal());

        ed_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int yearNow = calendar.get(Calendar.YEAR);
                int monthNow = calendar.get(Calendar.MONTH);
                int dayNow = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(DetailCatatanActivity.this, new DatePickerDialog.OnDateSetListener() {
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

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CatatanModel catatan = new CatatanModel();
                catatan.setId(idData);
                catatan.setJudul(ed_judul.getText().toString());
                catatan.setJumlah_hutang(ed_jumlah.getText().toString());
                catatan.setTanggal(ed_tanggal.getText().toString());
                realm.updateData(catatan);
                finish();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.deleteData(idData);
                finish();
            }
        });

    }
}
