package fr.polytech.models;

import java.util.Collection;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Action {
    private int numaction;
    private Integer actNumaction;
    private String libaction;
    private Integer scoremin;
    private Action actionByActNumaction;
    private Collection<Action> actionsByNumaction;
    private Collection<Appartient> appartientsByNumaction;
    private Collection<EstAssocie> estAssociesByNumaction;
    private Collection<Indicateur> indicateursByNumaction;
    private Collection<Obtient> obtientsByNumaction;

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

        Action action = (Action) o;

        if (numaction != action.numaction) return false;
        if (actNumaction != null ? !actNumaction.equals(action.actNumaction) : action.actNumaction != null)
            return false;
        if (libaction != null ? !libaction.equals(action.libaction) : action.libaction != null) return false;
        if (scoremin != null ? !scoremin.equals(action.scoremin) : action.scoremin != null) return false;

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

    public Action getActionByActNumaction() {
        return actionByActNumaction;
    }

    public void setActionByActNumaction(Action actionByActNumaction) {
        this.actionByActNumaction = actionByActNumaction;
    }

    public Collection<Action> getActionsByNumaction() {
        return actionsByNumaction;
    }

    public void setActionsByNumaction(Collection<Action> actionsByNumaction) {
        this.actionsByNumaction = actionsByNumaction;
    }

    public Collection<Appartient> getAppartientsByNumaction() {
        return appartientsByNumaction;
    }

    public void setAppartientsByNumaction(Collection<Appartient> appartientsByNumaction) {
        this.appartientsByNumaction = appartientsByNumaction;
    }

    public Collection<EstAssocie> getEstAssociesByNumaction() {
        return estAssociesByNumaction;
    }

    public void setEstAssociesByNumaction(Collection<EstAssocie> estAssociesByNumaction) {
        this.estAssociesByNumaction = estAssociesByNumaction;
    }

    public Collection<Indicateur> getIndicateursByNumaction() {
        return indicateursByNumaction;
    }

    public void setIndicateursByNumaction(Collection<Indicateur> indicateursByNumaction) {
        this.indicateursByNumaction = indicateursByNumaction;
    }

    public Collection<Obtient> getObtientsByNumaction() {
        return obtientsByNumaction;
    }

    public void setObtientsByNumaction(Collection<Obtient> obtientsByNumaction) {
        this.obtientsByNumaction = obtientsByNumaction;
    }
}
