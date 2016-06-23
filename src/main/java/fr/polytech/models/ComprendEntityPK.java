package fr.polytech.models;

import java.io.Serializable;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class ComprendEntityPK implements Serializable {
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

        ComprendEntityPK that = (ComprendEntityPK) o;

        if (numjeu != that.numjeu) return false;
        if (nummission != that.nummission) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu;
        result = 31 * result + nummission;
        return result;
    }
}
