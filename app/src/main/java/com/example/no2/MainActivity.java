package com.example.no2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.file.AtomicMoveNotSupportedException;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText ANSheight;
    EditText ANSweight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ANSheight = (EditText)findViewById(R.id.height);
        ANSweight = (EditText)findViewById(R.id.weight);
        Button submit = (Button)findViewById(R.id.Operation);

        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {

                if ( !("".equals(ANSheight.getText().toString())
                        || "".equals(ANSweight.getText().toString())) )
                {
                    float fh = Float.parseFloat(ANSheight.getEditableText().toString());
                    float fw = Float.parseFloat(ANSweight.getEditableText().toString());
                    float fresult;
                    TextView result = (TextView)findViewById(R.id.Ans);
                    fh = fh*fh;

                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(2);
                    fresult = fw/fh;
                    result.setText(nf.format(fw/fh) +"");
                    TextView dia = (TextView)findViewById(R.id.Ans);

                    // 診斷結果 顯示
                    if (fresult<18.5)
                        dia.setText("您的BMI職為："+fresult+"體重過輕");
                    else if (18.5 <= fresult && fresult< 24)
                        dia.setText("您的BMI職為："+fresult+"正常範圍");
                    else if (24 <=fresult && fresult < 27)
                        dia.setText("您的BMI職為："+fresult+"過重");
                    else if (27 <=fresult && fresult < 30)
                        dia.setText("您的BMI職為："+fresult+"輕度肥胖");
                    else if (30 <= fresult && fresult < 35)
                        dia.setText("您的BMI職為："+fresult+"中度肥胖");
                    else if (fresult >= 35)
                        dia.setText("您的BMI職為："+fresult+"重度肥胖");
                }
            }
        });
    }
}
