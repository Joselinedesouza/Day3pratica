package Esercizio1;

public class Rettangolo {
    public static void main(String[] args) {
        Rettangolo retta1= new Rettangolo(6,3);
        Rettangolo retta2= new Rettangolo(8,4);

        stampaRettangolo(retta1);
        System.out.println();
        stampaDueRettangoli(retta1, retta2);
    }
    //Attributi per l'incapsulamento
    private final double altezza;
    private final double larghezza;

    //Costruttore
    public Rettangolo(double altezza, double larghezza){
        this.altezza=altezza;
        this.larghezza= larghezza;
    }
    //Calcolo l'area
    public double calcoloArea(){
        return altezza*larghezza;
    }
    //Calcolo perimetro
    public double calcoPerimetro(){
        return 2 * (altezza + larghezza);
    }
    //Metodo statico per stampare l'are e il perimetro di un solo rettangolo
        public static void stampaRettangolo(Rettangolo r1){
            System.out.println("Area: " + r1.calcoloArea());
            System.out.println("Perimetro: " + r1.calcoPerimetro());
        }
        //Metodo statico per stampare due rettangoli e la somma delle aree e
        // i perimetri di entrambi
    public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2){
        System.out.println("Rettangolo1: ");
        stampaRettangolo(r1);
        System.out.println("Rettangolo2: ");
        stampaRettangolo(r2);
        double sommaAree = r1.calcoloArea() + r2.calcoloArea();
        double sommaPerimetri = r1.calcoPerimetro() + r2.calcoPerimetro();

        System.out.println("Somma tot delle aree: " + sommaAree);
        System.out.println("Somma tot dei perimetri: " + sommaPerimetri);
    }

    }
