package com.example.co5025.week09;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button[] buttons = new Button[10];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button newGameButton = (Button) findViewById(R.id.new_game);
        newGameButton.setOnClickListener(this);

        buttons[1] = (Button) findViewById(R.id.one);
        buttons[2] = (Button) findViewById(R.id.two);
        buttons[3] = (Button) findViewById(R.id.three);
        buttons[4] = (Button) findViewById(R.id.four);
        buttons[5] = (Button) findViewById(R.id.five);
        buttons[6] = (Button) findViewById(R.id.six);
        buttons[7] = (Button) findViewById(R.id.seven);
        buttons[8] = (Button) findViewById(R.id.eight);
        buttons[9] = (Button) findViewById(R.id.nine);

        for (int i = 1; i <= 9 ; i++) {
            buttons[i].setOnClickListener(this);
        }
        clearGrid();
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                makeMove(1);
                respond();
                break;
            case R.id.two:
                makeMove(2);
                break;
            case R.id.three:
                makeMove(3);
                break;
            case R.id.four:
                makeMove(4);
                break;
            case R.id.five:
                makeMove(5);
                break;
            case R.id.six:
                makeMove(6);
                break;
            case R.id.seven:
                makeMove(7);
                break;
            case R.id.eight:
                makeMove(8);
                break;
            case R.id.nine:
                makeMove(9);
                break;
            case R.id.new_game:
                clearGrid();
                break;
        }
    }

    public void clearGrid() {
        for(int i = 1; i <= 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
    }

    public void makeMove(int i){
        buttons[i].setText("X");
        buttons[i].setEnabled(false);
    }
    public void respond(){
        for (int i = 1; i <= 9; i++) {
            if (buttons[i].isEnabled()) {
                buttons[i].setText("O");
                buttons[i].setEnabled(false);
                break;
            }
        }
    }
}
