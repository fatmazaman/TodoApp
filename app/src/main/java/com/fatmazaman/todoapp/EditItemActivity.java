package com.fatmazaman.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.id.edit;

public class EditItemActivity extends AppCompatActivity {
    String item;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        item = getIntent().getStringExtra("item");
        position = getIntent().getIntExtra("position",0);
        EditText etext = (EditText)findViewById(R.id.editText);
        etext.setText(item);
        etext.setSelection(etext.getText().length());
        etext.requestFocus();
    }

    public void onSubmit(View v) {
        EditText etItem = (EditText) findViewById(R.id.editText);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("item", etItem.getText().toString());
        data.putExtra("position", position);

        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}
