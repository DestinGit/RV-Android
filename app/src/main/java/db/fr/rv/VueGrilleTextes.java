package db.fr.rv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class VueGrilleTextes extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView textViewChoixGrille;
    private GridView grille;
    private String[] items = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_grille_textes);

        // --- Liaisons avec les widgets du layout
        textViewChoixGrille = (TextView) findViewById(R.id.textViewChoixGrille);
        grille = (GridView) findViewById(R.id.gridView2colonnes);

        grille.setOnItemClickListener(this);

        // --- Remplissage de la grille
        // --- ArrayAdapter<String>(Context, TextViewRessourceID, tableau)
        grille.setAdapter(new ArrayAdapter<String>(this, R.layout.cellule_texte, items));

    } // / onCreate

    @Override
    public void onItemClick(AdapterView<?> adapter, View vue, int position, long id) {
        textViewChoixGrille.setText(adapter.getItemAtPosition(position).toString());
    } // / onItemClick
}
