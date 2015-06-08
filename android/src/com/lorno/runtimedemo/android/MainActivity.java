package com.lorno.runtimedemo.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnCard;
    private Button btnTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btnCard = (Button) findViewById(R.id.btnCard);
        btnTimer = (Button) findViewById(R.id.btnTimer);

        btnCard.setOnClickListener(this);
        btnTimer.setOnClickListener(this);
    }

    @Override
     public void onClick(View v) {
        Intent game = new Intent(getApplicationContext(), AndroidLauncher.class);
        switch(v.getId()) {
            case R.id.btnCard:
                game.putExtra("type", "card");
                startActivity(game);
                break;
            case R.id.btnTimer:
                game.putExtra("type", "timer");
                startActivity(game);
                break;
            default:
                break;
        }
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
