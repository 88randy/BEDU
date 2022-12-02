package org.BEDU;

public class CoberturaDecorador implements Helado{
    private Helado helado;

    public CoberturaDecorador(Helado helado) {
        this.helado = helado;
    }

    @Override
    public String getDescripcion() {
        return helado.getDescripcion() + ", \ncon Cobertura extra";
    }

    @Override
    public int getPrecio() {
        return helado.getPrecio() + 20;
    }
}
