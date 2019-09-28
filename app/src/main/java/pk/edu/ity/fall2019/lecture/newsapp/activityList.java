package pk.edu.ity.fall2019.lecture.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
import java.util.ArrayList;

import static pk.edu.ity.fall2019.lecture.newsapp.MainActivity.API_KEY;
import static pk.edu.ity.fall2019.lecture.newsapp.MainActivity.API_URL;

public class activityList extends AppCompatActivity {

    ListView listView;
    String data = "";
    String dataParsed = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        final String egf = "country="+ getIntent().getStringExtra("EdiTtEXTvALUE");

        final String ehf = "country=us&category=" + getIntent().getStringExtra("fads");



        listView = findViewById(R.id.listview);
        final ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("News 1");
        arrayList.add("News 2");
        arrayList.add("News 3");
        arrayList.add("News 4");
        arrayList.add("News 5");
        arrayList.add("News 6");
        arrayList.add("News 7");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        data = "";
        dataParsed = "";

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                if (egf != "country=")
                {

                    fetchData f1 = new fetchData(i, egf);
                    f1.execute();

                    Intent c = new Intent(getApplicationContext(), activity2.class);
                    startActivity(c);



                }

                if (ehf != "country=us&category=")
                {




                    fetchData f2 = new fetchData(i, ehf);
                    f2.execute();
                    Intent d = new Intent(getApplicationContext(), activity2.class);
                    startActivity(d);
                }





            }


        });

    }






    class fetchData extends AsyncTask<Void, Void, Void> {
        private final int a;
        private final String b;
        String data = "";
        String dataParsed = "";
        String singleParsed = "";

        public fetchData(int a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {

                URL url = new URL("http://newsapi.org/v2/top-headlines?" + b +"&apiKey=677a2c4f7faa4b6699b97be91d80f94f");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));
                String line = "";
                while (line != null){
                    line = bufferedReader.readLine();
                    data = data + line;
                }

                //JSONArray JA = new JSONArray(data);
                JSONObject wholeObject = new JSONObject(data);
                JSONArray textArray = wholeObject.getJSONArray("articles");
                 JSONObject jj = textArray.getJSONObject(a);
                 dataParsed = "Category: " + b + "\n";
                 dataParsed = dataParsed + "Author name: " + jj.get("author") + "\n";
                 dataParsed = dataParsed + "News number: "  + a + "\n";
                 dataParsed = dataParsed + "Title " + jj.get("title")+ "\n";
                 dataParsed = dataParsed + "    " + jj.get("content") + jj.get("description")+ "\n";
                dataParsed = dataParsed + "Source: " + jj.get("url") +"\n";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            activity2.d.setText(this.dataParsed);


        }
    }











}
