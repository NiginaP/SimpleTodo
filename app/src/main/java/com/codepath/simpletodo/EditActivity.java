package com.codepath.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit Item");

        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create an intent which will contain the results
                Intent i = new Intent();

                //pass the data(results of editing)
                i.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                i.putExtra(MainActivity.KEY_ITEM_POS, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POS));

                //set the result of intent
                setResult(RESULT_OK, i);

                //finish activity, close the screen and go back
                finish();
            }
        });
    }
}
