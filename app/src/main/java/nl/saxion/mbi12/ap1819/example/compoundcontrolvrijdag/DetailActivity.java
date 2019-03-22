package nl.saxion.mbi12.ap1819.example.compoundcontrolvrijdag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import nl.saxion.mbi12.ap1819.example.compoundcontrolvrijdag.views.ColorSlidersView;
import nl.saxion.mbi12.ap1819.example.compoundcontrolvrijdag.views.Updatable;

public class DetailActivity extends AppCompatActivity implements Updatable {
    private Button btnWelkeKleur;
    private ColorSlidersView csvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnWelkeKleur = findViewById(R.id.btnWelkeKleur);
        csvDetail = findViewById(R.id.csvDetail);

        btnWelkeKleur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "Color value (int): " + csvDetail.getColor(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void update() {
        Log.d(getClass().getCanonicalName(), "update() called");
    }
}
