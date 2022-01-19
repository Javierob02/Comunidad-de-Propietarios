import java.util.*;

public class Propietario {
    private String nombre;
    private List<Finca> fincas;

    public Propietario(String nombre){
        this.nombre = nombre;
        this.fincas = new ArrayList<Finca>(0);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void addFinca(Finca finca) {
        this.fincas.add(finca);
    }

    public void removeFinca(String nombre) {
        for (int i = 0; i < this.fincas.size(); i++) {
            if (this.fincas.get(i).getNombre().equals(nombre)) {
                this.fincas.remove(i);
            }
        }
    }

    public List<Finca> getFincas(){
        return this.fincas;
    }

    public double cuotaTotal() {
        double result = 0.0;
        if (this.fincas.size() == 0) {
            result = 0.0;
        } else{
            for (Finca f : this.fincas) {
                result += f.getCuota();
            }
        }
        return  result;
    }

    public String toString() {
        String result = "";
        if (this.fincas.size() > 0) {
            for (int i = 0; i < this.fincas.size()-1; i++){
                Finca finca = this.fincas.get(i);
                result += i+1 + ") Nombre: " + finca.getNombre() + " tipo: " + finca.getTipo() + " couta: " + finca.getCuota() + "\n";
            }
            //Sin "\n"
            Finca finca = this.fincas.get(this.fincas.size()-1);
            result += this.fincas.size()-1+1 + ") Nombre: " + finca.getNombre() + " tipo: " + finca.getTipo() + " couta: " + finca.getCuota();
        }

        return result;
    }


}