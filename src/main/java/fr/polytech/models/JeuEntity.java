package fr.polytech.models;

import java.util.Collection;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class JeuEntity {
    private int numjeu;
    private String libellejeu;
    private Collection<MissionEntity> missionsByNumjeu;
    private Collection<AppartientEntity> appartientsByNumjeu;
    private Collection<InscriptionEntity> inscriptionsByNumjeu;

    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    public String getLibellejeu() {
        return libellejeu;
    }

    public void setLibellejeu(String libellejeu) {
        this.libellejeu = libellejeu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JeuEntity jeuEntity = (JeuEntity) o;

        if (numjeu != jeuEntity.numjeu) return false;
        if (libellejeu != null ? !libellejeu.equals(jeuEntity.libellejeu) : jeuEntity.libellejeu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu;
        result = 31 * result + (libellejeu != null ? libellejeu.hashCode() : 0);
        return result;
    }

    public Collection<MissionEntity> getMissionsByNumjeu() {
        return missionsByNumjeu;
    }

    public void setMissionsByNumjeu(Collection<MissionEntity> missionsByNumjeu) {
        this.missionsByNumjeu = missionsByNumjeu;
    }

    public Collection<AppartientEntity> getAppartientsByNumjeu() {
        return appartientsByNumjeu;
    }

    public void setAppartientsByNumjeu(Collection<AppartientEntity> appartientsByNumjeu) {
        this.appartientsByNumjeu = appartientsByNumjeu;
    }

    public Collection<InscriptionEntity> getInscriptionsByNumjeu() {
        return inscriptionsByNumjeu;
    }

    public void setInscriptionsByNumjeu(Collection<InscriptionEntity> inscriptionsByNumjeu) {
        this.inscriptionsByNumjeu = inscriptionsByNumjeu;
    }
}
