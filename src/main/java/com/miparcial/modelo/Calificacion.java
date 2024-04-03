package com.miparcial.modelo;

public class Calificacion{
	private int id;
	private String nombres;
	private float primero;
	private float segundo;
	private float tercero;
	private float nota;
	
	public Calificacion(){
		this.id = 0;
		this.nombres = "";
		this.primero = 0;
		this.segundo = 0;
		this.tercero = 0;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public float getPrimero() {
        return primero;
    }

    public void setPrimero(float primero) {
        this.primero = primero;
    }

    public float getSegundo() {
        return segundo;
    }

    public void setSegundo(float segundo) {
        this.segundo = segundo;
    }

    public float getTercero() {
        return tercero;
    }

    public void setTercero(float tercero) {
        this.tercero = tercero;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
        
}