package engtelecom.poo.stefanie.primeiroaplicativo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private int mCounter = 0; // m DE MODIFICADO
    private TextView mTextViewConter;
    private String texto_saudacao = "Olá MUndo!";
    public static final String CONTADOR_PREFS = "contadorSharedPrefs";
    private SharedPreferences mSharedPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedPrefs = getSharedPreferences(CONTADOR_PREFS,MODE_PRIVATE);
        //Procura a chave CONTADOR, se não existir insere 0, se existir coloca a existente.
        mCounter = mSharedPrefs.getInt("CONTADOR",0);

        // MODIFICAR O OBJETO DO LAYOUT
        mTextViewConter = findViewById(R.id.textView);

        this.mTextViewConter.setText("" + mCounter);

        // VERIFICA SE A HASH-TABLE POSSUI ALGUM VALOR GUARDADO
//        if(savedInstanceState != null)
//        {
//            int count = savedInstanceState.getInt("count");
//
//            if (mTextViewConter != null)
//            {
//                mTextViewConter.setText("" + count);
//                mCounter = count;
//            }
//        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        SharedPreferences.Editor prefsEditor = mSharedPrefs.edit();
        prefsEditor.putInt("CONTADOR",mCounter);
        prefsEditor.apply();
    }

    public void implementarContador(View view)
    {
        mCounter++;
        mTextViewConter.setText(Integer.toString(mCounter));
    }

    public void proximaTela(View view)
    {
        // MENSAGEM NA TELA
        //Toast toast = Toast.makeText(this, R.string.text, Toast.LENGTH_LONG);
        //toast.show();

        // LINK NA TELA
        //Uri uri = Uri.parse("http://docente.ifsc.edu.br/mello");
        //Intent it = new Intent(Intent.ACTION_VIEW,uri);
        //startActivity(it);

        // OBJETO QUE DISPARA ACTIVITY NA TELA
        Intent messageIntent = new Intent(this, SegundaActivity.class);

        // OBJETO ONDE POSSO GUARDAR INFO DESSA ACTIVITY PARA USAR EM OUTRAS
        // FUNCIONA COMO UMA HASH-TABLE
        Bundle extras = new Bundle();
        // Para string
        //extras.putString("messageTAG", "Olá mundo!");
        // Para int
        extras.putInt("contador", mCounter);

        // ADICIONANDO BUNDLE NO INTENT
        messageIntent.putExtras(extras);

        // DISPARANDO NOVA ACTIVITY
        //startActivity(messageIntent);

        startActivityForResult(messageIntent,20);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 20)
        {
            if (resultCode == RESULT_OK)
            {
                //COLOCAR CONTADOR EM ZERO
                mCounter = 0;
                mTextViewConter.setText("" + mCounter);
            }

            else if (resultCode == RESULT_CANCELED)
            {
                //MANTEM O VALOR E IMPRIME LOG QUE FOI CANCELADO
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("count",mCounter);
    }
}