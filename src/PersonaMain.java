

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;




public class PersonaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>(); 
        int opcion;

    
        do {
                System.out.println("Nombre: ");
                String nombre = sc.nextLine();

                System.out.println("Apellido: ");
                String apellido = sc.nextLine();

                System.out.println("Edad: ");
                int edad = sc.nextInt();
                sc.nextLine(); 

                System.out.println("Género: ");
                String genero = sc.nextLine();

                System.out.println("Sueldo x hora: ");
                double sueldo = sc.nextDouble();
                sc.nextLine(); 

                System.out.println("Cargo: ");
                String cargo = sc.nextLine();

                personas.add(new Persona(nombre, apellido, edad, genero, sueldo, cargo));

                System.out.println("1. Seguir agregando | 0. Salir");
                opcion = sc.nextInt();
                sc.nextLine(); 
            } while (opcion != 0);

        

         



    }
}
 

