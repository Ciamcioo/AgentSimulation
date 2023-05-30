package Package;
import AgendClasses.Agent;
import Map.Map;
import Core.ObjectOfMap;

public abstract class Package extends ObjectOfMap implements PackageMethods {
    private double chanceOfSpawn;
    private boolean isEmpty;
    public Package(int coordinateX,int coordinateY, Map mapPartOf, double chanceOfSpawn){   // Konstruktor klasy Package, który wywołuje konstruktor klasy ObjectOfMap

        super(coordinateX, coordinateY, mapPartOf);
        this.chanceOfSpawn = chanceOfSpawn;
        this.isEmpty = false;
    }
    public double getChanceOfSpawn(){ // Metoda zwraca szanse pojawienia się pakietu na mapie
        return this.chanceOfSpawn;
    }
    public void setChanceOfSpawn(double chanceOfSpawn){ // Meotda ustawia szanse pojawienia się pakietu na mapie
        if(chanceOfSpawn > 0 && chanceOfSpawn < 1)
            this.chanceOfSpawn = chanceOfSpawn;
    }
    public boolean isEmpty() { // Meotda zwraca informacje czy pakiet  jest pusty
        return isEmpty;
    }
    public void setEmpty(){ // Metoda ustawia wartość pola isEmpty na true
        this.isEmpty = true;
    }


    public void beingPickedUp(Agent agentToBeInfluence) {
        // TODO napisać metode odpowiedzialna za interakcje typu pakie agent
    }
}
