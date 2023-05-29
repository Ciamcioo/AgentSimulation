package Package;
import AgendClasses.Agent;
import Map.Map;
import Core.ObjectOfMap;

public abstract class Package extends ObjectOfMap implements PackageMethods {
    private double chanceOfSpawn;
    private boolean isEmpty;
    public Package(int coordinateX,int coordinateY, Map mapPartOf, double chanceOfSpawn){

        super(coordinateX, coordinateY, mapPartOf);
        this.chanceOfSpawn = chanceOfSpawn;
        this.isEmpty = false;
    }
    public double getChanceOfSpawn(){
        return this.chanceOfSpawn;
    }
    public void setChanceOfSpawn(double chanceOfSpawn){
        if(chanceOfSpawn > 0 && chanceOfSpawn < 1)
            this.chanceOfSpawn = chanceOfSpawn;
    }
    public boolean isEmpty() {
        return isEmpty;
    }
    public void setEmpty(){
        this.isEmpty = true;
    }


    public void beingPickedUp(Agent agentToBeInfluence) {

    }
}
