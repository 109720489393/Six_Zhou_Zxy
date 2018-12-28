package com.example.windows_zxy.six_day3_test.netWrok;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyAsyncTask<T> extends AsyncTask<T,T,String> {
    private String url1;
    private String med;
    private StringBuilder builder;
    private DataGet dataGet;

    public MyAsyncTask(String url1, String med) {
        this.url1 = url1;
        this.med = med;
    }

    public AsyncTask MyAsyncTask(DataGet dataGet) {
        this.dataGet = dataGet;
        return this;
    }

    @Override
    protected String doInBackground(T... ts) {
        try {
            URL url = new URL(url1);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setRequestMethod(med);
            connection.setConnectTimeout(5000);
            InputStream input = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(input,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String str = "";
            builder = new StringBuilder();
            while ((str=bufferedReader.readLine())!=null){
                builder.append(str);
            }
            connection.disconnect();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        dataGet.setDataTrue(s);
    }

    public interface DataGet{
        public void setDataTrue(String data);
    }
}

