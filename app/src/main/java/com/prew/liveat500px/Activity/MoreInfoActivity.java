package com.prew.liveat500px.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.prew.liveat500px.DAO.PhotoItemDao;
import com.prew.liveat500px.Fragment.MoreInfoFragment;
import com.prew.liveat500px.R;

public class MoreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        iniInstances();

        PhotoItemDao dao = getIntent().getParcelableExtra("dao");

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container, MoreInfoFragment.newInstance(dao))
                    .commit();
        }
    }

    private void iniInstances() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
