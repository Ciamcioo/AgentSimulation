package Core;
import Map.Map;

import static java.lang.Math.abs;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {
        DataOfSimulation dataOfSimulation = new DataOfSimulation();
        Map mapOfSimulation = new Map(dataOfSimulation.getSize(), dataOfSimulation.getNumberOfHealthyAgents(), dataOfSimulation.getNumberOfSickAgents());

        mapOfSimulation.printMap();
        System.out.println();

        while (dataOfSimulation.getNumberOfIterations() > 0) {
            mapOfSimulation.packageSpawn();
            // TODO packageSpawn jeszcze nie jest napisana trzeba dogadać czy będziemy zachowywali pakiety z poprzednich iteracji czy nie
            mapOfSimulation.agentControlMethod();
            mapOfSimulation.printMap();
            mapOfSimulation.packageDestruction();
            mapOfSimulation.settingValueOfMoveIterationToFalse();
            dataOfSimulation.setNumberOfIterations(dataOfSimulation.getNumberOfIterations() - 1);
            dataOfSimulation.updateData(mapOfSimulation);
            dataOfSimulation.displayData(mapOfSimulation);

            // TODO Aby ograniczyć zmienianie kodu trzeba napisać metode w klasie dataOfSimulation, która będzie przechodziła przez całą mapę i zbierała sobie dane ile jest
            //  obiektów po kolei po później będziemy to wyświetlać

            // TODO metoda odpowiedzialna za wyświetlanie danych symulacji, czyli liczba agentow poszczegolnych pól wolnych pól, może liczba ile agentów się zmieniła w tej
            //  rundzie i takie bajery, ale no wtedy trzeba żeby pojawiły się nowe pola w klasie dataOfSimulation, które będą za to odpowiadać i pododawac je do method zmiany
            //  statusu obiektu, no i oczywiście dopisać gettery i settery dla tych pół dodać je do intefesjów

            Thread.sleep(1000);
        }
        // TODO w każdym interfesie trzeba po krótce opisać co ta metoda robi żeby było ładnie i schludnie, pousuwać zbędne komentarze które gdzieś się pojawiają w tekscie,
        //  a jak mamy metody które nie są brane z interfesju tylko pojawiają się dopiero w klasie to nad nagłówkiem tej metody tak samo, krótki opis

        // TODO dopisać testy jednostkowe do klas, które ich nie mają. Przejżyjcie te testy i klasy, jeżli jakiaś nie ma testu to daje TODO że dopisać test do klasy i ja powoli
        //  je będe dopisywał


    }
}