/**
 * Clase ComunidadDePropietariosMain que representa la
 * aplicación principal de la comunidad de propietarios
 */
public class ComunidadDePropietariosMain {

    /**
     * Método main: ejecuta la aplicación usando tanto la interfaz de consola
     */
    public static void main(String[] args){
// DESCOMENTAR cuando estén desarrolladas las clases
        ComunidadDePropietarios miComunidad = new ComunidadDePropietarios("Mi comunidad", 18000);
        initComunidadDePropietarios(miComunidad);
        System.out.println(miComunidad);
        System.out.println("\n");
        System.out.println(miComunidad.getFincasDistintas());
        System.out.println("\n");
        System.out.println(miComunidad.getPropietario("p1"));

// RESULTADO MOSTRADO EN LA CONSOLA:
// p1:9.5
// 1) [Nombre: g1 tipo: Garaje cuota: 2.0]
// 2) [Nombre: v1 tipo: Vivienda cuota: 7.0]
// 3) [Nombre: t3 tipo: Trastero cuota: 0.5]
//
// p2:17.0
// 1) [Nombre: v2 tipo: Vivienda cuota: 9.0]
// 2) [Nombre: g2 tipo: Garaje cuota: 2.0]
// 3) [Nombre: v4 tipo: Vivienda cuota: 5.0]
// 4) [Nombre: t2 tipo: Trastero cuota: 1.0]
//
// p3:9.5
// 1) [Nombre: g3 tipo: Garaje cuota: 1.5]
// 2) [Nombre: v3 tipo: Vivienda cuota: 7.0]
// 3) [Nombre: t1 tipo: Trastero cuota: 1.0]
//
// p4:21.0
// 1) [Nombre: l1 tipo: Local cuota: 9.0]
// 2) [Nombre: l2 tipo: Local cuota: 12.0]

    }

    /**
     * Inicializa la Comunidad de Propietarios con varios propietarios
     * con sus correspondientes fincas
     */
    private static void initComunidadDePropietarios(ComunidadDePropietarios comunidadPP){
        Propietario p1 = new Propietario("p1");
        Propietario p2 = new Propietario("p2");
        Propietario p3 = new Propietario("p3");
        Propietario p4 = new Propietario("p4");

        p1.addFinca(new Finca("v1", "Vivienda", 7));
        p2.addFinca(new Finca("v2", "Vivienda", 9));
        p3.addFinca(new Finca("v3", "Vivienda", 7));
        p2.addFinca(new Finca("v4", "Vivienda", 5));
        p4.addFinca(new Finca("l1", "Local", 9));
        p4.addFinca(new Finca("l2", "Local", 12));
        p1.addFinca(new Finca("g1", "Garaje", 2));
        p2.addFinca(new Finca("g2", "Garaje", 2));
        p3.addFinca(new Finca("g3", "Garaje", 1.5));
        p3.addFinca(new Finca("t1", "Trastero", 1));
        p2.addFinca(new Finca("t2", "Trastero", 1));
        p1.addFinca(new Finca("t3", "Trastero", 0.5));

        comunidadPP.addPropietario(p4);
        comunidadPP.addPropietario(p3);
        comunidadPP.addPropietario(p2);
        comunidadPP.addPropietario(p1);
    }

}
