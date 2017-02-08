package br.com.matheush.appcalculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvResultado;
    float numA = 0;
    String operacao = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = (TextView) findViewById(R.id.tvResultado);
        tvResultado.setText("0");
    }

    public void clicaBotao(View view) {
        switch (view.getId()) {
            case R.id.btclear:
                tvResultado.setText("0");
                numA = 0;
                operacao = "";
                break;
            case R.id.btsoma:
                fazConta("+");
                break;
            case R.id.btsubtrai:
                fazConta("-");
                break;
            case R.id.btvezes:
                fazConta("*");
                break;
            case R.id.btdividir:
                fazConta("/");
                break;
            case R.id.btigual:
                mostraResultado();
                break;
            default:
                String numB;
                numB = ((Button)view).getText().toString();
                getKeyboard(numB);
                break;
        }
    }

    public void fazConta(String tipoConta) {
        numA = Float.parseFloat(tvResultado.getText().toString());
        operacao = tipoConta;
        tvResultado.setText("0");
    }

    public void getKeyboard(String str) {
        String strCurrent = tvResultado.getText().toString();
        strCurrent += str;
        tvResultado.setText(strCurrent);
    }

    public void mostraResultado() {
        float numB = Float.parseFloat(tvResultado.getText().toString());
        float resultado = 0;

        if (operacao.equals("+")) {
            resultado = numA+numB;
        }
        if (operacao.equals("-")) {
            resultado = numA-numB;
        }
        if (operacao.equals("*")) {
            resultado = numA*numB;
        }
        if (operacao.equals("/")) {
            resultado = numA/numB;
        }

        tvResultado.setText(String.valueOf(resultado));
    }
}
