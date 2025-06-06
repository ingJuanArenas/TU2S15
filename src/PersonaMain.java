

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

        

            System.out.println("Según los datos ingresados: ");
            // contar
            long cantidad = personas.stream().count();
            System.out.println("La cantidad de personas registragas es = "  + cantidad);


            //promedio

            Double promedio= personas.stream().mapToDouble(Persona::getEdad).average().orElse(0);
            System.out.println("El promedio de las edades de las personas registradas es: "+ promedio);

            //  mayores de edad
            long cantidadMayores= personas.stream().filter(p-> p.getEdad()>= 18).count();
            System.out.println("Las cantidad de personas mayores de edad registradas son: "+ cantidadMayores);

            // mostrar personas nombres empiecen con A
            System.out.println("Las personas que comienzan su nombre con la letra A son: ");
            personas.stream().filter(p -> p.getNombre().toUpperCase().startsWith("A")).forEach(p -> {
                System.out.println("Nombre:  " + p.getNombre() + " Apellido: " + p.getApellido());
            });;

            // mostrar personas apellido m
            System.out.println("Las personas que contienen M en su apellido son: ");
            personas.stream().filter(p-> p.getApellido().toLowerCase().contains("m")).forEach(p->{
                System.out.println("Nombre: "+p.getNombre()+ " Apellido: "+ p.getApellido());
            });

            //  sueldo de 8h con director masculino
            System.out.println("Los directores y su sueldo de 8 horas: ");
            personas.stream()
            .filter(p -> p.getCargo().equalsIgnoreCase("director") && p.getGenero().equalsIgnoreCase("M"))
            .peek(p -> System.out.print("Nombre: " + p.getNombre() + " " + p.getApellido() + " "))
            .map(p -> p.getSueldoHora() * 8)
            .forEach(sueldo -> System.out.println("Sueldo por 8 horas: $" + sueldo));

            //Encontrar la desarrolladora mujer
         Optional<Persona> primeraDesarrolladora = personas.stream()
        .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador") && p.getGenero().equalsIgnoreCase("F"))
        .findFirst();

         primeraDesarrolladora.ifPresent(p ->
            System.out.println("Primera desarrolladora encontrada: " + p.getNombre() + " " + p.getApellido())
            );

        //Desarrollador que mas gana x hora
        Optional<Persona> masGana = personas.stream()
        .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador"))
        .max(Comparator.comparing(Persona::getSueldoHora));

        if (masGana.isPresent()) {
            Persona p = masGana.get();
            System.out.println("Desarrollador que más gana: " + p.getNombre() + " " + p.getApellido() +
                            " - $" + p.getSueldoHora() + " por hora");
        }
        // Mujeres ordenadas
        System.out.println("Listado de mujeres ordenado");
        personas.stream()
        .filter(p -> p.getGenero().equalsIgnoreCase("F"))
        .sorted(Comparator.comparing(Persona::getNombre))
        .forEach(p -> System.out.println(p.getNombre() + " " + p.getApellido()));


        sc.close();

    }
}
 

