package Package;
import AgentClasses.Agent;
import Map.Map;
import Core.ObjectOfMap;
import Map.EmptyField;
public abstract class Package extends ObjectOfMap implements PackageMethods {
    private  double chanceOfSpawn;
    private boolean isEmpty;
    public Package(Map mapPartOf,double chanceOfSpawn){
        super(mapPartOf);
        this.setChanceOfSpawn(chanceOfSpawn);
        this.isEmpty = false;
    }
    public Package(int coordinateX,int coordinateY, Map mapPartOf, double chanceOfSpawn){
        super(coordinateX, coordinateY, mapPartOf);
        this.isEmpty = false;
    }
    public double getChanceOfSpawn(){ // Metoda zwraca szanse pojawienia się pakietu na mapie
        return this.chanceOfSpawn;
    }
    public void setChanceOfSpawn(double chanceOfSpawn){
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
        // TODO napisać metode odpowiedzialna za interakcje typu pakiet agent
        if(agentToBeInfluence.getCoordinateX()== getCoordinateX() && agentToBeInfluence.getCoordinateY() == getCoordinateY()){
            //TODO Coś się ma stać z agentem. Co?
            agentToBeInfluence.changingStatusOfAgent(); //TODO co tu ma się w zasadzie dziać?
        }
    }
    public void searching(){
        try {
            throw new Exception("Error this object cannot search");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void destructionOfPackage(){
        EmptyField emptyField = new EmptyField(this.getCoordinateX(), this.getCoordinateY(), this.getMapPartOf());
    }
}
