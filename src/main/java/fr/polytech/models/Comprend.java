package fr.polytech.models;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Comprend {
    private int numjeu;
    private int nummission;

    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    public int getNummission() {
        return nummission;
    }

    public void setNummission(int nummission) {
        this.nummission = nummission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comprend comprend = (Comprend) o;

        if (numjeu != comprend.numjeu) return false;
        if (nummission != comprend.nummission) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu;
        result = 31 * result + nummission;
        return result;
    }
}
