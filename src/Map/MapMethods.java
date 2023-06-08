package Map;

import AgentClasses.Agent;
import Package.Package;

public interface MapMethods {
    ObjectOfMap[][] getArrayOfObjects();    // Metoda zwraca mape w postaci tablicy dwuwymiarowej
    void setArrayOfObjects(ObjectOfMap[][] arrayOfObjects);
    void printMap(); // Metoda odpowiedzialna za wypisywanie struktury mapy w konsoli
    int getSize(); // Metoda zwraca wielkość mapy
    void changePositionOfAgent(Agent agent,int X,int Y); // Metoda zamienia pozycje agenta dla którego została wywołana
    void packageInitialization(Package kit); // Metoda inicjalizuje pojawienie się pakietu w tablicy dwuwymiarowej odpowiadającej mapie dla nowo stworzonego obiektu typu Package
    ObjectOfMap getOneObjectOfMap(int coordinateX, int coordinateY); // Metod zwraca pojedyńczy obiekty z mapy (tablicy dwuwymiarowej)
    void setOneObjectOfMap(int coordinateX, int coordinateY, ObjectOfMap newAgent);
    void setSize(int size);
    int getSickAgents();
    void setSickAgents(int sickAgent);
    void setHealthyAgents(int healthyAgents);
    int getHealthyAgents();
    ObjectOfMap[][] emptyMapInitialization();
    void agentInitializationOnMap();

    ObjectOfMap[][] initializationOfSickAgents();

    ObjectOfMap[][] initializationOfHealthyAgents();
    void agentControlMethod();
    void packageSpawn();
    void packageDestruction();
    void settingValueOfMoveIterationToFalse();



}
