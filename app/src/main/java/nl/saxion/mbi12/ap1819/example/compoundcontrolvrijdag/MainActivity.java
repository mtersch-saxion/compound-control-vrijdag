package nl.saxion.mbi12.ap1819.example.compoundcontrolvrijdag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import nl.saxion.mbi12.ap1819.example.compoundcontrolvrijdag.views.ColorSlidersView;
import nl.saxion.mbi12.ap1819.example.compoundcontrolvrijdag.views.Updatable;

public class MainActivity extends AppCompatActivity implements Updatable {
    private ColorSlidersView csvTest;
//    private SeekBar sbRed_test;
    private Button btnWelkeKleur, btnDetailScherm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        csvTest = findViewById(R.id.csvTest);
        btnWelkeKleur = findViewById(R.id.btnWelkeKleur);
        btnDetailScherm = findViewById(R.id.btnDetailScherm);

        csvTest.setRed(127);
        csvTest.setGreen(-191);
        csvTest.setBlue(412);
//        sbRed_test = csvTest.findViewById(R.id.sbRed);
//
//        sbRed_test.setProgress(127);
        csvTest.setColorChangeListener(new ColorSlidersView.ColorChangeListener() {
            @Override
            public void onColorChanged() {
                // Toast.makeText(MainActivity.this, "onColorChange event!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRedToMax() {
                Toast.makeText(MainActivity.this, "Red set to max!", Toast.LENGTH_SHORT).show();
            }
        });

        btnWelkeKleur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Color value (int): " + csvTest.getColor(), Toast.LENGTH_SHORT).show();
            }
        });

        btnDetailScherm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(detailIntent);
            }
        });
    }

    @Override
    public void update() {
        Log.d(getClass().getCanonicalName(), "update() called");
    }
}
