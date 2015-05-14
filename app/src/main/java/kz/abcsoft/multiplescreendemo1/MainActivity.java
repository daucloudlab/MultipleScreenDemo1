package kz.abcsoft.multiplescreendemo1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements TitlesFragment.onItemClickListener {

    int position = 0;

    @Override
    public void itemClick(int position) {
        this.position = position;
        showDetails(position);
    }

    void showDetails(int pos) {
        DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.cont);
        if (details == null || details.getPosition() != pos) {
            details = DetailsFragment.newInstance(pos);
            getFragmentManager().beginTransaction().replace(R.id.cont, details).commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
            position = savedInstanceState.getInt("position");
        showDetails(position);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
