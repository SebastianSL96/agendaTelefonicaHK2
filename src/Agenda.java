import java.util.*;

public class Agenda {
    List<Contacto> agenda = new ArrayList<>();

    public void agregarContacto(Contacto contacto) {
        if (contacto == null) {
            System.out.println("Contacto inválido");
            return;
        }

        if (agendaLlena()) {
            System.out.println("Agenda llena. No hay espacio disponible.");
            return;
        }

        for (Contacto c : agenda) {
            if (c.getNombre().equalsIgnoreCase(contacto.getNombre())
                    && c.getApellido().equalsIgnoreCase(contacto.getApellido())) {
                System.out.println("El contacto ya existe.");
                return;
            }
        }

        agenda.add(contacto);
        System.out.println("Contacto agregado correctamente.");
    }


    public boolean existeContacto(Contacto contacto) {
        for (Contacto c : agenda) {
            if (c.getNombre().equalsIgnoreCase(contacto.getNombre())
                    && c.getApellido().equalsIgnoreCase(contacto.getApellido())) {
                return true;
            }
        }
        return false;
    }
    
    public void listarContacto() {

        if (agenda.isEmpty()) {
            System.out.println("Agenda vacía.");
            return;
        }

        agenda.sort(
                Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER)
        );

        for (Contacto c : agenda) {
            System.out.println(
                    c.getNombre() + " " +
                            c.getApellido() + " - " +
                            c.getTelefono()
            );
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

    public int espaciosLibres() {
        return 10 - agenda.size();
    }






}
