package com.example.co5025.week09;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Global Variables
    Button[] buttons = new Button[10];
    Animation animFadeIn;
    int count;
    int[] myImageArr = new int[]{R.drawable.cate1, R.drawable.cate1, R.drawable.connect1, R.drawable.connect1,
            R.drawable.connectpancake, R.drawable.connectpancake, R.drawable.connect4connect4, R.drawable.connect4connect4} ;
    //End of Global Variables

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

        //Buttons creation
        Button newGameButton = (Button) findViewById(R.id.new_game);
        newGameButton.setOnClickListener(this);
        randomize(myImageArr, myImageArr.length);
        buttons[1] = (Button) findViewById(R.id.one);
        buttons[2] = (Button) findViewById(R.id.two);
        buttons[3] = (Button) findViewById(R.id.three);
        buttons[4] = (Button) findViewById(R.id.four);
        buttons[5] = (Button) findViewById(R.id.five);
        buttons[6] = (Button) findViewById(R.id.six);
        buttons[7] = (Button) findViewById(R.id.seven);
        buttons[8] = (Button) findViewById(R.id.eight);
        buttons[9] = (Button) findViewById(R.id.nine);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        for (int i = 1; i <= 9 ; i++) { buttons[i].setOnClickListener(this); }
        //End of Buttons creation
        clearGrid();
    }
    //End of onCreate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //End of onCreateOptionsMenu
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
    //End of onOptionsItemSelected method
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                count++;
                makeMove(1);
                if (count > 2) flipback();
                /*count++;
                buttons[1].setEnabled(false);
                buttons[1].setBackgroundResource(myImageArr[0]);
                buttons[1].setTag(myImageArr[0]);
                if (count > 2) flipback();*/
                break;
            case R.id.two:
                count++;
                makeMove(2);
                if (count > 2) flipback();
                /*count++;
                buttons[2].setEnabled(false);
                buttons[2].setBackgroundResource(myImageArr[1]);
                buttons[2].setTag(myImageArr[1]);
                if (count > 2) flipback();*/
                break;
            case R.id.three:
                count++;
                makeMove(3);
                if (count > 2) flipback();
                /*count++;
                buttons[3].setEnabled(false);
                buttons[3].setBackgroundResource(myImageArr[2]);
                buttons[3].setTag(myImageArr[2]);
                if (count > 2) flipback();*/
                break;
            case R.id.four:
                count++;
                makeMove(4);
                if (count > 2) flipback();
                /*count++;
                buttons[4].setEnabled(false);
                buttons[4].setBackgroundResource(myImageArr[3]);
                buttons[4].setTag(myImageArr[3]);
                if (count > 2) flipback();*/
                break;
            case R.id.five:
                count++;
                makeMove(5);
                if (count > 2) flipback();
                /*count++;
                buttons[5].setEnabled(false);
                buttons[5].setBackgroundResource(myImageArr[4]);
                buttons[5].setTag(myImageArr[4]);
                if (count > 2) flipback();*/
                break;
            case R.id.six:
                count++;
                makeMove(6);
                if (count > 2) flipback();
                /*count++;
                buttons[6].setEnabled(false);
                buttons[6].setBackgroundResource(myImageArr[5]);
                buttons[6].setTag(myImageArr[5]);
                if (count > 2) flipback();*/
                break;
            case R.id.seven:
                count++;
                makeMove(7);
                if (count > 2) flipback();
                /*count++;
                buttons[7].setEnabled(false);
                buttons[7].setBackgroundResource(myImageArr[6]);
                buttons[7].setTag(myImageArr[6]);
                if (count > 2) flipback();*/
                break;
            case R.id.eight:
                count++;
                makeMove(8);
                if (count > 2) flipback();
                /*count++;
                buttons[8].setEnabled(false);
                if (count > 2) flipback();
                buttons[8].setBackgroundResource(myImageArr[7]);
                buttons[8].setTag(myImageArr[7]);*/
                break;
            case R.id.new_game:
                clearGrid();
                break;
        }
    }
    //End of onClick Method
    public void clearGrid() {
        for(int i = 1; i <= 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackgroundResource(android.R.drawable.btn_default);
        }
        randomize(myImageArr, myImageArr.length);
        count = 0;
    }
    //End of clearGrid Method
    public void flipback() {
        for (int i = 1; i <= 8; i++) {
            //doesnt work
            if (buttons[i].getTag(myImageArr[i]) != buttons[i].getTag(myImageArr[i-1])){
                buttons[i].setBackgroundResource(android.R.drawable.btn_default);
                buttons[i].setEnabled(true);
                count = 0;
            } else {
                count = 0;
            }
            /*if (buttons[i].getResources() != null){
                buttons[i].setBackgroundResource(android.R.drawable.btn_default);
                buttons[i].setEnabled(true);
                count = 0;
            } */
      }
    }
    public void flipback2(int i, int j) {
        if (buttons[i].getTag() == buttons[j].getTag()) {
            count = 0;
        } else {
            buttons[i].setBackgroundResource(android.R.drawable.btn_default);
            buttons[i].setEnabled(true);
            buttons[j].setBackgroundResource(android.R.drawable.btn_default);
            buttons[j].setEnabled(true);
        }
    }
    public void makeMove(int i){
        buttons[i].setEnabled(false);
        buttons[i].setBackgroundResource(myImageArr[i-1]);
        buttons[i].setTag(myImageArr[i-1]);
        if (buttons[i].getTag() == buttons[i].getTag()){

        }
        /*buttons[i].setAnimation(animFadeIn);
        buttons[i].setBackgroundResource(R.drawable.connect1);
        buttons[i].setEnabled(false); */
    }
    //End of makeMove method
    public void respond(){
        for (int i = 1; i <= 9; i++) {
            if (buttons[i].isEnabled()) {
                buttons[i].setText("O");
                buttons[i].setEnabled(false);
                break;
            }
        }
    }
    //end of respond method
    public void randomize(int arr[], int n){
        Random r = new Random();
        for (int i = n-1; i>0; i--){
            int j = r.nextInt(i);

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    //end of randomize method
}
