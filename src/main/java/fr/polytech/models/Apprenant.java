package fr.polytech.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by John.
 */
@Entity
public class Apprenant {
    private int numapprenant;
    private String nomapprenant;
    private String prenomapprenant;
    private Collection<Obtient> obtientsByNumapprenant;

    public Apprenant() {
    }

    public Apprenant(String nomapprenant, String prenomapprenant) {
        this.nomapprenant = nomapprenant;
        this.prenomapprenant = prenomapprenant;
    }

    @Id
    @Column(name = "NUMAPPRENANT", nullable = false)
    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Basic
    @Column(name = "NOMAPPRENANT", nullable = true, length = 25)
    public String getNomapprenant() {
        return nomapprenant;
    }

    public void setNomapprenant(String nomapprenant) {
        this.nomapprenant = nomapprenant;
    }

    @Basic
    @Column(name = "PRENOMAPPRENANT", nullable = true, length = 25)
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

    @OneToMany(mappedBy = "apprenantByNumapprenant")
    public Collection<Obtient> getObtientsByNumapprenant() {
        return obtientsByNumapprenant;
    }

    public void setObtientsByNumapprenant(Collection<Obtient> obtientsByNumapprenant) {
        this.obtientsByNumapprenant = obtientsByNumapprenant;
    }
}
