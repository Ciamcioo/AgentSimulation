package Package;
import Map.Map;
import Core.ObjectOfMap;

public abstract class Package extends ObjectOfMap {
    public Package(int coordinateX,int coordinateY, Map mapPartOf){
        super(coordinateX, coordinateY, mapPartOf);
    }
    private double chanceOfSpawn;
    private boolean isEmpty;
}
