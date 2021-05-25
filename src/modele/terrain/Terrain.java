package modele.terrain;

public class Terrain {
    private int ptsDeplacement;
    private double bonusDefense;

    public Terrain() {
    }

    public String toString(){
        return "Point de placement " + this.ptsDeplacement+ " Point de defense  " + this.bonusDefense ;
    }

    public double getBonusDefense() {
        return bonusDefense;
    }
    public int getPtsDeplacement() {
        return ptsDeplacement;
    }

    public void setBonusDefense(double bonusDefense) {
        this.bonusDefense = bonusDefense;
    }
    public void setPtsDeplacement(int ptsDeplacement) {
        this.ptsDeplacement = ptsDeplacement;
    }
}