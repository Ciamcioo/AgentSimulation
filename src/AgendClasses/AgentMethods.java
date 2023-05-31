package AgendClasses;

import Core.ObjectOfMap;
import Map.Map;
public interface AgentMethods {
    void move();    // Metoda odpowiadajaca za ruch agenta w jednym z osmiu kierunków jeżeli jest to możliwe
    void chengingStatusOfAgent(); // Metoda odpowiadająca za zmianę typu agenta w odpowiednich warunkach
}

