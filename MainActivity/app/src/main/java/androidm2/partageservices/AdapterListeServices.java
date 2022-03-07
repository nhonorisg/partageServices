package androidm2.partageservices;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.sakdavong.partagedeservices.Metier.Service;

import java.util.ArrayList;
import java.util.List;

public class AdapterListeServices extends RecyclerView.Adapter<ViewHolderCelluleService>
implements Filterable {
    private final List<Service> listeServices;
    private List<Service> listeFiltree;  // iniatialisation d'une liste qui nous servira de filtre des services

    public AdapterListeServices(List<Service> listService) {
        this.listeServices = listService;
        // Cloner pour listeFIltree
        this.listeFiltree = new ArrayList<>();
        listeFiltree.addAll(listService);
    }

    @NonNull
    @Override
    public ViewHolderCelluleService onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Chargement du layout dédié à l'affichage d'une cellule décrivant un service
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cellule_service, parent, false);
        return new ViewHolderCelluleService(v); // on retourne le ViewHolder qui a mis les raccourcis sur cette View
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolderCelluleService holder, int position) {
        Service lesService = listeFiltree.get(position);
        // On met à jour en utilisant les attributs publics (optimisation demandé par Android)
        // récupération du titre du service
        holder.titreService.setText(lesService.getNom());
        // récupération du résumé du service
        holder.SummaryService.setText(lesService.getResume());
        // récupération du prix du service
        holder.prixService.setText(" " + lesService.getCout() + " € par ");
        // récupération de l'unité de location du service
        holder.tempsService.setText(lesService.getUniteLocation());
        // action du boutton réserver un service
        holder.reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jeReserve = new Intent(view.getContext(), reservationDesServices.class);
                jeReserve.putExtra("uid", lesService.getUid());
                view.getContext().startActivity(jeReserve);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listeFiltree.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence chaineRechercher) {
                String charString = chaineRechercher.toString();

                //  Réalisation du filtrage
                FilterResults filtre = new FilterResults();
                listeFiltree.clear();

                // Ici vider et remplir listeServicesFiltree (à partir de listeService...)
                for (Service unService : listeServices) {
                    String titre = unService.getNom();
                    String summary = unService.getResume();

                    if (titre.contains(chaineRechercher) || summary.contains(chaineRechercher) || chaineRechercher.equals("")) {
                        listeFiltree.add(unService);
                    } else {
                        System.out.println("le service que vous chercher n'a pas étais trouvé");
                    }
                }
                //
                filtre.values = listeFiltree;
                return filtre;
            }

            @Override
            protected void publishResults(CharSequence chaineRechercher, FilterResults filtre) {
                listeFiltree = (List<Service>) filtre.values;
                notifyDataSetChanged();
            }
        };
    }
}
