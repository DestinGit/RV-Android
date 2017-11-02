package db.fr.rv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SmsEnvoyer extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextTelephone;
    private EditText editTextMessage;
    private Button buttonEnvoyer;
    private TextView textViewMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_envoyer);

        editTextTelephone = (EditText)findViewById(R.id.editTextTelephone);
        editTextMessage = (EditText)findViewById(R.id.editTextMessage);
        buttonEnvoyer = (Button)findViewById(R.id.buttonEnvoyer);
        textViewMessage = (TextView) findViewById(R.id.textViewMessage);

        buttonEnvoyer.setOnClickListener(this);

        // EN TEST
        editTextTelephone.setText("1-555-521-5556");
        editTextMessage.setText("Bonne nuit les petits !!!");

    } /// onCreate

    @Override
    public void onClick(View v) {
        String numero = editTextTelephone.getText().toString();
        String message = editTextMessage.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(numero, null, message, null, null);
        textViewMessage.setText("SMS envoyé !!!");
    } /// onClick
}
