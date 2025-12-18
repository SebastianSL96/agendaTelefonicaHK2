public class Contacto {

    // Atributos de los contactos
    private String nombre;
    private String apellido;
    private String telefono;

    // Constructor que valida los parametros al crear el contacto
    public Contacto(String nombre, String apellido, String telefono) {

        // El if valida el nombre no puede ser null ni vacio
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede estar vacio");
        }

        // El if valida el apellido no puede ser null ni vacio
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("Apellido no puede estar vacio");
        }

        // Valida que el telefono tenga 10 numeros
        if (!telefono.matches("\\d{10}")) {
            throw new IllegalArgumentException("Telefono debe tener 10 digitos");
        }
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.telefono = telefono;
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contacto)) return false;
        Contacto c = (Contacto) obj;
        return nombre.equalsIgnoreCase(c.nombre)
                && apellido.equalsIgnoreCase(c.apellido);
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    // Genera hash basado en nombre y apellido
    @Override
    public int hashCode() {
        return (nombre.toLowerCase() + apellido.toLowerCase()).hashCode();

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

