package fr.polytech.models;

import javax.persistence.*;

/**
 * Created by John.
 */
@Entity
@IdClass(ObtientPK.class)
public class Obtient {
    private int numapprenant;
    private int numaction;
    private Integer valeur;
    private Action actionByNumaction;
    private Apprenant apprenantByNumapprenant;

    @Id
    @Column(name = "NUMAPPRENANT", nullable = false)
    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Id
    @Column(name = "NUMACTION", nullable = false)
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    @Basic
    @Column(name = "VALEUR", nullable = true)
    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Obtient obtient = (Obtient) o;

        if (numapprenant != obtient.numapprenant) return false;
        if (numaction != obtient.numaction) return false;
        if (valeur != null ? !valeur.equals(obtient.valeur) : obtient.valeur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant;
        result = 31 * result + numaction;
        result = 31 * result + (valeur != null ? valeur.hashCode() : 0);
        return result;
    }

    @ManyToOne
    public Action getActionByNumaction() {
        return actionByNumaction;
    }

    public void setActionByNumaction(Action actionByNumaction) {
        this.actionByNumaction = actionByNumaction;
    }

    @ManyToOne
    public Apprenant getApprenantByNumapprenant() {
        return apprenantByNumapprenant;
    }

    public void setApprenantByNumapprenant(Apprenant apprenantByNumapprenant) {
        this.apprenantByNumapprenant = apprenantByNumapprenant;
    }
}
