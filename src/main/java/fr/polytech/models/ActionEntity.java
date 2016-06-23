package fr.polytech.models;

import java.util.Collection;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class ActionEntity {
    private int numaction;
    private Integer actNumaction;
    private String libaction;
    private Integer scoremin;
    private ActionEntity actionByActNumaction;
    private Collection<ActionEntity> actionsByNumaction;
    private Collection<EstAssocieEntity> estAssociesByNumaction;
    private Collection<IndicateurEntity> indicateursByNumaction;
    private Collection<ObtientEntity> obtientsByNumaction;
    private Collection<AppartientEntity> appartientsByNumaction;

    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    public Integer getActNumaction() {
        return actNumaction;
    }

    public void setActNumaction(Integer actNumaction) {
        this.actNumaction = actNumaction;
    }

    public String getLibaction() {
        return libaction;
    }

    public void setLibaction(String libaction) {
        this.libaction = libaction;
    }

    public Integer getScoremin() {
        return scoremin;
    }

    public void setScoremin(Integer scoremin) {
        this.scoremin = scoremin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionEntity that = (ActionEntity) o;

        if (numaction != that.numaction) return false;
        if (actNumaction != null ? !actNumaction.equals(that.actNumaction) : that.actNumaction != null) return false;
        if (libaction != null ? !libaction.equals(that.libaction) : that.libaction != null) return false;
        if (scoremin != null ? !scoremin.equals(that.scoremin) : that.scoremin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction;
        result = 31 * result + (actNumaction != null ? actNumaction.hashCode() : 0);
        result = 31 * result + (libaction != null ? libaction.hashCode() : 0);
        result = 31 * result + (scoremin != null ? scoremin.hashCode() : 0);
        return result;
    }

    public ActionEntity getActionByActNumaction() {
        return actionByActNumaction;
    }

    public void setActionByActNumaction(ActionEntity actionByActNumaction) {
        this.actionByActNumaction = actionByActNumaction;
    }

    public Collection<ActionEntity> getActionsByNumaction() {
        return actionsByNumaction;
    }

    public void setActionsByNumaction(Collection<ActionEntity> actionsByNumaction) {
        this.actionsByNumaction = actionsByNumaction;
    }

    public Collection<EstAssocieEntity> getEstAssociesByNumaction() {
        return estAssociesByNumaction;
    }

    public void setEstAssociesByNumaction(Collection<EstAssocieEntity> estAssociesByNumaction) {
        this.estAssociesByNumaction = estAssociesByNumaction;
    }

    public Collection<IndicateurEntity> getIndicateursByNumaction() {
        return indicateursByNumaction;
    }

    public void setIndicateursByNumaction(Collection<IndicateurEntity> indicateursByNumaction) {
        this.indicateursByNumaction = indicateursByNumaction;
    }

    public Collection<ObtientEntity> getObtientsByNumaction() {
        return obtientsByNumaction;
    }

    public void setObtientsByNumaction(Collection<ObtientEntity> obtientsByNumaction) {
        this.obtientsByNumaction = obtientsByNumaction;
    }

    public Collection<AppartientEntity> getAppartientsByNumaction() {
        return appartientsByNumaction;
    }

    public void setAppartientsByNumaction(Collection<AppartientEntity> appartientsByNumaction) {
        this.appartientsByNumaction = appartientsByNumaction;
    }
}
