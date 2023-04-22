package edu.iest.examen2ndo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DatosActivity : AppCompatActivity() {
    private var tvInfo: TextView? = null
    private var etOwnerName: EditText? = null
    private var etCatName: EditText? = null
    private var etCatAge: EditText? = null
    private var fabGuardar: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

       inicializarVistas()
        cargarDatos()

        fabGuardar?.setOnClickListener {
            saveData()
           val i =  Intent(this@DatosActivity, MainActivity::class.java)
            startActivity(i)
        }
    }

    fun inicializarVistas() {
        tvInfo = findViewById(R.id.tvInfo)
        etOwnerName = findViewById(R.id.etOwnerName)
        etCatAge = findViewById(R.id.etCatAge)
        etCatName = findViewById(R.id.etCatName)
        fabGuardar = findViewById(R.id.fabGuardar)
    }

    fun saveData() {
        val preferences = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE)
        val editor = preferences.edit()

        val ownerNAME = etOwnerName?.text.toString()
        val catName = etCatName?.text.toString()
        val catAge = etCatAge?.text.toString()
        editor.putString("OWNER_NAME", ownerNAME)
        editor.putString("CAT_NAME", catName)
        editor.putString("CAT_AGE", catAge)
        editor.apply()
    }


    fun cargarDatos() {
        val preferences = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE)
        val ownerName = preferences.getString("OWNER_NAME", "")
        val catName = preferences.getString("CAT_NAME", "")
        val catAge = preferences.getString("CAT_AGE", "")
        etOwnerName?.setText(ownerName)
        etCatName?.setText(catName)
        etCatAge?.setText(catAge)

        if (ownerName != "" || catName != "" || catAge != "") {
           tvInfo?.text = "Con Datos previamente Gurdados"
        }
    }
}