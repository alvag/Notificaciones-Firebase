package com.maxalva.notificacionesfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    Button btnToken;
    TextView textViewToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewToken = (TextView) findViewById(R.id.textViewToken);
        btnToken = (Button) findViewById(R.id.btnToken);
        btnToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tokenFirebase = FirebaseInstanceId.getInstance().getToken();
                textViewToken.setText(tokenFirebase);
                System.out.println("tokenFirebase ==> " + tokenFirebase);
            }
        });

        if (getIntent().getExtras() != null){
            System.out.println("Datos recibidos (Intent)");
            String user = getIntent().getExtras().getString("user");
            System.out.println("Usuario: " + user);
            textViewToken.setText(user);
        }
    }
}
