package proiectOpera.model;

public class Aparitie {
    int id_obiect_vestimentar;
    int id_actor;

    public Aparitie() {}

    public Aparitie(int id_obiect_vestimentar, int id_actor) {
        this.id_obiect_vestimentar = id_obiect_vestimentar;
        this.id_actor = id_actor;
    }

    public int getId_obiect_vestimentar() {
        return id_obiect_vestimentar;
    }

    public void setId_obiect_vestimentar(int id_obiect_vestimentar) {
        this.id_obiect_vestimentar = id_obiect_vestimentar;
    }

    public int getId_actor() {
        return id_actor;
    }

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }
}
