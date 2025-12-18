//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class MainAgenda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion;
        do {
            System.out.println("\n--- AGENDA TELEFÓNICA ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. Espacios libres");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            try {
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Nombre: ");
                        String n = sc.nextLine();
                        System.out.print("Apellido: ");
                        String a = sc.nextLine();
                        System.out.print("Teléfono: ");
                        String t = sc.nextLine();
                        agenda.agregarContacto(new Contacto(n, a, t));
                    }
                    case 2 -> agenda.listarContacto();
                    case 3 -> {
                        System.out.print("Nombre: ");
                        String n = sc.nextLine();
                        System.out.print("Apellido: ");
                        String a = sc.nextLine();
                        agenda.buscarContacto(n);
                    }
                    case 4 -> {
                        System.out.print("Nombre: ");
                        String n = sc.nextLine();
                        System.out.print("Apellido: ");
                        String a = sc.nextLine();
                        agenda.eliminarContacto(new Contacto(n, a, "1234567"));
                    }
                    case 5 -> {
                        System.out.print("Nombre: ");
                        String n = sc.nextLine();
                        System.out.print("Apellido: ");
                        String a = sc.nextLine();
                        System.out.print("Nuevo teléfono: ");
                        String t = sc.nextLine();
                        agenda.modificarTelefono(n, a, t);
                    }
                    case 6 -> System.out.println("Espacios libres: " + agenda.espaciosLibres());
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
        sc.close();
    }
}
