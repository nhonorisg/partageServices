package org.sakdavong.partagedeservices.Metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe métier qui permet d'accéder aux différentes listes de l'application et de faire des recherches par UID
public class Contexte {
    private Utilisateur utilisateur=null;                   // L'utilisateur connecté
    private List<Service> serviceList=null;                 // La liste complete des services
    private List<Reservation> listMesReservations=null;     // La liste des réservation faites par l'utilisateur

    private static Map<Class, String> keysUid = new HashMap<>();/// La liste statique pour générer des clés uniques

    public Contexte() {
        System.out.println("------>   Réinitialisation du contexte");

        // Dans un premier temps on connecte directement un utilisateur de test
        utilisateur=new Utilisateur(getUniqueUid(Utilisateur.class),"sakdavongvr@gmail.com", "Sakdavong Jean-Christophe",
                "","","","","0606060606");

        // Remplissage de la liste des services avec des utilisateurs factices
        serviceList=new ArrayList<>();

        Utilisateur dupontin=new Utilisateur(getUniqueUid(Utilisateur.class),"popol.dupontin@gmail.com", "Dupontin Popol",
                "", "","","","0606060608");

        ajouterService(new Service(dupontin.getUid(), "Jardinage","Réalise petites taches de jardinage",
                "Heures", 10.0f));
        ajouterService(new Service(dupontin.getUid(), "Maçonnerie","Réalise maçonnerie d'intérieur",
                "Heures", 12.0f));

        Utilisateur durantin=new Utilisateur(getUniqueUid(Utilisateur.class), "popol.durantin@gmail.com", "Durantin Popol", "","","","","0606060608");
        ajouterService(new Service(durantin.getUid(), "Plomberie","Réalise plomberie","Jours", 200.0f));
        ajouterService(new Service(durantin.getUid(), "Maçonnerie","Réalise maçonnerie d'intérieur","Jours", 250.0f));
        Utilisateur pontin=new Utilisateur(getUniqueUid(Utilisateur.class),"raymond.pontin@gmail.com", "Pontin Raymond", "","","","","0606060608");
        ajouterService(new Service(pontin.getUid(), "Cours de maths","Donne cours de mathématiques niveau collège","Heures", 40.0f));
        ajouterService(new Service(pontin.getUid(), "Cours de maths","Donne cours de mathématiques niveau lycée","Heures", 45.0f));
        ajouterService(new Service(pontin.getUid(), "Cours de maths","Donne cours de mathématiques niveau licence de sciences","Heures", 50.0f));

        // Création de la liste de mes réservations
        listMesReservations = new ArrayList<>();
    }

    // Méthode permettant d'ajouter un service à la liste des services, c'est elle qui obtient l'identifiant unique du service
    public void ajouterService(Service service)
    {
        // Demande une clé unique (UID) pour le service
        String uid = getUniqueUid(Service.class);

        service.setUid(uid);
        utilisateur.getServicesList().add(service.getUid());
        serviceList.add(service);
        System.out.println("On a ajouté le service "+service.getNom()+" - "+service.getUid());
    }

    // Crée la liste des services proposés par l'utilisateur connecté à partir de la liste d'UID qu'elle possede
    // Recalculée chaque fois (méthode 1)
    public List<Service> getListServicesProposesParMoi()
    {
        List<Service> listServicesProposesParMoi=new ArrayList<>();

        for (String uidService: utilisateur.getServicesList())
        {
            listServicesProposesParMoi.add(findServiveByUid(uidService));
        }

        return listServicesProposesParMoi;
    }

    public void ajouterReservation(Reservation reservation)
    {
        // Demande une clé unique (UID) pour la réservation
        String uid = getUniqueUid(Reservation.class);
        reservation.setUid(uid);

        utilisateur.getReservationList().add(reservation.getUid());
        listMesReservations.add(reservation); // Utilisation d'une liste spécifique car elle sera afficher par une activité
        Service service = findServiveByUid(reservation.getServiceUid()); // Ne sera pas utilisé car nous passerons à Firebase
        System.out.println("Ajout de la réservation au service"+service.getNom()+" - "+service.getUid()+" avec la liste des réservations "+service.getReservationList());
        service.getReservationList().add(uid); // Ne sera pas utilisé car nous passerons à Firebase
//        System.out.println("Réservation:"+ reservation.getUid()+" "+reservation.getServiceUid()+" à "+reservation.getDateTime()+" de #"+reservation.getQuantite()+" ");
    }

    public void supprimerReservation(Reservation reservation)
    {
        listMesReservations.remove(reservation);
        utilisateur.getReservationList().remove(reservation.getUid());
        findServiveByUid(reservation.getServiceUid()).getReservationList().remove(reservation.getUid());
    }

    // Crée la liste des réservations faites par l'utilisateur connecté à partir de la liste d'UID qu'elle possede
    // Calculée une seule fois.
    // !!! Par la suite elle sera mise à jour automatiquement par les callbacks Firebase lors des ajouts de réservation (méthode 2) !!!
    public List<Reservation> getListeMesReservations()
    {
        return listMesReservations;
    }

    // Recherche d'une service par son UID dans la liste des services en mémoire
    public Service findServiveByUid(String uid)
    {
        for (Service s: serviceList) {
            System.out.println("Service: "+s.getNom()+" - "+s.getUid());
            if (s.getUid().equals(uid))
                return s;
        }

        System.out.println("Service d'uid:"+uid+" introuvable");
        return null;
    }

    // Génération d'une UID unique par classe
    public String getUniqueUid(Class c)
    {
        if (!keysUid.containsKey(c))
        {
            keysUid.put(c,"0");
        }

        String uidCourante = keysUid.get(c);
        Integer oldUid = new Integer(uidCourante);
        String newUid = ""+(oldUid+1);
        keysUid.put(c, newUid);  // On fait passer au suivant et on convertit en chaine

        return newUid;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }
}
