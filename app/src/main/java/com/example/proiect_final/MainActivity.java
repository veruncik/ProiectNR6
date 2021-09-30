package com.example.proiect_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnVerifica;
    EditText nume, prenume, telefon;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nume=(EditText)findViewById(R.id.txtNume);
        prenume=(EditText)findViewById(R.id.txtPren);
        telefon=(EditText)findViewById(R.id.txtTel);
        btnVerifica=(Button)findViewById(R.id.btnVerifica);
        result= (TextView)findViewById(R.id.textResult);
        btnVerifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nume.getText().toString().isEmpty() ||
                        prenume.getText().toString().isEmpty() ||
                        telefon.getText().toString().isEmpty()) {
                    try {
                        result.setText("Completați câmpurile!");
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                } else {
                    for(int i=0; i<telefon.getText().toString().length(); i++){
                        if(!Character.isDigit(telefon.getText().toString().charAt(i))){
                            result.setText("Caracter gresit la telefon!");
                            return;
                        }
                    }

                    result.setText("Nume - " + nume.getText().toString() + "\n" +
                            "Prenume - " + prenume.getText().toString() + "\n" +
                            "Telefon - " + telefon.getText().toString());
                }
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}