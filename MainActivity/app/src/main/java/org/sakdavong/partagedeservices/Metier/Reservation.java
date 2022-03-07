package org.sakdavong.partagedeservices.Metier;


import java.io.Serializable;

// Classe décrivant une réservation, serializable pour JSon
public class Reservation implements Serializable {
    private String uid;             // Identifiant unique
    private String dateTime;        // Exprimé en String afin d'éviter le conflit Date sur JSon et l'incompatibilité LocalDateTime avant Android 8.0
    private int quantite;           // Nombre d'unité de réservation faite (par exemple 3 heures si l'unité de réservation est en heures)
    private String utilisateurUid;  // UID de l'utilisateur ayant réalisé la réservation
    private String serviceUid;      // UID du service réservé
    public enum EtatReservation {attenteValidation, validee, refusee};
    private EtatReservation etatReservation;

    // Constructeur vide nécessaire pour JSon
    public Reservation()
    { }

    public Reservation(String dateTime, int quantite, String utilisateurUid, String serviceUid) {
        this.dateTime = dateTime;
        this.quantite = quantite;
        this.utilisateurUid = utilisateurUid;
        this.serviceUid = serviceUid;
        etatReservation=EtatReservation.attenteValidation;
    }

    // Recopie de toutes les valeurs d'une réservation
    public void recopie(Reservation reservation) {
        this.uid = reservation.uid;
        this.dateTime = reservation.dateTime;
        this.quantite = reservation.quantite;
        this.utilisateurUid = reservation.utilisateurUid;
        this.serviceUid = reservation.serviceUid;
        etatReservation=reservation.etatReservation;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getServiceUid() {
        return serviceUid;
    }

    public void setServiceUid(String serviceUid) {
        this.serviceUid = serviceUid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUtilisateurUid() {
        return utilisateurUid;
    }

    public void setUtilisateurUid(String utilisateurUid) {
        this.utilisateurUid = utilisateurUid;
    }

    public EtatReservation getEtatReservation() {
        return etatReservation;
    }

    public void setEtatReservation(EtatReservation etatReservation) {
        this.etatReservation = etatReservation;
    }
}
