package registros;

public class conductor {
    private int id;
    private String nombreCompleto;

    public conductor(int id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nombreCompleto; 
    }
}