package Map;

import AgendClasses.Agent;
import Core.ObjectOfMap;
import Package.Package;

public interface MapMethods {
    ObjectOfMap[][] getArrayOfObjects();    // Metoda zwraca mape w postaci tablicy dwuwymiarowej
    ObjectOfMap[][] agentInitializationAndMap(int numberOfHealthyAgents, int numberOfSickAgents); // Metoda inicjalizuje mape w postaci tablicy dwuwymiarowerj oraz podstawową liczbe agentów na mapie
    void printMap(); // Metoda odpowiedzialna za wypisywanie struktury mapy w konsoli
    int getSize(); // Metoda zwraca wielkość mapy
    boolean checkField(int coordinateX, int coordinateY, Class<?> searchType);
    void changePositionOfAgent(Agent agent,int X,int Y); // Metoda zamienia pozycje agenta dla którego została wywołana
    void packageInitialization(Package kit); // Metoda inicjalizuje pojawienie się pakietu w tablicy dwuwymiarowej odpowiadającej mapie dla nowo stworzonego obiektu typu Package
    ObjectOfMap getOneObjectOfMap(int coordinateX, int coordinateY); // Metod zwraca pojedyńczy obiekty z mapy (tablicy dwuwymiarowej)
    void swapAgent(int coordinateX, int coordinateY, ObjectOfMap newAgent);
}
