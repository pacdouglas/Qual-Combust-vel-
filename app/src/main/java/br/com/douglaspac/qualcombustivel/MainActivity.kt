package br.com.douglaspac.qualcombustivel.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import br.com.douglaspac.qualcombustivel.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gas = SaveSharedPreferences.getGas(this)
        val etanol = SaveSharedPreferences.getEtanol(this)

        val gasStr = String.format("%.3f", gas)
        val etanolStr = String.format("%.3f", etanol)

        val mPickEtanol1 = this.nmb_pick_etanol_1
        val mPickEtanol2 = this.nmb_pick_etanol_2
        val mPickEtanol3 = this.nmb_pick_etanol_3
        val mPickEtanol4 = this.nmb_pick_etanol_4

        mPickEtanol1.value = etanolStr[0] - '0'
        mPickEtanol2.value = etanolStr[2] - '0'
        mPickEtanol3.value = etanolStr[3] - '0'
        mPickEtanol4.value = etanolStr[4] - '0'

        val mPickGasolina1 = this.nmb_pick_gasolina_1
        val mPickGasolina2 = this.nmb_pick_gasolina_2
        val mPickGasolina3 = this.nmb_pick_gasolina_3
        val mPickGasolina4 = this.nmb_pick_gasolina_4

        mPickGasolina1.value = gasStr[0] - '0'
        mPickGasolina2.value = gasStr[2] - '0'
        mPickGasolina3.value = gasStr[3] - '0'
        mPickGasolina4.value = gasStr[4] - '0'

        val mBtnCalculate = findViewById(R.id.button) as Button

        mBtnCalculate.setOnClickListener {
            val etanol = java.lang.Float.valueOf(mPickEtanol1.value.toString()
                    + "."
                    + mPickEtanol2.value.toString()
                    + mPickEtanol3.value.toString()
                    + mPickEtanol4.value.toString())
            val gas = java.lang.Float.valueOf(mPickGasolina1.value.toString()
                    + "."
                    + mPickGasolina2.value.toString()
                    + mPickGasolina3.value.toString()
                    + mPickGasolina4.value.toString())

            SaveSharedPreferences.setEtanol(this@MainActivity, etanol)
            SaveSharedPreferences.setGas(this@MainActivity, gas)

            if (etanol!! / gas!! < 0.7) {
                mBtnCalculate.text = getString(R.string.go_alcool)
            } else {
                mBtnCalculate.text = getString(R.string.go_gas)
            }
        }
    }
}
