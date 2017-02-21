package com.example.ekam1.cbc_xml;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.net.URL;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    //1 for now declare a Vector of strings to hold headlines
    //2 think about where to put this in your actual workshop
    Vector<String> headlines = new Vector<String>();

    //5
    private class DownloadFilesTask extends AsyncTask<URL, Integer, Long>{
        // alt-enter on method name add methods

        @Override
        protected Long doInBackground(URL... params) {
            int count = params.length; //how many urls we have to process
            long totalSize = 0;
            //loop to download each file
            for(int i=0; i<count; i++){
                //6 download the file
                //call a function to download the file
                totalSize += downloadFile(params[i]);
            }
            return null;
        }

        //8 fill these placeholders later for more functionality
        //called by the framework, periodically, to provide updates on how the task is progressing
        protected void onProgressUpdate(Integer... progress){
            System.out.println("progress: "+ progress[0]);
        }

        //called by the framework once the task finishes
        protected void onPostExecute(Long result){
            //once finished all we do here is print out the headlines
            //you will extend this to refresh any views (if necessary)
            System.out.println("downloaded " + result + " files");
            for(String headline: headlines){ //foreach headline in headlines
                System.out.println("headline: " + headline);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3 declare a URL object used to point to the xml resource
        URL url = null;
        try {
            url = new URL("http://www.cbc.ca/cmlink/rss-topstories.xml");
        }catch (Exception e){
            Log.d("An exception happened", e.getMessage());
        }

        //4 use a custom AsynceTask to download and process the xml resource
        new DownloadFilesTask().execute(url);


    }

    //7 TODO: finish this method
    public long downloadFile(URL url){
        return 0;
    }

}
