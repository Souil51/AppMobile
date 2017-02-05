package com.example.maxence.myapplication;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button btnCalculer = (Button) findViewById(R.id.btnCalculer);
        final TextView txtResultat = (TextView) findViewById(R.id.lblResultat);
        final TextView txtPoids = (TextView) findViewById(R.id.txtPoids);
        final TextView txtTaille = (TextView) findViewById(R.id.txtTaille);
        final RadioButton cbCentimetre = (RadioButton) findViewById(R.id.btnCentimetre);

        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String strPoids = txtPoids.getText().toString();
                strPoids = strPoids.replace(',','.');
                double poids = Double.parseDouble(strPoids);

                String strTaille = txtTaille.getText().toString();
                strTaille = strTaille.replace(',','.');
                double taille = Double.parseDouble(strTaille);
                if(cbCentimetre.isChecked())
                    taille /= 100;

                txtResultat.setText("Résultat : " + (poids/(taille*taille)));
            }
        });

        Button btnRaz = (Button) findViewById(R.id.btnRaz);

        btnRaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                txtResultat.setText("Résultat : ");
                txtPoids.setText("");
                txtTaille.setText("");
            }
        });

    }
}
