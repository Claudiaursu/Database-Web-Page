package proiectOpera.model;
public class Acte {
    private int id_act;
    private int durata;
    private String titlu_piesa;

    public Acte() {
    }

    public Acte(int id_act, int durata, String titlu_piesa) {
        this.id_act = id_act;
        this.durata = durata;
        this.titlu_piesa = titlu_piesa;
    }

    public int getId_act() {
        return id_act;
    }

    public int getDurata() {
        return durata;
    }

    public String getTitlu_piesa() {
        return titlu_piesa;
    }

    public void setId_act(int id_act) {
        this.id_act = id_act;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public void setTitlu_piesa(String titlu_piesa) {
        this.titlu_piesa = titlu_piesa;
    }
}
