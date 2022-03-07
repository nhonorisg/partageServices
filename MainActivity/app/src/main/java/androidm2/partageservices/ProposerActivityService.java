package androidm2.partageservices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.sakdavong.partagedeservices.Metier.Service;
import org.sakdavong.partagedeservices.Metier.Utilisateur;

public class ProposerActivityService extends AppCompatActivity {
    private ApplicationPartageService partageServiceApplication;
    private EditText editTitre, editResume, editCoutUniteLocation;
    private Spinner spinVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposer_service);
        setTitle(R.string.proposer_service);

        // Récupération des informations metier
        partageServiceApplication = (ApplicationPartageService) getApplication();

        // création de la commbo box (le spinner unité de location)
        Spinner SpinProposerService = findViewById(R.id.spin_unite_location);
        String[] items = new String[]{"Heure", "Minute", "Jour", "Demi-journée", "Semaine"};
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        SpinProposerService.setAdapter(adapt);
        SpinProposerService.setSelection(0);

        // Récupération de références des champs de saisis
        editTitre = findViewById(R.id.titre_service);
        editResume = findViewById(R.id.resume_service);
        editCoutUniteLocation = findViewById(R.id.cout_unite_location);
        spinVal = findViewById(R.id.spin_unite_location);

        // Mise en place des écouteurs
        // action du bouton créer service
        Button createSer = findViewById(R.id.creerService);
        createSer.setOnClickListener(view -> {
            // Vérification que les champs sont saisis
            if (editTitre.getText().length() != 0 && editResume.getText().length() != 0 && editCoutUniteLocation.getText().length() != 0) {
                Utilisateur connectedUser = partageServiceApplication.getContexte().getUtilisateur();
                Service serve = new Service();

                // récupération des valeurs saisis par l'utilisateur
                serve.setFournisseurUid(connectedUser.getUid());
                serve.setNom(editTitre.getText().toString());
                serve.setResume(editResume.getText().toString());
                serve.setCout(Float.parseFloat(editCoutUniteLocation.getText().toString()));
                serve.setUniteLocation(spinVal.getSelectedItem().toString());

                // Ajout au contexte
                partageServiceApplication.getContexte().ajouterService(serve);
                finish();
            } else {
                return;
            }
        });

        Button cancel = findViewById(R.id.annulerService);
        cancel.setOnClickListener(view -> {
            finish();
        });
    }
}