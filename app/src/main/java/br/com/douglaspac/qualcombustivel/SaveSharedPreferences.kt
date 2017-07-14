package br.com.douglaspac.qualcombustivel.kotlin

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SaveSharedPreferences {
    companion object {
        internal val PREF_GAS = "gas"
        internal val PREF_ETANOL = "etanol"

        private fun getSharedPreferences(ctx: Context) : SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(ctx)
        }
        fun setGas(ctx: Context, gas: Float?) {
            val editor = getSharedPreferences(ctx).edit()
            if(gas != null){
                editor.putFloat(PREF_GAS, gas)
                editor.apply()
            }
        }

        fun getGas(ctx: Context): Float {
            return getSharedPreferences(ctx).getFloat(PREF_GAS, 3.000.toFloat())
        }

        fun setEtanol(ctx: Context, etanol: Float?) {
            val editor = getSharedPreferences(ctx).edit()
            if(etanol != null) {
                editor.putFloat(PREF_ETANOL, etanol)
                editor.apply()
            }
        }

        fun getEtanol(ctx: Context): Float {
            return getSharedPreferences(ctx).getFloat(PREF_ETANOL, 2.000.toFloat())
        }
    }
}