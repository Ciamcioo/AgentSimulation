package Core;

import Map.Map;

public interface DataOfSimulationMethods {
    // Metoda zwraca wartość int określając wielkość mapy symulacji
    int getSize();
    // Metoda przypisuje poprawną wartość int do zmiennej typu size będącą zmienna obiektu typu DataOfSimulation
    void setSize(int size);
    // Metoda zwraca wartośc int określająca ilość iteracji jaką ma wykonać symulacja
    int getNumberOfIterations();
    // Metoda przypisuje prawidłową wartość określająca ilość iteracji jaka ma zostać wyskonana przez symulacje
    void setNumberOfIterations(int numberOfIterations);
    // Metoda zwraca wartośc int określająca ilość zdrowych agentów w symlulacji
    int getNumberOfHealthyAgents();
    // Metoda przypisuje prawidłową wartość określającą ilość zdrowych agentów w symulacji
    void setNumberOfHealthyAgents(int numberOfHealthyAgents);
    // Metoda zwraca wartośc int określająca ilość chorych agentów w symulacji
    int getNumberOfSickAgents();
    // Metoda przypisuje prawidłowa wartość określająca ilość chorych agentów w symulacji
    void setNumberOfSickAgents(int numberOfSickAgents);
    // Metoda zwraca minimalną ilośc dni trwania choroby agenta
    int getMinDayTillEndOfIllness();
    // Metoda przypisuje prawidlową wartość minimalnej ilości dni czasu trwania choroby agenta
    void setMinDayTillEndOfIllness(int minDayTillEndOfIllness);
    // Metoda zwraca maksymalna ilosc dni choroby agenta w symulacji
    int getMaxDayTillEndOfIllness();
    // Metoda przypisuje prawidlową wartość określająca maksymalną ilość dni czasu trwania choroby agenta w symulacji
    void setMaxDayTillEndOfIllness(int maxDayTillEndOfIllness);
    // Metoda zwraca wartość z zakresu 0.0 - 1.0 określająca procentową szanse na śmierć chorego agenta
    double getChanceOfSickAgentDeath();
    // Metoda przypisuje prawidłową wartość z zakresu 0.0 - 1.0 okreslającą szanse procentową na śmierć chorego agenta
    void setChanceOfSickAgentDeath(double chanceOfSickAgentDeath);
    // Metoda zwraca wartosć int określająca ilosć pakietów szczepionki w symulacji
    int getNumberOfVaccineKit();
    // Metoda przypisuje prawidłową wartość określająca ilość pakietów szczepionki w symulacji
    void setNumberOfVaccineKit(int numberOfVaccineKit);
    // Metoda zwraca szanse pojawienia się pakietu szczepionki w symulacji w postaci liczby double
    double getChanceOfSpawnVaccine();
    // Metoda przypisuje prawidłową wartość okreslająca szanse pojawienia się pakietu szczepionki w symulacji w postaci liczyb double
    void setChanceOfSpawnVaccine(double chanceOfSpawnVaccine);
    // Metoda zwraca ilość ładónków szczepionki w jednym pakiecie pojawiającym się na mapie symulajci
    int getNumberOfVaccineInKit();
    // Metoda przypisuje prawidłową wartosc ilości ładunków możliwych znajdujących się w jednym pakiecie szczepionki (od 1 do 5 ładunków)
    void setNumberOfVaccineInKit(int numberOfVaccineInKit);
    // Metoda zwraca wartość int określająca ilość pakietów izolacji w symulacji
    int getNumberOfIsolation();
    // Metoda przypisuje prawidłową wartość odpowiadająca iloości pakietów izolacji w symulacji
    void setNumberOfIsolation(int numberOfIsolation);
    // Metoda zwraca szanse pojawienia się pakietu izolacji w symulacji w postaci liczyb double
    double getChanceOfSpawnIsolation();
    // Metoda przypisuje szanse pojawienia się pakietu izolacji w symulacji w postaci liczby double
    void setChanceOfSpawnIsolation(double chanceOfSpawnIsolation);
    // Metoda aktualizuje dane dotyczące symulacji
    void updateData(Map map);
    // Metoda wyświetla dane na etmat symulacji na ekranie
    void displayData(Map map);

}
