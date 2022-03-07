package org.sakdavong.partagedeservices.Metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Classe décrivant un service, serializable pour JSon
public class Service implements Serializable {
    private String uid;                         // UID service unique
    private String fournisseurUid;              // UID du fournisseur du service
    private String nom, resume, uniteLocation;  // décription du service
    private float cout;                         // cout par unité de location du service
    private List<String> reservationList;

    public Service() {
        this.reservationList = new ArrayList<>();
    }

    public Service(String fournisseurUid, String nom, String resume, String uniteLocation, float cout) {
        super();
        this.fournisseurUid = fournisseurUid;
        this.nom = nom;
        this.resume = resume;
        this.uniteLocation = uniteLocation;
        this.cout = cout;
        this.reservationList = new ArrayList<>();

    }

    public void recopie(Service s) {
        this.uid = s.uid;
        this.fournisseurUid = s.fournisseurUid;
        this.nom = s.nom;
        this.resume = s.resume;
        this.uniteLocation = s.uniteLocation;
        this.cout = s.cout;
        this.reservationList = reservationList;
    }

    public String getFournisseurUid() {
        return fournisseurUid;
    }

    public void setFournisseurUid(String fournisseurUid) {
        this.fournisseurUid = fournisseurUid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<String> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<String> reservationList) {
        this.reservationList = reservationList;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getUniteLocation() {
        return uniteLocation;
    }

    public void setUniteLocation(String uniteLocation) {
        this.uniteLocation = uniteLocation;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }
}
