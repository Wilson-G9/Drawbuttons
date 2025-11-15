package com.example.drawbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edtNumber;
    Button btnDraw;
    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumber = findViewById(R.id.edtNumber);
        btnDraw = findViewById(R.id.btnDraw);
        table = findViewById(R.id.tableLayout);
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table.removeAllViews();
                String text = edtNumber.getText().toString();
                if (text.isEmpty()) return;

                int n = Integer.parseInt(text);
                Random rd = new Random();
                for (int i = 1; i <= n; i++) {
                    if (i % 2 == 1) {
                        TableRow row = new TableRow(MainActivity.this);
                        row.setPadding(0, 10, 0, 10);
                        Button leftBtn = new Button(MainActivity.this);
                        leftBtn.setText(String.valueOf(rd.nextInt(101)));
                        leftBtn.setBackgroundColor(0xFFD0D0D0);
                        leftBtn.setGravity(Gravity.CENTER);
                        row.addView(leftBtn);
                        if (i == n) {
                            TextView empty = new TextView(MainActivity.this);
                            row.addView(empty);
                        }
                        table.addView(row);
                    } else {
                        TableRow lastRow = (TableRow) table.getChildAt(table.getChildCount() - 1);
                        Button rightBtn = new Button(MainActivity.this);
                        rightBtn.setText(String.valueOf(rd.nextInt(101)));
                        rightBtn.setBackgroundColor(0xFFD0D0D0);
                        rightBtn.setGravity(Gravity.CENTER);
                        lastRow.addView(rightBtn);
                    }
                }
            }
        });
    }
}
