package org.BEDU;


public class PersonaBuilder {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String estadoCivil;
    private int edad;
    private String direccion;

    public PersonaBuilder(String nombre, String apellidoPaterno, String
                          apellidoMaterno){
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoPaterno;
    }

    public PersonaBuilder estadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
        return this;
    }

    public PersonaBuilder edad(int edad){
        this.edad = edad;
        return this;
    }

    public PersonaBuilder direccion(String direccion){
        this.direccion = direccion;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void validar(){
        if( edad < 18 ){
            //throw new Exception("message: La edad debe ser mayor a 18")
            System.out.println("La edad debe ser mayor a 18");
        }
    }

    public Persona construir(){
        return new Persona(this);
    }
}
