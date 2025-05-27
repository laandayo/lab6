package com.example.lab6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_layout);

        final EditText editValue = (EditText) findViewById(R.id.value_edit);
        final Button sendButton = (Button) findViewById(R.id.send_button);
        final Button calculatorButton = (Button) findViewById(R.id.calculator_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String valueString = editValue.getText().toString();
                long value;
                if (valueString != null && !valueString.isEmpty()) {
                    value = Long.parseLong(valueString);
                } else {
                    value = 0;
                }
                Bundle sendBundle = new Bundle();
                sendBundle.putLong("value", value);
                Intent i = new Intent(Activity1.this, Activity2.class);
                i.putExtras(sendBundle);
                startActivity(i);
                finish();
            }
        });

        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this, CalActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}