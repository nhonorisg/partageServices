package androidm2.partageservices;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class ViewHolderCelluleService extends RecyclerView.ViewHolder {
    public TextView titreService;
    public TextView SummaryService;
    public TextView prixService;
    public TextView tempsService;
    public  Button reserver;

    public ViewHolderCelluleService(@NonNull View itemView) {
        super(itemView);
        titreService = itemView.findViewById(R.id.titreServiceView);
        SummaryService = itemView.findViewById(R.id.resumeServiceView);
        prixService = itemView.findViewById(R.id.prixService);
        tempsService = itemView.findViewById(R.id.dureeService);
        reserver = itemView.findViewById(R.id.reservation_service);
    }
}
