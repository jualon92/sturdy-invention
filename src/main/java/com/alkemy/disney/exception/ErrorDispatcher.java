package com.alkemy.disney.exception;

public class ErrorDispatcher {



    public static String PERSONAJENOTFOUND(){
        return "id Personaje no encontrada";
    }

    public static String  PELICULANOTFOUND(){
        return "id Pelicula no encontrada";
    }

    public static String  ERRORMAILNOTSENT(){
        return "error al enviar mail";
    }



}
