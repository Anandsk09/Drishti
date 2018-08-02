package com.example.newpc.drishti;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.newpc.drishti.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    Button gen, scan,about;
    private Button scan_btn;
    private Button save_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gen = (Button) findViewById(R.id.gen);
        scan = (Button) findViewById(R.id.scan);
        about=(Button) findViewById(R.id.about);
        final Activity activity = this;
        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gIntent = new Intent(MainActivity.this, GeneratorActivity.class);
                startActivity(gIntent);
            }
        });
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    IntentIntegrator integrator = new IntentIntegrator(activity);
                    integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                    integrator.setPrompt("Don't place Scanner too close to the QR-Code");
                    integrator.setCameraId(0);
                    integrator.setOrientationLocked(false);
                    integrator.setBeepEnabled(true);
                    integrator.setBarcodeImageEnabled(false);
                    integrator.initiateScan();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aIntent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {

                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("dataInfo",result.getContents().toString());
                startActivity(intent);
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
