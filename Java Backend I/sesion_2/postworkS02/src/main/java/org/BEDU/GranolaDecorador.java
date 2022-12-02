package org.BEDU;

public class GranolaDecorador implements Helado{

    private Helado helado;

    public GranolaDecorador(Helado helado) {
        this.helado = helado;
    }

    @Override
    public String getDescripcion() {
        return helado.getDescripcion() + ", \ncon Granola extra";
    }

    @Override
    public int getPrecio() {
        return helado.getPrecio() + 10;
    }
}
