package com.example.csv;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;

import java.io.File;


public class DoppleExportCSV
{
    private AppCompatActivity mainActivity;

    public DoppleExportCSV(AppCompatActivity ac)
    {
        this.mainActivity = ac;
    }

    public void export()
    {

        File shareBody = new File(mainActivity.getFilesDir(), MainActivity.FILE_NAME);
        Uri path = FileProvider.getUriForFile(mainActivity, "com.example.csv.fileprovider", shareBody);
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/csv");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Data");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, path);
        sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        mainActivity.startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }
}
