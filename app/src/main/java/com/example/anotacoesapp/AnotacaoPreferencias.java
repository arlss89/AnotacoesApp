package com.example.anotacoesapp;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private static final String NOME_ARQUIVO = "Anotacao.preferencia";
    private static final String CHAVE_NOME = "nome";

    private SharedPreferences.Editor editor;


    public AnotacaoPreferencias(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao){

        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();

    }

    public String recuperarAnotacao(){
        return preferences.getString(CHAVE_NOME, "Faça sua anotação!");
    }

}
