package com.Adam.kanyamakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.icu.text.Transliterator;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        TextView textView = (TextView)findViewById(R.id.textView);
        //TODO  عموان البرنامج واليست فسو ^^

        String[] itme = getResources().getStringArray(R.array.index);
        ArrayAdapter  arrayAdapter = new ArrayAdapter<String>(this,R.layout.row_itme,R.id.text_itme,itme);
        listView.setAdapter(arrayAdapter);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"font.otf");
        textView.setTypeface(typeface);

        //TODO HTML- MAIN ACTVVITE
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,Wephtml.class);
                intent.putExtra("page",i);
                startActivity(intent);
            }
        });


    }
    public void email (View view) {
        try {


            String txt = "السلام وعليكم ورحمة الله وبركاته \n اقتراحي هو :";
            Intent emails = new Intent(Intent.ACTION_SEND);
            emails.setData(Uri.parse("mailto"));
            emails.setType("massage/rfc822");
            emails.putExtra(Intent.EXTRA_EMAIL, "adamalwan450@gmail.com");
            emails.putExtra(Intent.EXTRA_SUBJECT, "نطبيق كان ياما كان");
            emails.putExtra(Intent.EXTRA_TEXT, txt);
            startActivity(emails);
        } catch (Exception e)
        {
            Toast.makeText(this,"عذرا لا يوجد تطبيق بريد",Toast.LENGTH_LONG).show();
        }

//        Intent emails = new Intent(Intent.ACTION_VIEW);
//        emails.setData(Uri.parse("https://ar-ar.facebook.com/adam.alazazi?hc_ref"));
//        startActivity(emails);

//        //      String textshe = "تطبيق كان ياما كان";
//        String sherlink = "https://ar-ar.facebook.com/adam.alazazi?hc_ref";
//        Intent sher = new Intent(Intent.ACTION_VIEW);
//         sher.setType("text/plain");
//        sher.putExtra(Intent.EXTRA_TEXT, +"\n" + sherlink);
//        startActivity(sher);
    }

    public void app (View view) {
         Intent apps = new Intent(Intent.ACTION_VIEW);
         apps.setData(Uri.parse("https://admins-soft.blogspot.com/"));
         startActivity(apps);
    }

    public void ontSher (View view) {
        String textshe = "تطبيق كان ياما كان";
        String link = "https://admins-soft.blogspot.com/";
        Intent sher = new Intent(Intent.ACTION_SEND);
        sher.setType("text/plain");
        sher.putExtra(Intent.EXTRA_TEXT,textshe +"\n" + link);
        startActivity(sher);


    }
    public void close (View view) {
        finish();

    }

}
//TODO FACEBOOK UURL
//sher.setData(Uri.parse("https://ar-ar.facebook.com/adam.alazazi?hc_ref"));