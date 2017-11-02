package db.fr.rv;

import android.content.Intent;
import android.net.Uri;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ReconnaissanceVocale extends AppCompatActivity implements View.OnClickListener{

    private Button buttonDemarrerCommandeVocale;
    private ListView listViewMots;
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reconnaissance_vocale);

        buttonDemarrerCommandeVocale = (Button) findViewById(R.id.buttonDemarrerCommandeVocale);
        listViewMots = (ListView) findViewById(R.id.listViewMots);

        buttonDemarrerCommandeVocale.setOnClickListener(this);
    } /// onCreate


    @Override
    public void onClick(View v) {
        demarrageReconnaissance();
    } /// onClick


    /**
     * Fire an intent to start the voice recognition activity.
     */
    private void demarrageReconnaissance() {
        try {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Démonstration ...");
            startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
        } catch (Exception e) {
            Log.e("VoiceRecognition", e.getMessage());
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://market.android.com/details?id=APP_PACKAGE_NAME"));
            startActivity(browserIntent);
        }
    } /// startVoiceRecognitionActivity


    /**
     * Handle the results from the voice recognition activity.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            // Remplit la liste de mots que le moteur de reconnaissance reconnait
            List<String> listeMots = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            listViewMots.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listeMots));
        }
        super.onActivityResult(requestCode, resultCode, data);
    } /// onActivityResult
}
