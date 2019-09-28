/*
package pk.edu.ity.fall2019.lecture.newsapp;

import android.os.AsyncTask;
import android.util.Log;
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

import javax.net.ssl.HttpsURLConnection;

public class fetchData2 extends AsyncTask<Void, Void, Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";

    String[] titles_arr = new String[7];

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://newsapi.org/v2/top-headlines?q=Apple&apiKey=677a2c4f7faa4b6699b97be91d80f94f");
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
            for (int i = 0; i < textArray.length(); i++)
            {
                JSONObject jj = textArray.getJSONObject(i);
                //dataParsed = dataParsed + jj.get("title")+ "\n";
                titles_arr[i] = ""+ jj.get("title");


            }



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
        //MainActivity.r.setText(this.data);
        activity2.d.setText(this.dataParsed);











    }
}
*/
