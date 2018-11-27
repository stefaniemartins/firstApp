package engtelecom.poo.stefanie.primeiroaplicativo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class QuartaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarta);
    }

    public void proximaTela(View view)
    {
        Intent messageIntent = new Intent(this, imagemActivity.class);
        startActivity(messageIntent);
    }
}
