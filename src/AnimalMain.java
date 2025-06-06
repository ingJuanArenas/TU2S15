
import java.util.*;

public class AnimalMain {
    public static void main(String[] args) {
        Map<String, List<Animal>> clasificacion = new HashMap<>();
        List<Animal> animales = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos animales quieres ingresar? ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Animal #" + (i + 1));

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Tipo (terrestre, aéreo, acuático): ");
            String tipo = scanner.nextLine().toLowerCase(); 

            System.out.print("Género (masculino, femenino): ");
            String genero = scanner.nextLine();

            Animal animal = new Animal(nombre, tipo, genero);
            animales.add(animal);

            clasificacion.putIfAbsent(tipo, new ArrayList<>());
            clasificacion.get(tipo).add(animal);
        }


        System.out.println("\n--- Clasificación de Animales ---");
        for (String tipo : clasificacion.keySet()) {
            System.out.println( tipo.toUpperCase() + ":");
            for (Animal animal : clasificacion.get(tipo)) {
                System.out.println("  " + animal.getNombre());
            }
        }

        scanner.close();
    }


}
