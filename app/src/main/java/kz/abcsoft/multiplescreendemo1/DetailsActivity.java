package kz.abcsoft.multiplescreendemo1;

import android.app.Fragment;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class DetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            DetailsFragment details = DetailsFragment.newInstance(getIntent().getIntExtra("position", 0));
            getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
    }
}
