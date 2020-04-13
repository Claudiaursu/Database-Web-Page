package proiectOpera.model;
import java.sql.Date;

public class Actori_1980 {
    int id_actor;
    String nume;
    String prenume;
    String titlu_piesa;
    Date data_nasterii;
    Date data_angajarii;
    String tip_actor;

    public Actori_1980() {
    }

    public Actori_1980(int id_actor, String nume, String prenume, String titlu_piesa, Date data_nasterii, Date data_angajarii, String tip_actor) {
        this.id_actor = id_actor;
        this.nume = nume;
        this.prenume = prenume;
        this.titlu_piesa = titlu_piesa;
        this.data_nasterii = data_nasterii;
        this.data_angajarii = data_angajarii;
        this.tip_actor = tip_actor;
    }

    public int getId_actor() {
        return id_actor;
    }

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
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

    public String getTitlu_piesa() {
        return titlu_piesa;
    }

    public void setTitlu_piesa(String titlu_piesa) {
        this.titlu_piesa = titlu_piesa;
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public Date getData_angajarii() {
        return data_angajarii;
    }

    public void setData_angajarii(Date data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public String getTip_actor() {
        return tip_actor;
    }

    public void setTip_actor(String tip_actor) {
        this.tip_actor = tip_actor;
    }
}
