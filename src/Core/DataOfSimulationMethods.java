package Core;

import Map.Map;

/**
 * Interfejs metod danych symulacji
 */
public interface DataOfSimulationMethods {
    /**
     * Zwraca wartość int określającą wielkość mapy symulacji
     * @return rozmiar
     */
    int getSize();
    /**
     * Przypisuje poprawną wartość int do zmiennej <code>size</code> będącą zmienną obiektu typu <code>DataOfSimulation</code>
     * @param size rozmiar
     */
    void setSize(int size);
    /**
     * Zwraca wartość int określającą liczbę iteracji jaką ma wykonać symulacja
     * @return liczba iteracji
     */
    int getNumberOfIterations();
    /**
     * Przypisuje prawidłową wartość określającą liczbę iteracji jaka ma zostać wykonana przez symulację
     * @param numberOfIterations liczba iteracji
     */
    void setNumberOfIterations(int numberOfIterations);
    /**
     * Zwraca wartość int określającą liczbę zaszczepionych agentów w symulacji
     * @return liczba zaszczepionych
     */
    int getNumberOfVaccinated();
    /**
     * Przypisuje prawidłową wartość int określającą liczbę zaszczepionych agentów w symulacji
     * @param numberOfVaccinated liczba zaszczepionych
     */
    void setNumberOfVaccinated(int numberOfVaccinated);
    /**
     * Zwraca wartość int określającą liczbę agentów po chorobie w symulacji
     * @return liczba agentów po chorobie
     */
    int getNumberOfAfterIllness();
    /**
     * Przypisuje prawidłową wartość int określającą liczbę agentów po chorobie w symulacji
     * @param numberOfAfterIllness liczba agentów po chorobie
     */
    void setNumberOfAfterIllness(int numberOfAfterIllness);
    /**
     * Zwraca wartość int określającą liczbę zdrowych agentów w symulacji
     * @return liczba zdrowych
     */
    int getNumberOfHealthyAgents();
    /**
     * Przypisuje prawidłową wartość określającą liczbę zdrowych agentów w symulacji
     * @param numberOfHealthyAgents liczba zdrowych
     */
    void setNumberOfHealthyAgents(int numberOfHealthyAgents);
    /**
     * Zwraca wartość int określającą ilość chorych agentów w symulacji
     * @return liczba chorych
     */
    int getNumberOfSickAgents();
    /**
     * Przypisuje prawidłową wartość określającą liczbę chorych agentów w symulacji
     * @param numberOfSickAgents liczba chorych
     */
    void setNumberOfSickAgents(int numberOfSickAgents);
    /**
     * Zwraca minimalną liczbę dni trwania choroby agenta
     * @return minimum dni choroby
     */
    int getMinDayTillEndOfIllness();
    /**
     * Przypisuje prawidłową wartość minimalnej liczby dni czasu trwania choroby agenta
     * @param minDayTillEndOfIllness minimum dni choroby
     */
    void setMinDayTillEndOfIllness(int minDayTillEndOfIllness);
    /**
     * Zwraca maksymalną liczbę dni choroby agenta w symulacji
     * @return maximum dni choroby
     */
    int getMaxDayTillEndOfIllness();
    /**
     * Przypisuje prawidłową wartość określającą maksymalną liczbę dni czasu trwania choroby agenta w symulacji
     * @param maxDayTillEndOfIllness maximum dni choroby
     */
    void setMaxDayTillEndOfIllness(int maxDayTillEndOfIllness);
    /**
     * Zwraca wartość z zakresu 0.0 - 1.0 określającą procentową szansę na śmierć chorego agenta
     * @return szansa na śmierć chorego
     */
    double getChanceOfSickAgentDeath();
    /**
     * Przypisuje prawidłową wartość z zakresu 0.0 - 1.0 określającą szansę procentową na śmierć chorego agenta
     * @param chanceOfSickAgentDeath szansa na śmierć chorego
     */
    void setChanceOfSickAgentDeath(double chanceOfSickAgentDeath);
    /**
     * Zwraca wartość int określającą liczbę pakietów szczepionki w symulacji
     * @return liczba pakietów szczepionek
     */
    int getNumberOfVaccineKit();
    /**
     * Przypisuje prawidłową wartość określająca liczbę pakietów szczepionki w symulacji
     * @param numberOfVaccineKit liczba pakietów szczepionek
     */
    void setNumberOfVaccineKit(int numberOfVaccineKit);
    /**
     * Zwraca szanse pojawienia się pakietu szczepionki w symulacji w postaci liczby double
     * @return szansa na pojawienie się szczepionki
     */
    double getChanceOfSpawnVaccine();
    /**
     * Przypisuje prawidłową wartość określającą szanse pojawienia się pakietu szczepionki w symulacji w postaci liczby double
     * @param chanceOfSpawnVaccine szansa na pojawienie się szczepionki
     */
    void setChanceOfSpawnVaccine(double chanceOfSpawnVaccine);
    /**
     * Zwraca ilość ładunków szczepionki w jednym pakiecie pojawiającym się na mapie symulacji
     * @return liczba szczepionek w pakiecie
     */
    int getNumberOfVaccineInKit();
    /**
     * Przypisuje prawidłową wartość liczby ładunków możliwych znajdujących się w jednym pakiecie szczepionki (od 1 do 5 ładunków)
     * @param vaccineInKit liczba szczepionek w pakiecie
     */
    void setNumberOfVaccineInKit(int vaccineInKit);
    /**
     * Zwraca wartość int określającą liczbę pakietów izolacji w symulacji
     * @return liczba izolacji
     */
    int getNumberOfIsolation();
    /**
     * Przypisuje prawidłową wartość odpowiadającą liczbie pakietów izolacji w symulacji
     * @param numberOfIsolation liczba izolacji
     */
    void setNumberOfIsolation(int numberOfIsolation);
    /**
     * Zwraca szanse pojawienia się pakietu izolacji w symulacji w postaci liczyb double
     * @return szansa na pojawienie się symulacji
     */
    double getChanceOfSpawnIsolation();
    /**
     * Przypisuje szanse pojawienia się pakietu izolacji w symulacji w postaci liczby double
     * @param chanceOfSpawnIsolation szansa na pojawienie się symulacji
     */
    void setChanceOfSpawnIsolation(double chanceOfSpawnIsolation);
    /**
     * Aktualizuje dane symulacji (ilości poszczególnych obiektów na mapie)
     * @param map mapa symulacji
     */
    void updateData(Map map);
    /**
     * Wyświetla dane symulacji (ilości poszczególnych obiektów na mapie)
     * @param map mapa symulacji
     */
    void displayData(Map map);
}
