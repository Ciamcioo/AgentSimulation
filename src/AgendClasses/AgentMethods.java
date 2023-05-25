package AgendClasses;

public interface AgentMethods {
    void move(Agent agent);
    /*   void
        getPosition();
        void setPosition();

        Nie mam pewności co do użyteczności tych funkcji oraz czy jeśli są w ogóle użyteczne czy nie stworzyć dla nich klasy
        z odzielnym interfejsem
     */
//    int  getCoordinateX();
//    int getCoordinateY();
//    void setCoordinateX(int newValueForX);
//    void setCoordinateY(int newValueForY);
    void checkPosition(int X, int Y);
    void chengingStatusOfAgent(Agent agent);
}

