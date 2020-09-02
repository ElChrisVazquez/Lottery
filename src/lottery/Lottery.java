package lottery;

import java.util.Scanner;

public class Lottery {

    private String entrada;
    private int cantidad, salida;
    private Scanner sc;
    private int[] denominaciones = {100, 20, 10, 5, 1};

    public Lottery() {
        sc = new Scanner(System.in);
        // Validar rango
        do {
            // Validar sea digito
            do {
                System.out.println("Ingrese cantidad a retirar:");
                entrada = sc.next();
                if (!esNumero(entrada)) {
                    System.out.println("La entrada no es un número valido.");
                } else {
                    cantidad = Integer.parseInt(entrada);
                }
            } while (!esNumero(entrada));
            if(cantidad < 1 || cantidad > 109){
                System.out.println("El monto maximo a retirar es de $109");
            }
        } while (cantidad < 1 || cantidad > 109);
        
        salida = hitTheLottery(cantidad);
        // Imprime salida
        System.out.println("Salida: " + salida);
    }

    // Función que calcula numero de movimientos
    public int hitTheLottery(int cantidad) {
        int contador = 0;
        for (int i = 0; i < denominaciones.length; i++) {
            do {
                if (cantidad / denominaciones[i] > 0) {
                    cantidad -= denominaciones[i];
                    contador++;
                }
            } while (cantidad / denominaciones[i] > 0);
        }
        // Retorna el contador
        return contador;
    }
    
    //Función valida número
    public boolean esNumero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Lottery l = new Lottery();
    }
}
