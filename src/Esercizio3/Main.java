package Esercizio3;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe Articolo
class Articolo {
    String codiceArticolo;
    String descrizione;
    double prezzo;
    int pezziDisponibili;

    public Articolo(String codiceArticolo, String descrizione, double prezzo, int pezziDisponibili) {
        this.codiceArticolo = codiceArticolo;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.pezziDisponibili = pezziDisponibili;
    }
}

// Classe Cliente
class Cliente {
    String codiceCliente;
    String nomeCognome;
    String email;
    Date dataIscrizione;

    public Cliente(String codiceCliente, String nomeCognome, String email, Date dataIscrizione) {
        this.codiceCliente = codiceCliente;
        this.nomeCognome = nomeCognome;
        this.email = email;
        this.dataIscrizione = dataIscrizione;
    }
}

// Classe Carrello
class Carrello {
    Cliente clienteAssociato;
    List<Articolo> articoliNelCarrello;

    public Carrello(Cliente clienteAssociato) {
        this.clienteAssociato = clienteAssociato;
        this.articoliNelCarrello = new ArrayList<>();
    }

    public void aggiungiArticolo(Articolo articolo) {
        if (articolo.pezziDisponibili > 0) {
            articoliNelCarrello.add(articolo);
            articolo.pezziDisponibili--;  // Decrementa il pezzo in magazzino
            System.out.println("Articolo aggiunto: " + articolo.descrizione);
        } else {
            System.out.println("Articolo non disponibile: " + articolo.descrizione);
        }
    }

    public double calcolaTotale() {
        double totale = 0;
        for (Articolo a : articoliNelCarrello) {
            totale += a.prezzo;
        }
        return totale;
    }

    public void mostraCarrello() {
        System.out.println("Carrello di " + clienteAssociato.nomeCognome);
        for (Articolo a : articoliNelCarrello) {
            System.out.println("- " + a.descrizione + " | Prezzo: " + a.prezzo);
        }
        System.out.println("Totale: " + calcolaTotale());
    }
}

// Main per testare
public class Main {
    public static void main(String[] args) {
        // Creo articoli
        Articolo articolo1 = new Articolo("A001", "Mouse Wireless", 25.99, 10);
        Articolo articolo2 = new Articolo("A002", "Tastiera Meccanica", 89.99, 5);

        // Creo cliente
        Cliente cliente1 = new Cliente("C001", "Mario Rossi", "mario.rossi@example.com", new Date());

        // Creo carrello
        Carrello carrello1 = new Carrello(cliente1);

        // Aggiungo articoli
        carrello1.aggiungiArticolo(articolo1);
        carrello1.aggiungiArticolo(articolo2);

        // Mostro il carrello
        carrello1.mostraCarrello();
    }
}

