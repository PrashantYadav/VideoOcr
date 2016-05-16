package edu.sfsu.cs.orange.ocr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prashant Yadav on 12-May-16.
 */
public class StartScreen extends Activity {

    Spinner sp_source_language;
    Spinner sp_target_language;
    String code_source, code_target;
    ImageButton imb;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.startscreen);
        additemtosp1();
        additemtosp2();

        imb = (ImageButton)findViewById(R.id.img_button_startscreen);

        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CaptureActivity.class);
                intent.putExtra("code_source",code_source);
                intent.putExtra("code_target",code_target);
                startActivity(intent);
            }
        });

        sp_source_language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        code_source = "eng";
                        break;
                    case 1:
                        code_source = "fra";
                        break;
                    case 2:
                        code_source = "deu";
                        break;
                    case 3:
                        code_source = "spa";
                        break;
                    case 4:
                        code_source = "hin";
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                code_source = "en";
            }
        });

        sp_target_language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        code_target = "es";
                        break;
                    case 1:
                        code_target = "fr";
                        break;
                    case 2:
                        code_target = "en";
                        break;
                    case 3:
                        code_target = "de";
                        break;
                    case 4:
                        code_target = "hi";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                code_target = "hi";
            }
        });

    }

    private void additemtosp1() {
        sp_source_language = (Spinner)findViewById(R.id.sp_source_language);
        List<String> list = new ArrayList<String>();
        list.add("English");
        list.add("French");
        list.add("German");
        list.add("Spanish");
        list.add("Hindi");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Log.e("called",""+sp_source_language);
        sp_source_language.setAdapter(dataAdapter);
    }

    private void additemtosp2() {
        sp_target_language = (Spinner)findViewById(R.id.sp_target_language);
        List<String> list = new ArrayList<String>();
        list.add("Spanish");
        list.add("French");
        list.add("English");
        list.add("German");
        list.add("Hindi");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_target_language.setAdapter(dataAdapter);
    }


}
