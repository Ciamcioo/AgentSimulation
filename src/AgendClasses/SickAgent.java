package AgendClasses;

public class SickAgent extends Agent{
    private int dayTillEndOfIllness;
    private double chanceOfDeath;
    public SickAgent(){
        super();
        
    }
    public int getDayTillEndOfIllness(){
        return this.dayTillEndOfIllness;
    }
    public void setDayTillEndOfIllness(int dayOfIllness){
        // TODO dopisać kontrole błędów przed wprowadzaniem złej watości
        this.dayTillEndOfIllness = dayOfIllness;
    }
    public double getChanceOfDeath(){
        return this.chanceOfDeath;
    }
    public void setChanceOfDeath(double chanceOfDeath){
        // TODO dopisać kontrole błędów przed wprowadzeniem złej wartości
        this.chanceOfDeath = chanceOfDeath;
    }
    @Override
    public void chengingStatusOfAgent(Agent agent){
        // TODO zmiana statusu obiektu poprzez tworzenie nowego obiektu, który zastąpi ten w tym momencie zmienany
    }

}