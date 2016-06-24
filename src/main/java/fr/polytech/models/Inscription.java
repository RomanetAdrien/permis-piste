package fr.polytech.models;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Inscription {
    private int numapprenant;
    private int numjeu;
    private Apprenant apprenantByNumapprenant;
    private Jeu jeuByNumjeu;

    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscription that = (Inscription) o;

        if (numapprenant != that.numapprenant) return false;
        if (numjeu != that.numjeu) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant;
        result = 31 * result + numjeu;
        return result;
    }

    public Apprenant getApprenantByNumapprenant() {
        return apprenantByNumapprenant;
    }

    public void setApprenantByNumapprenant(Apprenant apprenantByNumapprenant) {
        this.apprenantByNumapprenant = apprenantByNumapprenant;
    }

    public Jeu getJeuByNumjeu() {
        return jeuByNumjeu;
    }

    public void setJeuByNumjeu(Jeu jeuByNumjeu) {
        this.jeuByNumjeu = jeuByNumjeu;
    }
}
