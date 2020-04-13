package proiectOpera.model;

public class Piese_alb {
    int numar_actori;
    String titlu_piesa;
    int nr_recuzite_albe;

    public Piese_alb() {}

    public Piese_alb(int numar_actori, String titlu_piesa, int nr_recuzite_albe) {
        this.numar_actori = numar_actori;
        this.titlu_piesa = titlu_piesa;
        this.nr_recuzite_albe=nr_recuzite_albe;
    }

    public int getNumar_actori() {
        return numar_actori;
    }

    public void setNumar_actori(int numar_actori) {
        this.numar_actori = numar_actori;
    }

    public String getTitlu_piesa() {
        return titlu_piesa;
    }

    public void setTitlu_piesa(String titlu_piesa) {
        this.titlu_piesa = titlu_piesa;
    }

    public int getNr_recuzite_albe() {
        return nr_recuzite_albe;
    }

    public void setNr_recuzite_albe(int nr_recuzite_albe) {
        this.nr_recuzite_albe = nr_recuzite_albe;
    }
}
