package com.hawk.opensms;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{
    public Button buttonSend;
    public EditText textPhoneNo;
    public EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSend = findViewById(R.id.buttonSend);
        textPhoneNo = findViewById(R.id.textPhoneNo);
        editText = findViewById(R.id.editText);

        buttonSend.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String number = textPhoneNo.getText().toString();
                String sms = editText.getText().toString();
                try
                {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "Sent.",
                    Toast.LENGTH_LONG).show();
                    editText.setText("");
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),
                    "Failed, try again.",
                    Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
