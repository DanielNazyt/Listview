package com.daniel.me.listview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
public class MainActivity extends AppCompatActivity {

 Button btnList;
   public  static TextView data;

   //ListView list;

   // ArrayList<String> title_array = new ArrayList<String>();
    //ArrayList<String> notice_array = new ArrayList<String>();

    //DisplayList displayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //resultListView = (ListView) findViewById(R.id.resultListView);

        btnList = (Button) findViewById(R.id.btnList);
        data = (TextView) findViewById(R.id.data);
       // list = (ListView) findViewById(R.id.list);

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DisplayList.class);
                startActivity(intent);

            }
        });



    }
}
