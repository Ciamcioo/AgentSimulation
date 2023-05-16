package AgendClasses;

public abstract class Agent implements AgentMethods {
    private int coordinateX;
    private int coordinateY;
    public Agent(){
        //....
    }
    @Override
    public void move(){
        //...
    }
    @Override
    public int getCoordinateX(){
        return this.coordinateX;
    }
    @Override
    public void setCoordinateX(int newValueForX){
        // musimy sprawdzić czy wartość taka X znajduje się w mapie jeśli tak to dokonujemy zmiany
    }

    @Override
    public int getCoordinateY(){
        return this.coordinateY;
    }
    @Override
    public void setCoordinateY(int newValueForY){
        // musimy sprawdzić czy wartość taka Y znajduje się w mapie jeśli tak to dokonujemy zmiany

    }
    @Override
    public void checkPosition(){
        // tutaj może stworzymy klase która będzie transferować pozycje poszczególnych agentów i będzie to pole klasy abstrakcyjnej agent
    }



}
