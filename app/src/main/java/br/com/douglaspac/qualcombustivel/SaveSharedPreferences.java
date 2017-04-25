package br.com.douglaspac.qualcombustivel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by douglasmartins on 24/04/17.
 */

public class SaveSharedPreferences
{
    static final String PREF_GAS = "gas";
    static final String PREF_ETANOL = "etanol";

    static SharedPreferences getSharedPreferences(Context ctx)
    {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setGas(Context ctx, Float gas)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putFloat(PREF_GAS, gas);
        editor.commit();
    }

    public static Float getGas(Context ctx)
    {
        return getSharedPreferences(ctx).getFloat(PREF_GAS, (float) 3.000);
    }

    public static void setEtanol(Context ctx, Float etanol)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putFloat(PREF_ETANOL, etanol);
        editor.commit();
    }

    public static Float getEtanol(Context ctx)
    {
        return getSharedPreferences(ctx).getFloat(PREF_ETANOL, (float) 2.000);
    }


}
