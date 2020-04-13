package proiectOpera.model;
import java.sql.Date;

public class Actori {
    private int id_actor;
    private String nume;
    private String prenume;
    private Date data_nasterii;
    private Date data_angajarii;
    private String tip_actor;
    private String titlu_piesa;

    public Actori() {
    }

    public Actori(int id_actor, String nume, String prenume, Date data_nasterii, Date data_angajarii, String tip_actor, String titlu_piesa) {
        this.id_actor=id_actor;
        this.nume=nume;
        this.prenume = prenume;
        this.data_nasterii= data_nasterii;
        this.data_angajarii=data_angajarii;
        this.tip_actor= tip_actor;
        this.titlu_piesa= titlu_piesa;
    }

    public int getId_actor() {
        return id_actor;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }


    public String getTip_actor() {
        return tip_actor;
    }

    public String getTitlu_piesa() {
        return titlu_piesa;
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public Date getData_angajarii() {
        return data_angajarii;
    }

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }


    public void setTip_actor(String tip_actor) {
        this.tip_actor = tip_actor;
    }

    public void setTitlu_piesa(String titlu_piesa) {
        this.titlu_piesa = titlu_piesa;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public void setData_angajarii(Date data_angajarii) {
        this.data_angajarii = data_angajarii;
    }
}
