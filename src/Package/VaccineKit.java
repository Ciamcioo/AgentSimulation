package Package;

import Map.Map;

public class VaccineKit extends Package{
    public VaccineKit(int coordinateX,int coordinateY, Map mapPartOf){

        super(coordinateX, coordinateY, mapPartOf);
    }
    @Override
    public String toString(){
        return "K";
    }
    
}
