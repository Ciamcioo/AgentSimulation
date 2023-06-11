package Map;

import AgentClasses.Agent;
public interface MapMethods {
    // Metoda zwraca mape symulacji w postaci tablicy dwuwymiarowej
    ObjectOfMap[][] getArrayOfObjects();
    // Metoda przypisuje prawidłową tablice dwuwymiarową odpowiadająca mapie symulacji
    void setArrayOfObjects(ObjectOfMap[][] arrayOfObjects);
    // Metod zwraca referencje do pojedyńczy obiekty z mapy symulajic
    ObjectOfMap getOneObjectOfMap(int coordinateX, int coordinateY); // Metod zwraca pojedyńczy obiekty z mapy (tablicy dwuwymiarowej)
    // Metoda przypisuje prawidłowy obiekty do mapy symualcji
    void setOneObjectOfMap(int coordinateX, int coordinateY, ObjectOfMap newAgent);
    // Metoda zwraca liczbe zmienionych obiektów w czaise iteracji
    int getChangedObjects();
    // Metoda przypisuje prawidłową wartośc określająca liczbe zmienioncyh obiektów w tej iteracji
    void setChangedObjects(int changedObjects);
    // Metoda wywołuje wykonanie inicjalizacji obu typów agentów na mapie
    void agentInitializationOnMap();
    // Metoda inicjalizuje mape obiektów typu puste pole
    ObjectOfMap[][] emptyMapInitialization();
    // Metoda inicjalizuje określoną liczbe zdrowych agentów na początku symulacji
    ObjectOfMap[][] initializationOfHealthyAgents();
    // Metoda inicjalizuje określoną liczbe chorych agentów na początku symulacji
    ObjectOfMap[][] initializationOfSickAgents();
    // Metoda wywołuje inicjalizacje pakietów szczepionki oraz izolacji na mapie
    void packageInitialization();
    // Metoda inicjalizuje pakiety szczepionki na mapie symulacji
    void vaccineKitInitialization();
    // Metoda inicjalizuje pakiety izolacji na mapie symulacji
    void isolationInitialization();
    // Metoda sterujaca odpowiedzialna za wywolanie wszystkich zachowan dla poszczególnych typu obiektó
    void agentControlMethod();
    // Metoda zamienia pozycje obkektu symulacji na mapie na określną przez argumenty metody
    void changePositionOfAgent(Agent agent,int X,int Y);
    // Metoda odpowiedzialna za wypisywanie struktury mapy w konsoli
    void printMap();
    // Metoda niszczy pakiety te pakiety, które na mapie symulacji zostały oznaczone jako puste
    void packageDestruction();
    // Metoda odpowiedzialna za ustawienia pola obiektu mapy, która informuje o wykonaniu ruchu w tej iteracji na false
    void settingValueOfMoveIterationToFalse();


}
