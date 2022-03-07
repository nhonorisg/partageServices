package org.sakdavong.partagedeservices.Metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Classe décrivant un utilisateur, serializable pour JSon
public class Utilisateur implements Serializable {
    private String uid;                                 // UID identifiant unique de l'utilisateur (fourni par Firebase)
    private String login, nom, adresse1, adresse2,
                   ville, codePostal, telephone;        // Détails de l'utilisateur
    private List<String> servicesList, reservationList; // Liste des UID des services proposés et des réservations demandées

    // Constructeur sans paramètre pour JSon
    public Utilisateur()
    {
        this.servicesList=new ArrayList<>();   // Initialisation des listes importante
        this.reservationList=new ArrayList<>();
    }

    public Utilisateur(String uid, String login, String nom, String adresse1, String adresse2, String ville, String codePostal, String telephone) {
        this.uid = uid;
        this.login = login;
        this.nom = nom;
        this.adresse1 = adresse1;
        this.adresse2 = adresse2;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.servicesList=new ArrayList<>();
        this.reservationList=new ArrayList<>();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse1() {
        return adresse1;
    }

    public void setAdresse1(String adresse1) {
        this.adresse1 = adresse1;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<String> getServicesList() {
        return servicesList;
    }

    public void setServicesList(List<String> servicesList) {
        this.servicesList = servicesList;
    }

    public List<String> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<String> reservationList) {
        this.reservationList = reservationList;
    }
}
