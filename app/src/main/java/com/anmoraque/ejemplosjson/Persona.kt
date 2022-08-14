package com.anmoraque.ejemplosjson


//Clase Persona voy a requerir todos los atributos del Json
//Nombre, pais, estado, experiencia
class Persona (nombre:String, pais:String, estado:String, experiencia:Int){
    //Inicializamos los parametros
    var nombre:String = ""
    var pais:String = ""
    var estado:String = ""
    var experiencia:Int = 0

    //Creamos el constructor init
    init {
        this.nombre = nombre
        this.pais = pais
        this.estado = estado
        this.experiencia = experiencia
    }
}