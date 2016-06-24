package fr.polytech.models;

import java.io.Serializable;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class PossedePK implements Serializable {
    private int numaction;
    private int numregle;

    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    public int getNumregle() {
        return numregle;
    }

    public void setNumregle(int numregle) {
        this.numregle = numregle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PossedePK possedePK = (PossedePK) o;

        if (numaction != possedePK.numaction) return false;
        if (numregle != possedePK.numregle) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction;
        result = 31 * result + numregle;
        return result;
    }
}
