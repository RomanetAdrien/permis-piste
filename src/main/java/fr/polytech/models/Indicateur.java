package fr.polytech.models;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class Indicateur {
    private int numindic;
    private int numaction;
    private Integer poids;
    private Action actionByNumaction;

    public int getNumindic() {
        return numindic;
    }

    public void setNumindic(int numindic) {
        this.numindic = numindic;
    }

    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Indicateur that = (Indicateur) o;

        if (numindic != that.numindic) return false;
        if (numaction != that.numaction) return false;
        if (poids != null ? !poids.equals(that.poids) : that.poids != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numindic;
        result = 31 * result + numaction;
        result = 31 * result + (poids != null ? poids.hashCode() : 0);
        return result;
    }

    public Action getActionByNumaction() {
        return actionByNumaction;
    }

    public void setActionByNumaction(Action actionByNumaction) {
        this.actionByNumaction = actionByNumaction;
    }
}
