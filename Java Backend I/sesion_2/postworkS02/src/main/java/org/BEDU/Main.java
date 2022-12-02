package org.BEDU;

public class Main {
    public static void main(String[] args) {

        Helado suave = new HeladoSuave();

        suave = new CoberturaDecorador(suave);
        suave = new GranolaDecorador(suave);
        suave = new ToppingDecorador(suave);
        suave = new MermeladaDecorador(suave);
        // Agregamos Doble Galleta
        suave = new GalletaDecorador(suave);
        suave = new GalletaDecorador(suave);
        // Agregamos una vez más Mermelada
        suave = new MermeladaDecorador(suave);

        System.out.println("Bienvenido a la Heladería BEDU\n");
        System.out.println(suave.getDescripcion());
        System.out.println("Total a pagar $" + suave.getPrecio());
    }
}