import java.util.*;

public class Agenda {
  List<Contacto> agenda = new ArrayList<>();

    public void agregarContacto(Contacto contacto) {
        boolean encontrado = false;

        for (Contacto con : agenda) {
            if (con.getNombre().equals(contacto.getNombre())){
                System.out.println("Contacto ya existe.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            if (agenda.size() < 3) {
                agenda.add(contacto);
                System.out.println("Contacto agregado.");
            } else {
                System.out.println("Agenda llena.");
            }
        }
    }

    public void listarContacto() {
        agenda.sort(Comparator.comparing(Contacto::getNombre));
        for (Contacto contacto : agenda) {
            System.out.println(contacto.getNombre() + " " +contacto.getApellido() + " - " + contacto.getTelefono());
        }
    }

    public void buscarContacto(String nombre) {
        boolean encontrado = false;

        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equals(nombre)) {
                System.out.println(contacto.getTelefono());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Contacto " + nombre + " no encontrado.");
        }
    }
}
