package info.pauek.countrylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseCountryActivity extends AppCompatActivity {

    public static final int CHOOSE_COUNTRY = 0;
    private TextView country_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_country);

        country_view = findViewById(R.id.country_view);

        Button btn_choose = findViewById(R.id.btn_choose);
        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cridem CountryListActivity _esperant_ un resultat
                Intent intent = new Intent(ChooseCountryActivity.this, CountryListActivity.class);
                startActivityForResult(intent, CHOOSE_COUNTRY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            /* Recollim el resultat d'haver cridat a CountryListActivity */
            case CHOOSE_COUNTRY:
                if (resultCode == RESULT_OK) {
                    String country = data.getStringExtra("country");
                    country_view.setText(country);
                }
                break;

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
