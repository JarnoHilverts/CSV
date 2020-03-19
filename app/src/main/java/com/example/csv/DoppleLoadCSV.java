package com.example.csv;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoppleLoadCSV
{
    private AppCompatActivity mainActivity;
    private EditText mEditText;

    /**
     * Zorgt ervoor dat je parameters van de Main kunnen worden gebruikt.
     * @param ac context reference
     */
    public DoppleLoadCSV(AppCompatActivity ac)
    {
        this.mainActivity = ac;
        mEditText = this.mainActivity.findViewById(R.id.edit_text);
    }

    /**
     * Deze functie haalt de data die in de file data.csv op.
     * Hierna wordt deze data weergegven in de textfield.
     */
    public void load()
    {
        FileInputStream fis = null;

        try
        {
            fis = this.mainActivity.openFileInput(MainActivity.FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            //Zolang er data in de CSV file zit wordt deze per regel weergegeven
            while ((text = br.readLine()) != null)
            {
                sb.append(text).append("\n");
            }

            mEditText.setText(sb.toString());

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fis != null)
            {
                try
                {
                    fis.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}