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
        this.dayTillEndOfIllness = dayOfIllness;        //+ dopisać kontrole błedów przed wprowadzeniem zlej wartości
    }
    public double getChanceOfDeath(){
        return this.chanceOfDeath;
    }
    public void setChanceOfDeath(double chanceOfDeath){
        this.chanceOfDeath = chanceOfDeath;             //+ dopisać kontrole błędów przed wprowadzeniem złej wartości
    }
    @Override
    public void chengingStatusOfAgent(Agent agent){
        // zmiana statusu obiektu poprzez tworzenie nowego obiektu, który zastąpi ten w tym momencie zmieniany
    }

}