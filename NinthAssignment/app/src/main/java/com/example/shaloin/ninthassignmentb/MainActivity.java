package com.example.shaloin.ninthassignmentb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button save_button;
    ByteArrayOutputStream byteArrayOutputStream;
    FileOutputStream fileoutputstream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save_button=(Button)findViewById(R.id.saveButtonID);
    }

    public void save(View v){
        byteArrayOutputStream=new ByteArrayOutputStream();

        Drawable drawable = getResources().getDrawable(R.drawable.add);

        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();

        bitmap.compress(Bitmap.CompressFormat.PNG, 60, byteArrayOutputStream);

        File file = new File( Environment.getExternalStorageDirectory() + "/SampleImage.png");

        try

        {
            file.createNewFile();

            fileoutputstream = new FileOutputStream(file);

            fileoutputstream.write(byteArrayOutputStream.toByteArray());

            fileoutputstream.close();

        }

        catch (Exception e)

        {

            e.printStackTrace();

        }
    }




}
