package com.thirdreich.db.util;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.thirdreich.db.R;

public class MainActivity extends ActionBarActivity {
Button but1,but2;
    private static final String TAG="DB";
    private int i=0;
    private  float out=-1000f,out1=+1000f,nul=0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1=(Button)findViewById(R.id.button1);
        but2=(Button)findViewById(R.id.button2);
        Log.i(TAG,"Oncreate");
    }

public void modifydb(View view){

    Log.i(TAG,"modifydb Button clicked");
    aniMate(but1);
    aniMate1(but2);
    i=1;
    new LongOperation().execute("");

    }
    public void viewdb(View view){
        Log.i(TAG,"view Button clicked");
i=2;
        aniMate(but1);
        aniMate1(but2);
        Intent viewdb=new Intent(MainActivity.this, viewdb.class);
        startActivity(viewdb);




    }
    private class LongOperation extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
                          try {
                    Thread.sleep(1000);


                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            if(i==2)
            {Intent viewdb=new Intent(MainActivity.this, viewdb.class);
                startActivity(viewdb);

            }else{
                Intent modifydb=new Intent(MainActivity.this, modifydb.class);
                startActivity(modifydb);
            }
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i(TAG,"onPostResume");
      setContentView(R.layout.activity_main);
        }

    public void aniMate(Button b){
        Log.i(TAG,"aniMate but1");
        ObjectAnimator animY = ObjectAnimator.ofFloat(b, "translationX",0f,-1000f);
        animY.setDuration(1000);
       animY.setRepeatCount(0);
        animY.start();}
    public void aniMate1(Button b){
        Log.i(TAG,"aniMate but2");
        ObjectAnimator animY = ObjectAnimator.ofFloat(b, "translationX",0f,1000f);
        animY.setDuration(1000);
        animY.setRepeatCount(0);
        animY.start();}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
