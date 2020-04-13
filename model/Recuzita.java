package proiectOpera.model;

public class Recuzita {
    private int id_recuzita;
    private String denumire;
    private String culoare;
    private float greutate;
    private float inaltime;

    public Recuzita() {}

    public Recuzita(int id_recuzita, String denumire, String culoare, float greutate, float inaltime) {
        this.id_recuzita = id_recuzita;
        this.denumire = denumire;
        this.culoare = culoare;
        this.greutate = greutate;
        this.inaltime = inaltime;
    }

    public int getId_recuzita() {
        return id_recuzita;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getCuloare() {
        return culoare;
    }

    public float getGreutate() {
        return greutate;
    }

    public float getInaltime() {
        return inaltime;
    }

    public void setId_recuzita(int id_recuzita) {
        this.id_recuzita = id_recuzita;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public void setGreutate(float greutate) {
        this.greutate = greutate;
    }

    public void setInaltime(float inaltime) {
        this.inaltime = inaltime;
    }
}
