package AgendClasses;
import Map.Map;

import java.util.Random;

public class SickAgent extends Agent{
    private int dayTillEndOfIllness;
    private double chanceOfDeath;
    public SickAgent(int coordinateX, int coordinateY, Map partMapOf, int dayTillEndOfIllness, double chanceOfDeath){
        super(coordinateX, coordinateY, partMapOf);
        this.chanceOfDeath = chanceOfDeath;
        this.dayTillEndOfIllness = dayTillEndOfIllness;
    }
    public int getDayTillEndOfIllness(){
        return this.dayTillEndOfIllness;
    }
    public void setDayTillEndOfIllness(int dayTillEndOfIllness){
        if(dayTillEndOfIllness > 0)
            this.dayTillEndOfIllness = dayTillEndOfIllness ;
    }
    public double getChanceOfDeath(){
        return this.chanceOfDeath;
    }
    public void setChanceOfDeath(double chanceOfDeath){
        if(chanceOfDeath > 0 && chanceOfDeath < 1)
         this.chanceOfDeath = chanceOfDeath;
    }


    @Override
    public void chengingStatusOfAgent(Agent agent){
        // TODO zmiana statusu obiektu poprzez tworzenie nowego obiektu, który zastąpi ten w tym momencie zmienany
    } @Override
    public String toString(){
        return "S";
    }

}