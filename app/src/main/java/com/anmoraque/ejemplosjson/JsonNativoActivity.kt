package com.anmoraque.ejemplosjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONObject

/*
En esta actividad hemos hablado de:
Introducción Json
Mapeo de objetos JSON nativo
Mapeo de objetos JSON con GSON
 */

class JsonNativoActivity : AppCompatActivity() {
    //Creamos una variable para hacer la lista de personas
    //Usamos arrayList de tipo opcional para iniciar a null
    var listaPersonas:ArrayList<Persona>? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //String Json de ejemplo para el ejercicio de mapeo Json (Lista de personas)
        var respuesta = "{ \"personas\" : [ " +
                "{" +
                " \"nombre\" : \"Marcos\" ," +
                " \"pais\" : \"México\" ," +
                " \"estado\" : \"soltero\" ," +
                " \"experiencia\" : 5}," +

                "{" +
                " \"nombre\" : \"Agustín\" ," +
                " \"pais\" : \"España\" ," +
                " \"estado\" : \"casado\" ," +
                " \"experiencia\" : 16}" +
                " ]" +
                " }"
        //Declaramos un objeto Json del tipo object para que el String respuesta
        // lo transforme a un objeto (una estructura general)
        val json = JSONObject(respuesta)
        //Variable personas para obtener del objeto la lista de personas
        val personas =json.getJSONArray("personas")
        //Inicializamos la lista de personas
        listaPersonas = ArrayList()

        //Voy hacer un recorrido por la lista personas con un for
        //El rango es desde = hasta longitud de personas -1 para que no cuente el ultimo valor
        for (i in 0..personas.length() -1){
            //Con esta variable primero obtenemos el nombre de cada objeto de la lista
            //mediante getJSONObject(i) pasando el indice i
            //Luego obtenemos el valor del String nombre con getString y luego los demás
            val nombre = personas.getJSONObject(i).getString("nombre")
            //Hacemos lo mismo con los demás
            val pais = personas.getJSONObject(i).getString("pais")
            val estado = personas.getJSONObject(i).getString("estado")
            //Luego obtenemos el valor del Int experiencia con getInt
            val experiencia = personas.getJSONObject(i).getInt("experiencia")
            //Creamos un log para probar
            Log.e("ETIQUETA_LOG", "Nombre $nombre")

            //Ahora creamos una clase para personas dentro del proyecto
            //para hacer el mapeo del Json en este caso de objeto personas

            //Variable persona es igual a nueva Persona con sus variables
            //Ycon esto terminamos de pasar el Json (lista de personas en String)
            //a objeto personas con todos sus atributos
            val persona = Persona (nombre, pais, estado, experiencia)
            //Creamos un log para probar
            Log.e("ETIQUETA_LOG", "Pais persona= " + persona.pais)

            //Agragamos los objetos a la lista de personas
            listaPersonas?.add(Persona (nombre, pais, estado, experiencia))
        }
        //Creamos un log para ver si se añadió las personas a la lista
        Log.e("ETIQUETA_LOG", "Lista personas= " + listaPersonas?.count().toString())
    }
}