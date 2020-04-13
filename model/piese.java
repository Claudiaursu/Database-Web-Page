package proiectOpera.model;

public class piese {
    private String titlu_piesa;
    private String gen_piesa;
    private int nr_reprez_luna;
    private int pret_bilet;
    private int id_regizor;
    private String nume;
    private String prenume;
    private int nr_pauze;

    public piese() {
    }

    public piese(String titlu_piesa,String gen_piesa, int nr_reprez_luna, int pret_bilet, int id_regizor, int nr_pauze) {
        this.titlu_piesa=titlu_piesa;
        this.gen_piesa = gen_piesa;
        this.nr_reprez_luna = nr_reprez_luna;
        this.pret_bilet= pret_bilet;
        this.id_regizor= id_regizor;
        this.nr_pauze= nr_pauze;
    }

    public void setTitlu_piesa(String titlu_piesa) {
        this.titlu_piesa = titlu_piesa;
    }

    public void setGen_piesa(String gen_piesa) {
        this.gen_piesa = gen_piesa;
    }

    public void setNr_reprez_luna(int nr_reprez_luna) {
        this.nr_reprez_luna = nr_reprez_luna;
    }

    public void setPret_bilet(int pret_bilet) {
        this.pret_bilet = pret_bilet;
    }

    public void setId_regizor(int id_regizor) {
        this.id_regizor = id_regizor;
    }

    public void setNr_pauze(int nr_pauze) {
        this.nr_pauze = nr_pauze;
    }

    public String getTitlu_piesa() {
        return titlu_piesa;
    }

    public String getGen_piesa() {
        return gen_piesa;
    }

    public int getNr_reprez_luna() {
        return nr_reprez_luna;
    }

    public int getPret_bilet() {
        return pret_bilet;
    }

    public int getId_regizor() {
        return id_regizor;
    }

    public int getNr_pauze() {
        return nr_pauze;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
}

