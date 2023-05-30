package AgendClasses;
import Map.Map;

import java.util.Random;

public class SickAgent extends Agent{
    private int dayTillEndOfIllness;
    private double chanceOfDeath;
    public SickAgent(int coordinateX, int coordinateY, Map partMapOf, int dayTillEndOfIllness, double chanceOfDeath){ // Konstruktor SickAgent, który wywołuje konstruktor Agent
        super(coordinateX, coordinateY, partMapOf);
        this.chanceOfDeath = chanceOfDeath;
        this.dayTillEndOfIllness = dayTillEndOfIllness;
    }
    public int getDayTillEndOfIllness(){    // Zwraca liczbe dni do końca zarażenia chorego agenta
        return this.dayTillEndOfIllness;
    }
    public void setDayTillEndOfIllness(int dayTillEndOfIllness){    // Ustawia wartość liczby dni po jakich minie choroba
        if(dayTillEndOfIllness > 0)
            this.dayTillEndOfIllness = dayTillEndOfIllness ;
    }
    public double getChanceOfDeath(){ // Zwraca procentową szanse śmierci agenta
        return this.chanceOfDeath;
    }
    public void setChanceOfDeath(double chanceOfDeath){ // Ustawia procentową szanse śmierci agenta
        if(chanceOfDeath > 0 && chanceOfDeath < 1)
         this.chanceOfDeath = chanceOfDeath;
    }


    @Override
    public void chengingStatusOfAgent(Agent agent){
        // TODO zmiana statusu obiektu typu SickAgent poprzez tworzenie nowego obiektu, który zastąpi ten w tym momencie zmienany
    } @Override
    public String toString(){ // Reprezentacja agenta w konsoli
        return "S";
    }

}