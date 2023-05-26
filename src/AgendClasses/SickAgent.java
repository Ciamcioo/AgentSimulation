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
        // TODO dopisać kontrole błędów przed wprowadzaniem złej watości
        this.dayTillEndOfIllness = dayTillEndOfIllness ;
    }
    public double getChanceOfDeath(){
        return this.chanceOfDeath;
    }
    public void setChanceOfDeath(double chanceOfDeath){
        // TODO dopisać kontrole błędów przed wprowadzeniem złej wartości
        this.chanceOfDeath = chanceOfDeath;
    }

    @Override
    public void checkPosition(int X, int Y) {

    }

    @Override
    public void chengingStatusOfAgent(Agent agent){
        // TODO zmiana statusu obiektu poprzez tworzenie nowego obiektu, który zastąpi ten w tym momencie zmienany
    } @Override
    public String toString(){
        return "S";
    }

}