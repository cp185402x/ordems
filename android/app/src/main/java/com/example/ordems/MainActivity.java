package com.example.ordems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_cpf;
    private Button btn_ver;

//testando00
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.et_cpf = findViewById(R.id.et_cpf);
        this.btn_ver = findViewById(R.id.btn_ver);

        this.btn_ver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ver:
            String cpf = this.et_cpf.getText().toString();

            Intent intent = new Intent(this, ConsultaActivity.class);
            intent.putExtra("cpfUsuario",cpf);

            startActivity(intent);
            finish();

            break;
        }
    }
}