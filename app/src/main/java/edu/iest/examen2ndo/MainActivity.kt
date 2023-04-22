package edu.iest.examen2ndo

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iest.examen2ndo.adapter.MenuAdapter
import edu.iest.examen2ndo.models.Opciones

class MainActivity : AppCompatActivity() {
    private var recycler: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.rcOpciones)
        val opciones = Opciones().getOpciones()

        recycler?.layoutManager = GridLayoutManager(this, 2)
        recycler?.adapter = MenuAdapter(opciones, this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.opcionMenu) {
            val isConnected = connectToInternet()
            val msg: String
            if (isConnected == true) {
                 msg = "Conectado a internet"
            }else{
                 msg = "Desconectado de internet"
            }
            Toast.makeText(this, "${msg}", Toast.LENGTH_LONG).show()
        }
        return false
    }
    fun connectToInternet(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }
}