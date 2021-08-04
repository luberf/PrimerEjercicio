package com.example.yisela.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private Button resul;
    private EditText numero1;
    private EditText numero2;
    private EditText numero3;
    String texto1;
    String texto2;
    String texto3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resul = findViewById(R.id.btn);
        resul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numero1 = findViewById(R.id.editTextNumber1);
                texto1 = numero1.getText().toString();
                numero2 = findViewById(R.id.editTextNumber2);
                texto2 = numero2.getText().toString();
                numero3 = findViewById(R.id.editTextNumber3);
                texto3 = numero3.getText().toString();

                int primernumero = Integer.parseInt(texto1);
                int segundonumero = Integer.parseInt(texto2);
                int tercernumero = Integer.parseInt(texto3);

                int [] a  = {primernumero,segundonumero,tercernumero};
                int temporal = 0;

                for (int i = 0; i < a.length; i++) {
                    for (int j = 1; j < (a.length - i); j++) {
                        if (a[j - 1] > a[j]) {
                            temporal = a[j - 1];
                            a[j - 1] = a[j];
                            a[j] = temporal;
                        }
                    }
                }
                TextView rep = findViewById(R.id.respuesta);
                rep.setText(Arrays.toString(a));

                onButtonShowPopupWindowClick(view);
            }
        });

    }
    public void onButtonShowPopupWindowClick(View view) {

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}