public class Contactos {

    // Atributos de los contactos
    private String nombre;
    private String apellido;
    private String telefono;

    // Constructor que valida los parametros al crear el contacto
    public Contactos(String nombre, String apellido, String telefono) {

        // El if valida el nombre no puede ser null ni vacio
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede estar vacio");
        }

        // El if valida el apellido no puede ser null ni vacio
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede estar vacio");
        }

        // Valida que el telefono tenga 10 numeros
        if (telefono.matches("\\d{10}")) {
            throw new IllegalArgumentException("Telefono debe tener 10 digitos");
        }
    }

    // Getter de datos
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o== null || getClass() !=o.getClass()) return false;

        //Comparacion de nombres y apellidos
        Contactos contacto =(Contactos) o;
        return nombre.equalsIgnoreCase(contacto.nombre) && apellido.equalsIgnoreCase(contacto.apellido);

    }

    @Override
    public String toString() {
        return "Contactos{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    // Genera hash basado en nombre y apellido
    @Override
    public int hashCode() {
        return (nombre.toLowerCase() + apellido.toLowerCase()+ telefono.toLowerCase()).hashCode();

    }
}

