package androidm2.partageservices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.sakdavong.partagedeservices.Metier.Service;

public class reservationDesServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_des_services);
        setTitle("Reserver");


        String uid = getIntent().getExtras().getString("uid");
        ApplicationPartageService app = (ApplicationPartageService) getApplication();
        Service serviceAreserver = app.getContexte().findServiveByUid(uid);


        TextView titreService = findViewById(R.id.titreServiceView);
        TextView SummaryService = findViewById(R.id.resumeServiceView);
        TextView prixService = findViewById(R.id.prixService);
        TextView tempsService = findViewById(R.id.dureeService);
        TextView cout = findViewById(R.id.prixTotalResa);
        EditText quantiteServ = findViewById(R.id.nbService);

        // cacher la visibilite du bouton de la cardview
        Button reserverService = findViewById(R.id.reservation_service);
        reserverService.setVisibility(View.GONE);


        quantiteServ.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (!quantiteServ.getText().toString().equals("")){
                    float v = serviceAreserver.getCout() * Float.parseFloat(quantiteServ.getText().toString());
                    cout.setText(" " + v + "€");
                }

                return false;
            }
        });

        titreService.setText(serviceAreserver.getNom());
        SummaryService.setText(serviceAreserver.getResume());
        prixService.setText(" " + serviceAreserver.getCout() + " € par ");
        tempsService.setText(serviceAreserver.getUniteLocation());

        // action du boutton d'annulation
        Button annuler = findViewById(R.id.AnnulerResa);
        annuler.setOnClickListener(view -> {
            finish();
        });

    }
}