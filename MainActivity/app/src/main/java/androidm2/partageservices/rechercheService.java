package androidm2.partageservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import org.sakdavong.partagedeservices.Metier.Service;

import java.util.List;

public class rechercheService extends AppCompatActivity {
    RecyclerView serviceView;
    AdapterListeServices adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_service);
        setTitle("Recherche de service");

        serviceView = findViewById(R.id.ViewServices);
        /* Mise en place du gestionnaire de disposition */
        serviceView.setLayoutManager(new LinearLayoutManager(this));
        ApplicationPartageService app = (ApplicationPartageService) getApplication();
        List<Service> services = app.getContexte().getServiceList();
        adapter = new AdapterListeServices(services);
        serviceView.setAdapter(adapter);

        // Mise en place du champ de recherche
        SearchView espaceRecherche = findViewById(R.id.barRecherche);
        espaceRecherche.setMaxWidth(Integer.MAX_VALUE);

        /* Ecoute du champ de saisi de la recherche et on actualise
           l'adapter quand c'est nécéssaire
         */
        espaceRecherche.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String requete) {
                // filtrage à chaque qu'on valide sa recherche
                //adapter.getFilter().filter(requete);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filtrage en fonction des caractères saisis dans la recherche
                adapter.getFilter().filter(query);
                return false;
            }
        });
    }
}