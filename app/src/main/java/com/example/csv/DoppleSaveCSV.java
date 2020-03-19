package com.example.csv;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DoppleSaveCSV
{
    private AppCompatActivity mainActivity;
    private EditText mEditText;

    /**
     * Zorgt ervoor dat je parameters van de Main kunnen worden gebruikt.
     * @param ac context reference
     */
    public DoppleSaveCSV(AppCompatActivity ac)
    {
        this.mainActivity = ac;
        mEditText = this.mainActivity.findViewById(R.id.edit_text);
    }

    /**
     * De data die wordt aangemaakt in de functie, moet nog worden aangepast naar de juiste data.
     * Dit is hardcoded data. Er wordt een timestamp aan de file toegevoegd. Uiteindelijk wordt de data in data.csv opgeslagen.
     * @throws InterruptedException zorgt ervoor dat er een interupt is tijdens de loop.
     */
    public void saveToFile() throws InterruptedException
    {
        //generate data
        StringBuilder data = new StringBuilder();
        data.append("X,Y,Z,GPS,Timestamp");
        //loop voor de hardcoded data die wordt aangemaakt in de loop.
        for (int i = 0; i < 5; i++)
        {
            Long currentTime = System.currentTimeMillis();
            data.append("\n" + i + "," + i * i + "," + (i + i) + "," + (i+i+i)*i + "," + currentTime);
            TimeUnit.SECONDS.sleep(1);
        }

        FileOutputStream fos = null;
        try
        {
            //saving the file into device
            fos = this.mainActivity.openFileOutput(MainActivity.FILE_NAME, Context.MODE_PRIVATE);
            fos.write(data.toString().getBytes());
            mEditText.getText().clear();
            Toast.makeText(this.mainActivity, "Saved to" + mainActivity.getFilesDir() + "/" + MainActivity.FILE_NAME, Toast.LENGTH_LONG).show();
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
            if (fos != null)
            {
                try
                {
                    fos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
