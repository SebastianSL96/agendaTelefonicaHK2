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

    public List<Contacto> getAgenda() {
        return agenda;
    }

    //Aqui metodo eliminar con remove(el remove por defecto busca)
    public void eliminarContacto(Contacto c) {

        if (agenda.remove(c)) {
            System.out.println("Contacto eliminado");
        } else {
            System.out.println("El contacto no existe");
        }


    }
    //recorre la lista agenda verifica que coincidan nombre y apellid
    //cambia el numero de telefono
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {

        for (Contacto c : agenda) {

            if (c.getNombre().equalsIgnoreCase(nombre)
                    && c.getApellido().equalsIgnoreCase(apellido)) {

                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono modificado correctamente");
                return;
            }
        }

        System.out.println("Contacto no encontrado");
    }
    //METODOS DE agenda llena solo compara el tamaño

    public boolean agendaLlena() {
        return agenda.size() >= 10;
    }

    public int espacioLibres() {
        return 10 - agenda.size();
    }






}
