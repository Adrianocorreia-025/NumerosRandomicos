package ar.adriano.appadvinha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var jogo = 0
    private var Tentativas = 0
    private val random = Random()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        novoJogo()

    }

    private fun NumeroRandom() {
        findViewById<TextView>(R.id.textViewRandom).text = "Numero Alhatorio ${random.nextInt(10) + 1}"
    }

    private fun MostrarTentativas() {
        findViewById<TextView>(R.id.textViewTentativas).text = " Suas tentativas:  $Tentativas"
    }

    private fun ActualizarJogo() {
        findViewById<TextView>(R.id.textViewJogo).text = "Quantas Vezes ja Jogou: $jogo"

    }

    private fun novoJogo() {
        MostrarTentativas()
        ActualizarJogo()
        //NumeroRandom()
    }


    fun TentarSorte(view: View) {
        Tentativas++
        jogo++
        ActualizarJogo()
        MostrarTentativas()
        NumeroRandom()
        val Numero = findViewById<EditText>(R.id.TextInputEditTextNumero)
        val Resulta = findViewById<TextView>(R.id.textViewResultado)
        if (Numero == random) {

            Resulta.text = "Parabens o seu Numero Coensidiu co Numero Alhatorio "
        } else{
            Resulta.text="Perdeu Joga mais"

    }
    }
}