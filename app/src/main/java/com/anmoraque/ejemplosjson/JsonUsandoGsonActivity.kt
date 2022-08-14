package com.anmoraque.ejemplosjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import org.json.JSONObject

/*
En esta actividad hemos hablado de:
Añadimos la libreria Gson
Mapeo de objetos JSON con GSON
 */
class JsonUsandoGsonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_usando_gson)
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
        //Con Gson vamos a crear otra clase en nuestro proyecto
        //llamada Personas igual que la usada para Json nativo
        //pero con el añadido de la lista persona

        //Declaramos un objeto Gson
        val gson = Gson()
        //le pedimos que coja el Json respuesta y lo lleve a la clase Personas
        //que se encargara de agregarlo a la lista de personas
        val res = gson.fromJson(respuesta, Personas::class.java)
        //Creamos un log para ver las personas introducidas con Gson
        Log.e("ETIQUETA_LOG", "Lista personas con Gson= " + res.personas?.count().toString())

    }
}