package fr.polytech.models;

import java.util.Collection;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Apprenant {
    private int numapprenant;
    private String nomapprenant;
    private String prenomapprenant;
    private Collection<Inscription> inscriptionsByNumapprenant;
    private Collection<Obtient> obtientsByNumapprenant;

    public void Apprenant(String nom, String prenom){
        nomapprenant ="nom";
        prenomapprenant="prenom";
    }

    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    public String getNomapprenant() {
        return nomapprenant;
    }

    public void setNomapprenant(String nomapprenant) {
        this.nomapprenant = nomapprenant;
    }

    public String getPrenomapprenant() {
        return prenomapprenant;
    }

    public void setPrenomapprenant(String prenomapprenant) {
        this.prenomapprenant = prenomapprenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apprenant apprenant = (Apprenant) o;

        if (numapprenant != apprenant.numapprenant) return false;
        if (nomapprenant != null ? !nomapprenant.equals(apprenant.nomapprenant) : apprenant.nomapprenant != null)
            return false;
        if (prenomapprenant != null ? !prenomapprenant.equals(apprenant.prenomapprenant) : apprenant.prenomapprenant != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant;
        result = 31 * result + (nomapprenant != null ? nomapprenant.hashCode() : 0);
        result = 31 * result + (prenomapprenant != null ? prenomapprenant.hashCode() : 0);
        return result;
    }

    public Collection<Inscription> getInscriptionsByNumapprenant() {
        return inscriptionsByNumapprenant;
    }

    public void setInscriptionsByNumapprenant(Collection<Inscription> inscriptionsByNumapprenant) {
        this.inscriptionsByNumapprenant = inscriptionsByNumapprenant;
    }

    public Collection<Obtient> getObtientsByNumapprenant() {
        return obtientsByNumapprenant;
    }

    public void setObtientsByNumapprenant(Collection<Obtient> obtientsByNumapprenant) {
        this.obtientsByNumapprenant = obtientsByNumapprenant;
    }
}
