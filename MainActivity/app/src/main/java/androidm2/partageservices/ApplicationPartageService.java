package androidm2.partageservices;

import android.app.Application;

import org.sakdavong.partagedeservices.Metier.Contexte;

public class ApplicationPartageService extends Application {
    private Contexte contexte;     // accés à la classe métier

    @Override
    public void onCreate() {
        super.onCreate();
        // initialisation de l 'application au bon moment avant le début des activités
        contexte = new Contexte();
        System.out.println("initialisation faite");
    }

    // getter du contexte
    public Contexte getContexte() {
        return contexte;
    }
}
