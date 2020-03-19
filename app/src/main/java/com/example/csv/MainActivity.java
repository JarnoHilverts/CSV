package com.example.csv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    public static final String FILE_NAME = "data.csv";

    private DoppleSaveCSV doppleSaveCSVFile;
    private DoppleLoadCSV doppleLoadCSVFile;
    private DoppleExportCSV doppleExportCSVFile;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Zorgt ervoor dat de buttons worden gevonden
        Button buttonSave = findViewById(R.id.button_save);
        Button buttonLoad = findViewById(R.id.button_load);
        Button buttonExport = findViewById(R.id.button_export);

        //Onclick voor de button om de funtie in DoppleSaveCSV.java
        doppleSaveCSVFile = new DoppleSaveCSV(this);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    doppleSaveCSVFile.saveToFile();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //Onclick voor de button om de funtie in DoppleLoadCSV.java
        doppleLoadCSVFile = new DoppleLoadCSV(this);
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doppleLoadCSVFile.load();
            }
        });

        //Onclick voor de button om de funtie in DoppleExportCSV
        doppleExportCSVFile = new DoppleExportCSV(this);
        buttonExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doppleExportCSVFile.export();
            }
        });
    }

}


