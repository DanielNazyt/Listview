package com.daniel.me.listview;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutput;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Me on 21/03/2018.
 */

public class fetchData extends AsyncTask <Void,Void,Void> {
    String data = "";
    String dataParsed ="";
    String singleParsed ="";
    @Override
    protected Void doInBackground(Void... voids) {


        try {
            URL url= new URL("https://api.jcdecaux.com/vls/v1/stations?contract=Dublin&apiKey=711f1aacd608731647100ceddf84c27718c7a92b");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line ="";
            while( line != null){
                line =bufferedReader.readLine();
                data = data + line;

            }

           JSONArray JA = new JSONArray(data);
            for (int i=0 ;i <JA.length(); i++){
               JSONObject JO = (JSONObject) JA.get(i);
               singleParsed = "Number:" + JO.get("number") + "\n"+
                       "Name:" + JO.get("name") + "\n"+
                       "Address:" + JO.get("address") + "\n"+
                       "Position:" + JO.get("position") + "\n";
               dataParsed = dataParsed + singleParsed  +"\n";

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
        com.daniel.me.listview.MainActivity.data.setText(this.dataParsed);
       // ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, dataParsed);

       // MainActivity.

    }
}
