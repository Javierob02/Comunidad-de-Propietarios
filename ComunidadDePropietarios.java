import java.util.*;

public class ComunidadDePropietarios {
    private String nombre;
    private double presupuesto_anual;
    public List<Propietario> propietarios;

    public ComunidadDePropietarios(String nombre, double presupuesto_anual) {
        this.nombre = nombre;
        this.presupuesto_anual = presupuesto_anual;
        this.propietarios = new ArrayList<Propietario>(0);
    }

    public void addPropietario(Propietario propietario) {
        if (this.propietarios.size() == 0) {
            this.propietarios.add(propietario);
        } else {
            boolean found = false;
            for (int i = 0; i < this.propietarios.size(); i++) {
                if (propietario.getNombre().equals(this.propietarios.get(i).getNombre())) {
                    this.propietarios.remove(i);
                    this.propietarios.add(propietario);
                    found = true;
                }
            }
            if (!found) {
                this.propietarios.add(propietario);
            }
        }
    }

    public void removePropietario(String nombre) {
        for (int i = 0; i < this.propietarios.size(); i++) {
            if (this.propietarios.get(i).getNombre().equals(nombre)) {
                this.propietarios.remove(i);
            }
        }
    }

    public double cuotaMensual(Propietario propietario) {
        return ((propietario.cuotaTotal() + this.presupuesto_anual)/100)/12;
    }

    public Propietario getPropietario(String nombre) {
        for (int i = 0; i < this.propietarios.size(); i++) {
            if (this.propietarios.get(i).getNombre().equals(nombre)) {
                return this.propietarios.get(i);
            }
        }
        return null;
    }

    public List<String> getFincasDistintas() {      //<tipo>: <numero>  -> g, l, t, v
        List<Finca> todas_fincas = new ArrayList<>(0);
        List<String > result = new ArrayList<>(0);
        int viviendas = 0;
        int locales = 0;
        int garajes = 0;
        int trasteros = 0;

        for (Propietario p : this.propietarios) {
            for (Finca f : p.getFincas()) {
                todas_fincas.add(f);
                if (f.getTipo().equals("Vivienda")) {
                    viviendas++;
                } else if (f.getTipo().equals("Local")) {
                    locales++;
                } else if (f.getTipo().equals("Garaje")) {
                    garajes++;
                } else if (f.getTipo().equals("Trastero")) {
                    trasteros++;
                }
            }
        }

        result.add("Garaje: " + garajes);
        result.add("Local: " + locales);
        result.add("Trastero: " + trasteros);
        result.add("Vivienda: " + viviendas);
        return result;
    }

    public String toString() {
        String result = "";
        List<Propietario> ordenada = new ArrayList<>();
        for (int i = 0; i < this.propietarios.size(); i++) {
            ordenada.add(this.propietarios.get(i));
        }
        ordenada.sort(Comparator.comparing(Propietario::getNombre));

        for (int i = 0; i < ordenada.size()-1; i++) {
            Propietario p = ordenada.get(i);
            result += p.getNombre() + ":" + p.cuotaTotal() + "\n";
            result += p.toString();
            result += "\n" + "\n";
        }
        Propietario p = ordenada.get(ordenada.size()-1);
        result += p.getNombre() + ":" + p.cuotaTotal() + "\n";
        result += p.toString();
        return result;
    }
}
