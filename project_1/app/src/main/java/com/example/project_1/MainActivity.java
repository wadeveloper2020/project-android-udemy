package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed_nilai;
    Button btn_hitung;
    TextView tv_hasil;
    Spinner spinner;

    String [] pilihanHitung = {"Luas", "Keliling", "Luas Permukaan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_nilai = findViewById(R.id.ed_nilai);
        btn_hitung = findViewById(R.id.btn_hitung);
        tv_hasil = findViewById(R.id.tv_hasil);
        spinner = findViewById(R.id.sp_pilih_hitung);

        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (spinner.getSelectedItem().toString().equals(pilihanHitung[0])){
                    rumusLuas();
                } else if (spinner.getSelectedItem().toString().equals(pilihanHitung[1])){
                    Double nilai = Double.valueOf(ed_nilai.getText().toString());
                    rumusKeliling(nilai);
                }else if (spinner.getSelectedItem().toString().equals(pilihanHitung[2])) {
                    Double hasil = rumusLuasPermukaan();
                    tv_hasil.setText(hasil.toString());
                }
            }
        });

                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,
                                            android.R.layout.simple_spinner_dropdown_item,
                                            pilihanHitung);
        spinner.setAdapter(arrayAdapter);
    }

    private Double rumusLuasPermukaan() {
        Double nilai = Double.valueOf(ed_nilai.getText().toString());
        Double hasil = 6 * (nilai * nilai);
        return hasil;
    }

    private void rumusKeliling(Double nilai) {
        Double hasil = 4 * (nilai * nilai);
        tv_hasil.setText(hasil.toString());
    }

    private void rumusLuas() {
        Double nilai = Double.valueOf(ed_nilai.getText().toString());
        Double hasil = nilai * nilai;
        tv_hasil.setText(hasil.toString());
    }
}
