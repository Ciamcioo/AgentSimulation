package Package;
import AgentClasses.Agent;
import Map.Map;
import Map.ObjectOfMap;
public abstract class Package extends ObjectOfMap implements PackageMethods {
    private boolean isEmpty;
    // Konstruktor klasy Package
    public Package(int coordinateX,int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);
        this.isEmpty = false;
    }
    public boolean isEmpty() { // Meotda zwraca informacje czy pakiet  jest pusty
        return isEmpty;
    }
    public void setEmpty(){ // Metoda ustawia wartość pola isEmpty na true
        this.isEmpty = true;
    }
    public void searching(){
        try {
            throw new Exception("Error this object cannot search");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
