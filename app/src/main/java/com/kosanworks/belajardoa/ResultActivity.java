package com.kosanworks.belajardoa;

/**
 * Created by novan on 31/12/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_final);
        TextView r=(TextView)findViewById(R.id.result);
//        TextView t=(TextView)findViewById(R.id.textResult);
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
            r.setText(String.valueOf("Nilai kamu : \n        "  +score));
//        switch (score)
//        {
//            case 20: t.setText("Belajar lebih Giat lagi");
//                break;
//            case 40: t.setText("Kamu Pasti Bisa");
//                break;
//            case 60: t.setText("Baca lebih giat lagi");
//                break;
//            case 80: t.setText("Semangat Sedikit Lagi ");
//                break;
//            case 100: t.setText("Sempurna Kamu Hebat ");
//                break;
//        }
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_result, menu);
//        return true;
//    }
@Override
public void onBackPressed() {
    super.onBackPressed();
    startService(new Intent(this, AudioService.class));
}
}