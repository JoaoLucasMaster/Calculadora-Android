package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private TextView textViewUltimaExpressao, textViewResultado;

    private Button buttonUmID, buttonDoisID, buttonTresID, buttonQuatroID, buttonCincoID,
            buttonSeisID, buttonSeteID, buttonOitoID, buttonNoveID, buttonZeroID, buttonVirgulaID, buttonSomaID, buttonSubtracaoID,
            buttonPorcentoID, buttonMultiplicacaoID, buttonDivisaoID, buttonResetID, buttonDeleteID, buttonIgual;

    private String expressao = "";
    private Double resultado = 0.0;
    private boolean operadorSelecionado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        buttonVirgulaID = findViewById(R.id.buttonVirgulaID);
        buttonVirgulaID.setOnClickListener(this);

        buttonPorcentoID = findViewById(R.id.buttonPorcentoID);
        buttonPorcentoID.setOnClickListener(this);

        buttonSomaID = findViewById(R.id.buttonSomaID);
        buttonSomaID.setOnClickListener(this);

        buttonMultiplicacaoID = findViewById(R.id.buttonMultiplicacaoID);
        buttonMultiplicacaoID.setOnClickListener(this);

        buttonSubtracaoID = findViewById(R.id.buttonSubtracaoID);
        buttonSubtracaoID.setOnClickListener(this);

        buttonDivisaoID = findViewById(R.id.buttonDivisaoID);
        buttonResetID = findViewById(R.id.buttonResetID);
        buttonDeleteID = findViewById(R.id.buttonDeleteID);

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        buttonIgual = findViewById(R.id.buttonIgualID);
        buttonIgual.setOnClickListener(this);

        buttonZeroID = findViewById(R.id.buttonZeroID);
        buttonZeroID.setOnClickListener(this);

        buttonUmID = findViewById(R.id.buttonUmID);
        buttonUmID.setOnClickListener(this);

        buttonDoisID = findViewById(R.id.buttonDoisID);
        buttonDoisID.setOnClickListener(this);

        buttonTresID = findViewById(R.id.buttonTresID);
        buttonTresID.setOnClickListener(this);

        buttonQuatroID = findViewById(R.id.buttonQuatroID);
        buttonQuatroID.setOnClickListener(this);

        buttonCincoID = findViewById(R.id.buttonCincoID);
        buttonCincoID.setOnClickListener(this);

        buttonSeisID = findViewById(R.id.buttonSeisID);
        buttonSeisID.setOnClickListener(this);

        buttonSeteID = findViewById(R.id.buttonSeteID);
        buttonSeteID.setOnClickListener(this);

        buttonOitoID = findViewById(R.id.buttonOitoID);
        buttonOitoID.setOnClickListener(this);

        buttonNoveID = findViewById(R.id.buttonNoveID);
        buttonNoveID.setOnClickListener(this);


        buttonVirgulaID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append(".");
            }
        });

        buttonPorcentoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se há um resultado anterior
                if (resultado != 0) {
                    // Use o resultado anterior como o primeiro operando
                    textViewUltimaExpressao.setText(String.valueOf(resultado) + "%");
                } else {
                    // Caso contrário, use a última expressão completa como a expressão atual
                    textViewUltimaExpressao.append("%");
                }
            }
        });

        buttonSomaID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se há um resultado anterior
                if (resultado != 0) {
                    // Use o resultado anterior como o primeiro operando
                    textViewUltimaExpressao.setText(String.valueOf(resultado) + "+");
                } else {
                    // Caso contrário, use a última expressão completa como a expressão atual
                    textViewUltimaExpressao.append("+");
                }
            }
        });

        buttonMultiplicacaoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se há um resultado anterior
                if (resultado != 0) {
                    // Use o resultado anterior como o primeiro operando
                    textViewUltimaExpressao.setText(String.valueOf(resultado) + "*");
                } else {
                    // Caso contrário, use a última expressão completa como a expressão atual
                    textViewUltimaExpressao.append("*");
                }
            }
        });

        buttonSubtracaoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se há um resultado anterior
                if (resultado != 0) {
                    // Use o resultado anterior como o primeiro operando
                    textViewUltimaExpressao.setText(String.valueOf(resultado) + "-");
                } else {
                    // Caso contrário, use a última expressão completa como a expressão atual
                    textViewUltimaExpressao.append("-");
                }
            }
        });

        buttonDivisaoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se há um resultado anterior
                if (resultado != 0) {
                    // Use o resultado anterior como o primeiro operando
                    textViewUltimaExpressao.setText(String.valueOf(resultado) + "/");
                } else {
                    // Caso contrário, use a última expressão completa como a expressão atual
                    textViewUltimaExpressao.append("/");
                }
            }
        });

        buttonResetID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado= 0.0;
                textViewUltimaExpressao.setText("");
                textViewResultado.setText("");
            }
        });

        buttonDeleteID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = 0.0;
                String resultado = textViewUltimaExpressao.getText().toString();
                if (resultado.length() > 0) {
                    resultado = resultado.substring(0, resultado.length() - 1);
                    textViewUltimaExpressao.setText(resultado);
                }
            }
        });

        buttonZeroID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("0");
            }
        });

        buttonUmID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("1");
            }
        });

        buttonDoisID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("2");
            }
        });

        buttonTresID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("3");
            }
        });

        buttonQuatroID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("4");
            }
        });

        buttonCincoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("5");
            }
        });

        buttonSeisID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("6");
            }
        });

        buttonSeteID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("7");
            }
        });

        buttonOitoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("8");
            }
        });

        buttonNoveID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.append("9");
            }
        });



    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonIgualID) {
            String expressao = textViewUltimaExpressao.getText().toString();
            try {
                Calculable calc = new ExpressionBuilder(expressao).build();
                resultado = calc.calculate();
                textViewResultado.setText(resultado.toString());
            } catch (Exception e) {
                Log.e(TAG, "ERRO!! Incapaz de avaliar a expressão: " + expressao, e);
                textViewResultado.setText("Erro");
            }
        }
    }


}
