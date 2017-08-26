package br.ufjf.dcc196.dcc196exemplo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {
    private EditText numero1;
    private EditText numero2;
    private TextView resultado;
    private Button somar;
    private Button subtrair;
    private Button multiplicar;
    private Button dividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //1 - Encontre os componentes na entrada
        numero1 = (EditText) findViewById(R.id.numero1);
        numero2 = (EditText) findViewById(R.id.numero2);

        //2- Procure os componentes de saída
        resultado = (TextView) findViewById(R.id.resultado);

        //3- Procure os componentes de controle
        somar = (Button) findViewById(R.id.somar);
        subtrair = (Button) findViewById(R.id.subtrair);
        multiplicar = (Button) findViewById(R.id.multiplicar);
        dividir = (Button) findViewById(R.id.dividir);

        //4- Configurar os ouvintes para eventos
        Ouvinte ouvinteInstancia = new Ouvinte();
        somar.setOnClickListener(ouvinteInstancia);
        subtrair.setOnClickListener(ouvinteInstancia);
        multiplicar.setOnClickListener(ouvinteInstancia);
        dividir.setOnClickListener(ouvinteInstancia);
    }

    private class Ouvinte implements View.OnClickListener {
        @Override
        public void onClick(View view){
            Integer n1 = Integer.parseInt(numero1.getText().toString());
            Integer n2 = Integer.parseInt(numero2.getText().toString());

            if(view == somar) {
                Integer soma = n1 + n2;
                resultado.setText("A soma de "+n1+" e "+n2+" é: "+soma);
            }
            if(view == subtrair) {
                Integer subtracao = n1 - n2;
                resultado.setText("A subtração de "+n1+" e "+n2+" é: "+subtracao);
            }
            if(view == multiplicar) {
                Integer multiplicacao = n1 * n2;
                resultado.setText("A multiplicação de "+n1+" e "+n2+" é: "+multiplicacao);
            }
            if(view == dividir) {
                Integer divisao = n1 / n2;
                resultado.setText("A divisão de "+n1+" e "+n2+" é: "+divisao);
            }
        }
    }
}
