package Esercizio2;

import java.util.ArrayList;

public class SIM {
    // Attributi privati
    private final String numeroTelefono;
    private final double creditoDisponibile;
    private final ArrayList<Chiamata> ultimeChiamate;

    // Costruttore
    public SIM(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
        this.creditoDisponibile = 0.1;
        this.ultimeChiamate = new ArrayList<>();
    }

    // Metodo per aggiungere una chiamata
    public void aggiungiChiamata(int durataMinuti, String numeroChiamato) {
        Chiamata nuovaChiamata = new Chiamata(durataMinuti, numeroChiamato);
        ultimeChiamate.add(nuovaChiamata);
        if (ultimeChiamate.size() > 5) {
            ultimeChiamate.remove(0); // Rimuove la più vecchia
        }
    }

    // Metodo per stampare i dati della SIM
    public void stampaDati() {
        System.out.println("Numero di telefono: " + numeroTelefono);
        System.out.println("Credito disponibile: €" + creditoDisponibile);
        System.out.println("Ultime chiamate effettuate:");
        for (Chiamata c : ultimeChiamate) {
            System.out.println("- Numero chiamato: " + c.numeroChiamato() + ", durata: " + c.durataMinuti() + " minuti");
        }
    }

    // Classe principale per testare
    public static void main(String[] args) {
        SIM mySIM = new SIM("517796872");
        mySIM.aggiungiChiamata(10, "321448812");
        mySIM.aggiungiChiamata(5, "321448812");
        mySIM.aggiungiChiamata(7, "321448812");
        mySIM.aggiungiChiamata(3, "321448812");
        mySIM.aggiungiChiamata(12, "321448812");
        mySIM.aggiungiChiamata(18, "321448812"); // questa farà scattare la rimozione della prima

        mySIM.stampaDati();
    }
}

// Record per rappresentare una chiamata
record Chiamata(int durataMinuti, String numeroChiamato) {
}
