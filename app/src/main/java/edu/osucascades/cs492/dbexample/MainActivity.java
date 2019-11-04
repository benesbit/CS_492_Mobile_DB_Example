package edu.osucascades.cs492.dbexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnStore;
    private Button btnGetAll;
    private EditText enterName;
    private DatabaseHelper databaseHelper;
    private TextView listOfNames;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        listOfNames = findViewById(R.id.listOfNames);

        btnStore = findViewById(R.id.buttonstore);
        btnGetAll = findViewById(R.id.buttonget);
        enterName = findViewById(R.id.entername);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(enterName.getText().toString());
                enterName.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = databaseHelper.getAllStudentsList();
                listOfNames.setText("");

                for (int i = 0; i < arrayList.size(); i++){
                    //listOfNames.setText(listOfNames.getText().toString() + ", " + arrayList.get(i));

                    listOfNames.setText(arrayList.get(i) + "\n" + listOfNames.getText().toString());
                }
            }
        });

    }
}
