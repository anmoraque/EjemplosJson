package com.anmoraque.ejemplosjson

//Clase Personas voy a requerir de atributo la lista de Persona de la otra clase
class Personas (personas:ArrayList<Persona>){
    //Creo la lista de personas
    var personas:ArrayList<Persona>? = null
    //Creamos el constructor init
    init {
        this.personas = personas
    }

}