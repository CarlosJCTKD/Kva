package com.example.miguelguerra1.kva;

public class Usuario
{
    private Integer ID;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String correo;
    private String telefono;
    private String tarjetaCredito;
    
    //Contructor de Objeto Usuario
    public Usuario(String nombre, String apellido,
                    String correo, String contraseña)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.correo = correo;
    }

    //Aqui abajo se encuentran los getter y setter de cada variable deL Usuario
    public Integer getID()
    {
        return ID;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public String getContraseña()
    {
        return contraseña;
    }

    public String getCorreo()
    {
        return correo;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public String getTarjetaCredito()
    {
        return tarjetaCredito;
    }

    public void setID(Integer id)
    {
        ID = id;
    }

    public void setNombre(String nom)
    {
        nombre = nom;
    }

    public  void setApellido(String ape)
    {
        apellido = ape;
    }

    public  void setContraseña(String con)
    {
        contraseña = con;
    }

    public  void setCorreo(String emal)
    {
        correo = emal;
    }

    public void setTelefono(String tel)
    {
        telefono = tel;
    }

    public void setTarjetaCredito(String TC)
    {
        tarjetaCredito = TC;
    }

}
