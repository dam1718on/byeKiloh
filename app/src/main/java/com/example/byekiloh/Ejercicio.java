package com.example.byekiloh;

import java.util.Calendar;

public class Ejercicio {

    private int id;
    private int distancia;
    private int tiempo;

    public Ejercicio() {
    }

    public Ejercicio(int distancia, int tiempo) {
        this.distancia = distancia;
        this.tiempo = tiempo;
        setId();
    }

    public void setId(){
        Calendar today = Calendar.getInstance();
        int año = today.get(Calendar.YEAR);
        int mes = today.get(Calendar.MONTH)+1;
        int dia = today.get(Calendar.DATE);
        String num = String.valueOf(año)+String.valueOf(mes)+String.valueOf(dia);
        this.id=Integer.parseInt(num);
    }

    public int getId(){
        return id;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Ejercicio{" +
                "id=" + id +
                ", distancia=" + distancia +
                ", tiempo=" + tiempo +
                '}';
    }

}