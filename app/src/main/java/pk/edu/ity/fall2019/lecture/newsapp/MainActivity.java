package pk.edu.ity.fall2019.lecture.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public static TextView r;
    Button b;
    Button b2;
    EditText reg;
    EditText top;



    public static final String API_KEY = "&apiKey=677a2c4f7faa4b6699b97be91d80f94f";
    public static final String API_URL = "http://newsapi.org/v2/top-headlines?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            r = findViewById(R.id.sss);
            b = findViewById(R.id.button1);
            b2 = findViewById(R.id.button2);
            reg = findViewById(R.id.editText);
            top = findViewById(R.id.editText2);
            b.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    //fetchData process = new fetchData();
                    //process.execute();
                    Intent i = new Intent(getApplicationContext(), activityList.class);
                    i.putExtra("EdiTtEXTvALUE", reg.getText().toString() + "");
                    startActivity(i);


                }// onclickview
            }); //listener b




            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent j = new Intent(getApplicationContext(), activityList.class);
                    j.putExtra("fads", top.getText().toString() + "");
                    startActivity(j);

                }


            });
        }


}














