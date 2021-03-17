package com.example.anotacoesapp;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private AnotacaoPreferencias preferencias;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextMultiLine);
        preferencias = new AnotacaoPreferencias(getApplication());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validar se algo foi digitado
                String textoRecuperado = editText.getText().toString();
                if(textoRecuperado.equals("")){
                    Snackbar.make(view, "Digita algum texto, caralho!!!", Snackbar.LENGTH_LONG).show();
                } else {
                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();

                }
            }
        });

        //recuperar a anotação
        String anotacaoRecuperada = preferencias.recuperarAnotacao();

        editText.setText(anotacaoRecuperada);

    }


}