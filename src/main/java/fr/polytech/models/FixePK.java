package fr.polytech.models;

import java.io.Serializable;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class FixePK implements Serializable {
    private int nummission;
    private int numobjectif;

    public int getNummission() {
        return nummission;
    }

    public void setNummission(int nummission) {
        this.nummission = nummission;
    }

    public int getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(int numobjectif) {
        this.numobjectif = numobjectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FixePK fixePK = (FixePK) o;

        if (nummission != fixePK.nummission) return false;
        if (numobjectif != fixePK.numobjectif) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission;
        result = 31 * result + numobjectif;
        return result;
    }
}
