package br.com.douglaspac.qualcombustivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shawnlin.numberpicker.NumberPicker;

public class MainActivity extends AppCompatActivity
{
    NumberPicker mPickEtanol1;
    NumberPicker mPickEtanol2;
    NumberPicker mPickEtanol3;
    NumberPicker mPickEtanol4;

    NumberPicker mPickGasolina1;
    NumberPicker mPickGasolina2;
    NumberPicker mPickGasolina3;
    NumberPicker mPickGasolina4;

    Button mBtnCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Float gas = SaveSharedPreferences.getGas(this);
        Float etanol = SaveSharedPreferences.getEtanol(this);

        String gasStr = String.format("%.3f", gas);
        String etanolStr = String.format("%.3f", etanol);

        mPickEtanol1 = (NumberPicker) findViewById(R.id.nmb_pick_etanol_1);
        mPickEtanol2 = (NumberPicker) findViewById(R.id.nmb_pick_etanol_2);
        mPickEtanol3 = (NumberPicker) findViewById(R.id.nmb_pick_etanol_3);
        mPickEtanol4 = (NumberPicker) findViewById(R.id.nmb_pick_etanol_4);

        mPickEtanol1.setValue(etanolStr.charAt(0) - '0');
        mPickEtanol2.setValue(etanolStr.charAt(2) - '0');
        mPickEtanol3.setValue(etanolStr.charAt(3) - '0');
        mPickEtanol4.setValue(etanolStr.charAt(4) - '0');

        mPickGasolina1 = (NumberPicker) findViewById(R.id.nmb_pick_gasolina_1);
        mPickGasolina2 = (NumberPicker) findViewById(R.id.nmb_pick_gasolina_2);
        mPickGasolina3 = (NumberPicker) findViewById(R.id.nmb_pick_gasolina_3);
        mPickGasolina4 = (NumberPicker) findViewById(R.id.nmb_pick_gasolina_4);

        mPickGasolina1.setValue(gasStr.charAt(0) - '0');
        mPickGasolina2.setValue(gasStr.charAt(2) - '0');
        mPickGasolina3.setValue(gasStr.charAt(3) - '0');
        mPickGasolina4.setValue(gasStr.charAt(4) - '0');

        mBtnCalculate = (Button) findViewById(R.id.button);

        mBtnCalculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Float etanol = Float.valueOf(String.valueOf(mPickEtanol1.getValue())
                                                + "."
                                                + String.valueOf(mPickEtanol2.getValue())
                                                + String.valueOf(mPickEtanol3.getValue())
                                                + String.valueOf(mPickEtanol4.getValue()));
                Float gas = Float.valueOf(String.valueOf(mPickGasolina1.getValue())
                                                + "."
                                                + String.valueOf(mPickGasolina2.getValue())
                                                + String.valueOf(mPickGasolina3.getValue())
                                                + String.valueOf(mPickGasolina4.getValue()));

                SaveSharedPreferences.setEtanol(MainActivity.this, etanol);
                SaveSharedPreferences.setGas(MainActivity.this, gas);

                if(etanol / gas < 0.7)
                {
                    mBtnCalculate.setText(getString(R.string.go_alcool));
                }
                else
                {
                    mBtnCalculate.setText(getString(R.string.go_gas));
                }
            }
        });
    }
}
