package com.nof.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


/**
 * Created by Administrator on 2017/12/5.
 */

public class JsApi extends Object {

    private static final String BASE_URL = "https://api.douban.com/v2/movie/in_theaters";

    @JavascriptInterface
    public String getMovieList(){
        String result = "";
        URLConnection conn;
        BufferedReader in = null;
        try {
            URL url = new URL(BASE_URL);
            conn = url.openConnection();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null){
                result += line;
            }
            Log.e("wqf",result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
