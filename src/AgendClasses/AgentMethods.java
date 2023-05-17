package AgendClasses;

public interface AgentMethods {
    void move();
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
    void checkPosition();
    void chengingStatusOfAgent(Agent agent);
}

