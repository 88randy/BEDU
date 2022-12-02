package org.BEDU;

public class MermeladaDecorador implements Helado{
    private Helado helado;

    public MermeladaDecorador(Helado helado) {
        this.helado = helado;
    }

    @Override
    public String getDescripcion() {
        return helado.getDescripcion() + ", \ncon Mermelada extra";
    }

    @Override
    public int getPrecio() {
        return helado.getPrecio() + 10;
    }
}
