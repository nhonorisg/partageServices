package androidm2.partageservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.partage_service);

        // initialisation du findViewById des boutons proposer et chercher un services
        Button boutProposer = findViewById(R.id.proposer);
        Button boutChercher = findViewById(R.id.chercher);

        // Action du bouton proposer un service
        boutProposer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent propSerActivity = new Intent(MainActivity.this, ProposerActivityService.class);
                startActivity(propSerActivity);
            }
        });

        // Action du bouton rechercher un service
        boutChercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent annuaireSer = new Intent(MainActivity.this, rechercheService.class);
                startActivity(annuaireSer);
            }
        });
    }
}