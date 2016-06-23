package fr.polytech.models;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Fixe {
    private int nummission;
    private int numobjectif;
    private Objectif objectifByNumobjectif;
    private Mission missionByNummission;

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

        Fixe fixe = (Fixe) o;

        if (nummission != fixe.nummission) return false;
        if (numobjectif != fixe.numobjectif) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission;
        result = 31 * result + numobjectif;
        return result;
    }

    public Objectif getObjectifByNumobjectif() {
        return objectifByNumobjectif;
    }

    public void setObjectifByNumobjectif(Objectif objectifByNumobjectif) {
        this.objectifByNumobjectif = objectifByNumobjectif;
    }

    public Mission getMissionByNummission() {
        return missionByNummission;
    }

    public void setMissionByNummission(Mission missionByNummission) {
        this.missionByNummission = missionByNummission;
    }
}
