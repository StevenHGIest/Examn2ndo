package edu.iest.examen2ndo.models

import edu.iest.examen2ndo.R

class Opciones {

    fun getOpciones(): ArrayList<OpcionMenu>{

        val opcines: ArrayList<OpcionMenu> = arrayListOf()

        opcines.add(
            OpcionMenu("Gatos", R.drawable.cat)
        )

        opcines.add(
            OpcionMenu("Datos", R.drawable.profile)
        )

        opcines.add(
            OpcionMenu("Configurar", R.drawable.config)
        )

        opcines.add(
            OpcionMenu("Cerrar", R.drawable.close)
        )


        return opcines
    }
}