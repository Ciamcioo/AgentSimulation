package Package;
import Map.Map;
import Map.ObjectOfMap;

/**
 * Abstrakcyjna klasa "pakietu"
 */
public abstract class Package extends ObjectOfMap implements PackageMethods {
    private boolean isEmpty;

    /**
     * Konstruktor klasy <code>Package</code>
     * @param coordinateX współrzędna X pakietu
     * @param coordinateY współrzędna Y pakietu
     * @param mapPartOf mapa na której znajduje się pakiet
     */
    public Package(int coordinateX,int coordinateY, Map mapPartOf) {
        super(coordinateX, coordinateY, mapPartOf);
        this.isEmpty = false;
    }

    /**
     * Zwraca informację czy pakiet jest pusty
     * @return <code>true</code> jeśli pusty
     */
    public boolean isEmpty() {
        return isEmpty;
    }

    /**
     * Przypisuje wartość <code>true</code> gdy pakiet jest pusty
     */
    public void setEmpty(){ // Metoda ustawia wartość pola isEmpty na true
        this.isEmpty = true;
    }

    /**
     * Szukanie
     */
    public void searching() {
        try {
            throw new Exception("Error this object cannot search");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
