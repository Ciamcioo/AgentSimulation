package Map;

import AgentClasses.Agent;

/**
 * Interfejs metod mapy
 */
public interface MapMethods {
    /**
     * Zwraca mapę symulacji w postaci tablicy dwuwymiarowej
     * @return tablica dwuwymiarowa mapy symulacji
     */
    ObjectOfMap[][] getArrayOfObjects();

    /**
     * Przypisuje prawidłową tablice dwuwymiarową odpowiadającą mapie symulacji
     * @param arrayOfObjects tablica dwuwymiarowa odpowiadająca mapie symulacji
     */
    void setArrayOfObjects(ObjectOfMap[][] arrayOfObjects);

    /**
     * Zwraca pojedyńczy obiekt z tablicy mapy symulacji z podanych współrzędnych
     * @param coordinateX współrzędna X
     * @param coordinateY współrzędna Y
     * @return obiekt o danych współrzędnych
     */
    ObjectOfMap getOneObjectOfMap(int coordinateX, int coordinateY);

    /**
     * Przypisuje prawidłowy obiekt do danej współrzędnej w tablicy mapy symualcji
     * @param coordinateX współrzędna X
     * @param coordinateY współrzędna Y
     * @param newAgent nowy agent do przypisania
     */
    void setOneObjectOfMap(int coordinateX, int coordinateY, ObjectOfMap newAgent);

    /**
     * Zwraca liczbę zmienionych obiektów w czasie iteracji
     * @return liczba zmienionych obiektów
     */
    int getChangedObjects();

    /**
     * Przypisuje prawidłową wartość określającą liczbę zmienionych obiektów w tej iteracji
     * @param changedObjects liczba zmienionych obiektów
     */
    void setChangedObjects(int changedObjects);

    /**
     * Wywołuje wykonanie inicjalizacji zdrowych i chorych agentów na mapie
     */
    void agentInitializationOnMap();

    /**
     * Metoda inicjalizuje mape obiektów typu puste pole
     * @return tablica dwuwymiarowa mapy po inicjalizacji
     */
    ObjectOfMap[][] emptyMapInitialization();

    /**
     * Inicjalizuje określoną liczbę zdrowych agentów na początku symulacji
     * @return tablica dwuwymiarowa mapy po inicjalizacji
     */
    ObjectOfMap[][] initializationOfHealthyAgents();

    /**
     * Inicjalizuje określoną liczbe chorych agentów na początku symulacji
     * @return tablica dwuwymiarowa mapy po inicjalizacji
     */
    ObjectOfMap[][] initializationOfSickAgents();

    /**
     * Wywołuje inicjalizację pakietów szczepionki oraz izolacji na mapie
     */
    void packageInitialization();

    /**
     * Inicjalizuje pakiety szczepionki na mapie symulacji
     */
    void vaccineKitInitialization();

    /**
     * Inicjalizuje pakiety izolacji na mapie symulacji
     */
    void isolationInitialization();

    /**
     * Metoda sterująca odpowiedzialna za wywołanie wszystkich zachowań dla poszczególnych typów obiektów
     */
    void agentControlMethod();

    /**
     * Zmienia pozycję obkektu symulacji na mapie na określną przez argumenty
     * @param agent agent do zmienienia pozycji
     * @param newX współrzędna X na którą ma przejść agent
     * @param newY współrzędna Y na którą ma przejść agent
     */
    void changePositionOfAgent(Agent agent, int newX, int newY);

    /**
     * Metoda odpowiedzialna za wypisywanie struktury mapy w konsoli
     */
    void printMap();

    /**
     * Metoda niszczy pakiety te pakiety, które na mapie symulacji zostały oznaczone jako puste
     */
    void packageDestruction();

    /**
     * Metoda odpowiedzialna za ustawienia pola obiektu mapy, która informuje o wykonaniu ruchu w tej iteracji na false (boolean <code>iterationMove</code>)
     */
    void settingValueOfMoveIterationToFalse();
}
