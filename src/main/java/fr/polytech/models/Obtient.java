package fr.polytech.models;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Obtient {
    private int numapprenant;
    private int numaction;
    private Integer valeur;
    private Action actionByNumaction;
    private Apprenant apprenantByNumapprenant;

    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

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

    public Action getActionByNumaction() {
        return actionByNumaction;
    }

    public void setActionByNumaction(Action actionByNumaction) {
        this.actionByNumaction = actionByNumaction;
    }

    public Apprenant getApprenantByNumapprenant() {
        return apprenantByNumapprenant;
    }

    public void setApprenantByNumapprenant(Apprenant apprenantByNumapprenant) {
        this.apprenantByNumapprenant = apprenantByNumapprenant;
    }
}
