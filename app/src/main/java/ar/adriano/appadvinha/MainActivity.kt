package ar.adriano.appadvinha

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    private var jogo = 0
    private var Tentativas = 0
    private val random = Random()
    private var NumeroAdvinhar = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Ele Verifica se J existe um esta Guardado ou Nao (savedInstanceState)

        if (savedInstanceState==null) {
            novoJogo()
        }else {
                NumeroAdvinhar = savedInstanceState.getInt(NUMBER_ADVINHAR)
                jogo = savedInstanceState.getInt(JOGO)
                Tentativas = savedInstanceState.getInt(TENTATIVAS)
            MostrarTentativas()
            ActualizarJogo()
        }

        }




// Guardar acoes quando acontece qualquer coisa ao estarmos a Jogar

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NUMBER_ADVINHAR, NumeroAdvinhar)
        outState.putInt(JOGO,jogo)
         outState.putInt(TENTATIVAS,Tentativas)
    }
        private fun NumeroRandom() {
            findViewById<TextView>(R.id.textViewRandom).text = "Numero Alhatorio ${random.nextInt(3) + 1}"
            NumeroAdvinhar= random.nextInt(3)+1
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
            jogo++
        }

    // Funcao para Mostrar mensagem Processos de Botao
        fun TentarSorte(view: View) {
            Tentativas++
            ActualizarJogo()
            MostrarTentativas()
           NumeroRandom()
            val Numero = findViewById<EditText>(R.id.TextInputEditTextNumero)
        //    val Resulta = findViewById<TextView>(R.id.textViewResultado)

            if (Numero != random) {

              //  Resulta.text = "Parabens o seu Numero Coensidiu com Numero Alhatorio "
           //     QuerJogarMais()
                QuerJogar()
            } else {
             //   Resulta.text = "Perdeu Joga mais"
             //   QuerJogarMais()
                QuerJogarMais()
            }


        }
   // Funcao para Mostrar mensagem de Vitoria No Ecrã

        private fun QuerJogarMais() {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle(R.string.acertou)
            alertDialogBuilder.setMessage(getString(R.string.Jogar_Novamente))


            alertDialogBuilder.setPositiveButton(

                    android.R.string.ok,
                    { dialog, which -> novoJogo() }
            )

            alertDialogBuilder.setNegativeButton(
                    android.R.string.cancel,
                    { dialog, which -> finish() }

            )

            alertDialogBuilder.show()
        }

// Funcao para Mostrar mensagem da Perda No Ecrã

    private fun QuerJogar() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle(R.string.Perdeu)
        alertDialogBuilder.setMessage(getString(R.string.Jogar_Novamente))


        alertDialogBuilder.setPositiveButton(

                android.R.string.ok,
                { dialog, which -> novoJogo() }
        )

        alertDialogBuilder.setNegativeButton(
                android.R.string.cancel,
                { dialog, which -> finish() }

        )

        alertDialogBuilder.show()
    }





        companion object{

            const val  NUMBER_ADVINHAR = "Numero_Advinhar"
            const val JOGO = "jogo"
            const val TENTATIVAS = "TENTATIVAS"
        }

}


