package fr.polytech.models;

import java.io.Serializable;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class ObtientPK implements Serializable {
    private int numapprenant;
    private int numaction;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObtientPK obtientPK = (ObtientPK) o;

        if (numapprenant != obtientPK.numapprenant) return false;
        if (numaction != obtientPK.numaction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant;
        result = 31 * result + numaction;
        return result;
    }
}
