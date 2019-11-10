package com.example.ngdngcbovirss;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsyncTaskDocBao extends AsyncTask<String,Void,String> {

    Activity contextParent;

    public  AsyncTaskDocBao(Activity contextParent){
        this.contextParent = contextParent;
    }

    @Override
    protected String doInBackground(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            URL url = new URL(strings[0]);

            URLConnection urlConnection = url.openConnection();

            InputStream inputStream = urlConnection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //  viet gop  3dong tren thanh InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line = "";

            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line+"\n");
            }
            bufferedReader.close();     //dong lai

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        XMLDOMParser parser = new XMLDOMParser();
        Document document = parser.getDocument(s);
        NodeList nodeListitem = document.getElementsByTagName("item");
        NodeList nodeListdescription = document.getElementsByTagName("description");

        String hinhanh= "";
        String title = "";
        String link = "";
        String ngaydang = "";
        for (int i=0;i<nodeListitem.getLength();i++){
            String cdata = nodeListdescription.item(i+1).getTextContent();
            //Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");        // regex k dung
            Pattern p = Pattern.compile("\\< *[img][^\\>]*[src] *= *[\\\"\\']{0,1}([^\\\"\\'\\ >]*)");
            Matcher matcher = p.matcher(cdata);
            if (matcher.find()){
                hinhanh = matcher.group(1);         // phai de o nhom 1. neu de so khac se sai
            }

            Element element = (Element) nodeListitem.item(i);
            title = parser.getValue(element,"title");        // title, pubDate, link la cac ten the can lay .
            ngaydang = parser.getValue(element,"pubDate");   //dien dung ten the. neu sai thi se k lay dc
            link = parser.getValue(element,"link");
            MainActivity.arrayNews.add(new News(hinhanh,title,ngaydang));
            MainActivity.arrayLink.add(link);
            Log.d("hinh anh",hinhanh+"....."+i);
        }
        MainActivity.adapter.notifyDataSetChanged();
    }
}

