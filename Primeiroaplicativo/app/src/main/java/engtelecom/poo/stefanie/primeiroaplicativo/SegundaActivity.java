package engtelecom.poo.stefanie.primeiroaplicativo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity
{
    private TextView mTextViewConter;
    private SharedPreferences mSharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        int contador = 0;

        mSharedPrefs = getSharedPreferences(MainActivity.CONTADOR_PREFS,MODE_PRIVATE);
        //Procura a chave CONTADOR, se não existir insere 0, se existir coloca a existente.
        contador = mSharedPrefs.getInt("CONTADOR",0);

        // RECUPERAR INFORMAÇÕES DA PRIMEIRA ACTIVITY
//        Intent intent = getIntent();
//        Bundle extras = intent.getExtras();
//
//        if (extras != null)
//        {
//            String message = extras.getString("messageTAG");
//            contador = extras.getInt("contador");
//        }

        mTextViewConter = findViewById(R.id.textView3);
        mTextViewConter.setText("" + contador);
    }

    public void proximaTela(View view)
    {
        Intent messageIntent = new Intent(this, TerceiraActivity.class);
        startActivity(messageIntent);
    }

    public void implementarOK(View view)
    {
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        extras.putString("botao","ok");
        intent.putExtras(extras);
        setResult(RESULT_OK,intent);
        finish();
    }

    public void implementarCANCEL(View view)
    {
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        extras.putString("botao","cancel");
        intent.putExtras(extras);
        setResult(RESULT_CANCELED,intent);
        finish();
    }
}
