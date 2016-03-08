package anthonyjholmes.github.io.imagebuttontests;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] ids;
    private ImageButton[] buttons;
    ImageButton[] challengeButtons;
    int BLACK = 2130837582;
    private int[] challengeTest = new int[]{0,1,2,3,4,5,6,7,8};
      int[] colour= {
              R.drawable.redbutton,    R.drawable.redbutton,R.drawable.redbutton,R.drawable.redbutton,R.drawable.redbutton,
              R.drawable.bluebutton,   R.drawable.bluebutton,R.drawable.bluebutton,R.drawable.bluebutton,R.drawable.bluebutton,
              R.drawable.greenbutton,  R.drawable.greenbutton,R.drawable.greenbutton,R.drawable.greenbutton,R.drawable.greenbutton,
              R.drawable.yellowbutton, R.drawable.yellowbutton,R.drawable.yellowbutton,R.drawable.yellowbutton,R.drawable.yellowbutton,
              R.drawable.orangebutton, R.drawable.orangebutton,R.drawable.orangebutton,R.drawable.orangebutton,R.drawable.orangebutton

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the shared preferences
        SharedPreferences preferences =  getSharedPreferences("my_preferences", MODE_PRIVATE);

// Check if onboarding_complete is false
        if(!preferences.getBoolean("onboarding_complete",false)) {
            // Start the onboarding Activity
            Intent onboarding = new Intent(this, OnboardingActivity.class);
            startActivity(onboarding);

            // Close the main Activity
            finish();
            return;
        }
        startGame();
    }

    public int getResource(ImageButton button) {
        Integer color = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            color = (Integer) button.getTag();
        }
        return color;
    }
    public int[] randomizeArray(int[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }
    public ImageButton[] setTileButtons() {
        ImageButton[] b = new ImageButton[25];
        colour= randomizeArray(colour);

        b[0] = (ImageButton) findViewById(R.id.ButtonEMPTY);
        b[1] = (ImageButton) findViewById(R.id.Button1);
        b[2] = (ImageButton) findViewById(R.id.Button2);
        b[3] = (ImageButton) findViewById(R.id.Button3);
        b[4] = (ImageButton) findViewById(R.id.Button4);
        b[5] = (ImageButton) findViewById(R.id.Button5);
        b[6] = (ImageButton) findViewById(R.id.Button6);
        b[7] = (ImageButton) findViewById(R.id.Button7);
        b[8] = (ImageButton) findViewById(R.id.Button8);
        b[9] = (ImageButton) findViewById(R.id.Button9);
        b[10] = (ImageButton) findViewById(R.id.Button10);
        b[11] = (ImageButton) findViewById(R.id.Button11);
        b[12] = (ImageButton) findViewById(R.id.Button12);
        b[13] = (ImageButton) findViewById(R.id.Button13);
        b[14] = (ImageButton) findViewById(R.id.Button14);
        b[15] = (ImageButton) findViewById(R.id.Button15);
        b[16] = (ImageButton) findViewById(R.id.Button16);
        b[17] = (ImageButton) findViewById(R.id.Button17);
        b[18] = (ImageButton) findViewById(R.id.Button18);
        b[19] = (ImageButton) findViewById(R.id.Button19);
        b[20] = (ImageButton) findViewById(R.id.Button20);
        b[21] = (ImageButton) findViewById(R.id.Button21);
        b[22] = (ImageButton) findViewById(R.id.Button22);
        b[23] = (ImageButton) findViewById(R.id.Button23);
        b[24] = (ImageButton) findViewById(R.id.Button24);

        b[0].setImageResource(R.drawable.blackbutton);
        b[0].setTag(R.drawable.blackbutton);
        System.out.println("Black button tag" + b[0].getTag());

        for (int i = 1; i < b.length; i++) {
            b[i].setImageResource(colour[i]);
            b[i].setTag(colour[i]);
        }

        return b;
    }
    void startGame() {
        setupTileButtons();
        setupChallengeButtons();

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    move((ImageButton) v);
                }
            });
        }
    }
    public void setupTileButtons() {
        buttons = setTileButtons();
    }
    public void setupChallengeButtons() {

        challengeButtons = setChallengeButtons();
        newPuzzle();

    }
    public void move(final ImageButton b) {

        if (findViewById(b.getId()) == buttons[1]) {
            if (getResource(buttons[2]) == BLACK) {
                swap(findViewById(b.getId()), buttons[2]);
            } else if (getResource(buttons[6]) == BLACK) {
                swap(findViewById(b.getId()), buttons[6]);
            }
        } else if (findViewById(b.getId()) == buttons[2]) {
            if (getResource(buttons[1])==BLACK){
                swap(findViewById(b.getId()), buttons[1]);
            } else if (getResource(buttons[7])==BLACK){
                swap(findViewById(b.getId()), buttons[7]);
            } else if (getResource(buttons[3])==BLACK){
                swap(findViewById(b.getId()), buttons[3]);
            }
        } else if (findViewById(b.getId()) == buttons[3]) {
            if (getResource(buttons[2])==BLACK){
                swap(findViewById(b.getId()), buttons[2]);
            } else if (getResource(buttons[4])==BLACK){
                swap(findViewById(b.getId()), buttons[4]);
            } else if (getResource(buttons[8])==BLACK){
                swap(findViewById(b.getId()), buttons[8]);
            }
        } else if (findViewById(b.getId()) == buttons[4]) {
            if (getResource(buttons[3])==BLACK){
                swap(findViewById(b.getId()), buttons[3]);
            } else if (getResource(buttons[5])==BLACK){
                swap(findViewById(b.getId()), buttons[5]);
            } else if (getResource(buttons[9])==BLACK){
                swap(findViewById(b.getId()), buttons[9]);
            }
        } else if (findViewById(b.getId()) == buttons[5]) {
            if (getResource(buttons[10])==BLACK) {
                swap(findViewById(b.getId()), buttons[10]);
            } else if (getResource(buttons[4])==BLACK){
                swap(findViewById(b.getId()), buttons[4]);
            }
        } else if (findViewById(b.getId()) == buttons[6]) {
            if (getResource(buttons[1])==BLACK){
                swap(findViewById(b.getId()), buttons[1]);
            } else if (getResource(buttons[11])==BLACK) {
                swap(findViewById(b.getId()), buttons[11]);
            } else if (getResource(buttons[7])==BLACK){
                swap(findViewById(b.getId()), buttons[7]);
            }
        } else if (findViewById(b.getId()) == buttons[7]) {
            if (getResource(buttons[6])==BLACK){
                swap(findViewById(b.getId()), buttons[6]);
            } else if (getResource(buttons[8])==BLACK){
                swap(findViewById(b.getId()), buttons[8]);
            } else if (getResource(buttons[2])==BLACK){
                swap(findViewById(b.getId()), buttons[2]);
            } else if (getResource(buttons[12])==BLACK) {
                swap(findViewById(b.getId()), buttons[12]);
            }
        } else if (findViewById(b.getId()) == buttons[8]) {
            if (getResource(buttons[13])==BLACK) {
                swap(findViewById(b.getId()), buttons[13]);
            } else if (getResource(buttons[9])==BLACK){
                swap(findViewById(b.getId()), buttons[9]);
            } else if (getResource(buttons[7])==BLACK){
                swap(findViewById(b.getId()), buttons[7]);
            } else if (getResource(buttons[3])==BLACK){
                swap(findViewById(b.getId()), buttons[3]);
            }
        } else if (findViewById(b.getId()) == buttons[9]) {
            if (getResource(buttons[10])==BLACK) {
                swap(findViewById(b.getId()), buttons[10]);
            } else if (getResource(buttons[8])==BLACK){
                swap(findViewById(b.getId()), buttons[8]);
            } else if (getResource(buttons[4])==BLACK){
                swap(findViewById(b.getId()), buttons[4]);
            } else if (getResource(buttons[14])==BLACK) {
                swap(findViewById(b.getId()), buttons[14]);
            }
        } else if (findViewById(b.getId()) == buttons[10]) {
            if (getResource(buttons[5])==BLACK){
                swap(findViewById(b.getId()), buttons[5]);
            } else if (getResource(buttons[9])==BLACK){
                swap(findViewById(b.getId()), buttons[9]);
            } else if (getResource(buttons[15])==BLACK) {
                swap(findViewById(b.getId()), buttons[15]);
            }
        } else if (findViewById(b.getId()) == buttons[11]) {
            if (getResource(buttons[12])==BLACK) {
                swap(findViewById(b.getId()), buttons[12]);
            } else if (getResource(buttons[6])==BLACK){
                swap(findViewById(b.getId()), buttons[6]);
            } else if (getResource(buttons[16])==BLACK) {
                swap(findViewById(b.getId()), buttons[16]);
            }
        } else if (findViewById(b.getId()) == buttons[12]) {
            if (getResource(buttons[13])==BLACK) {
                swap(findViewById(b.getId()), buttons[13]);
            } else if (getResource(buttons[11])==BLACK) {
                swap(findViewById(b.getId()), buttons[11]);
            } else if (getResource(buttons[17])==BLACK) {
                swap(findViewById(b.getId()), buttons[17]);
            } else if (getResource(buttons[7])==BLACK){
                swap(findViewById(b.getId()), buttons[7]);
            }
        } else if (findViewById(b.getId()) == buttons[13]) {
            if (getResource(buttons[14])==BLACK) {
                swap(findViewById(b.getId()), buttons[14]);
            } else if (getResource(buttons[12])==BLACK) {
                swap(findViewById(b.getId()), buttons[12]);
            } else if (getResource(buttons[18])==BLACK) {
                swap(findViewById(b.getId()), buttons[18]);
            } else if (getResource(buttons[8])==BLACK){
                swap(findViewById(b.getId()), buttons[8]);
            }
        } else if (findViewById(b.getId()) == buttons[14]) {
            if (getResource(buttons[15])==BLACK) {
                swap(findViewById(b.getId()), buttons[15]);
            } else if (getResource(buttons[13])==BLACK) {
                swap(findViewById(b.getId()), buttons[13]);
            } else if (getResource(buttons[19])==BLACK) {
                swap(findViewById(b.getId()), buttons[19]);
            } else if (getResource(buttons[9])==BLACK){
                swap(findViewById(b.getId()), buttons[9]);
            }
        } else if (findViewById(b.getId()) == buttons[15]) {
            if (getResource(buttons[10])==BLACK) {
                swap(findViewById(b.getId()), buttons[10]);
            } else if (getResource(buttons[14])==BLACK) {
                swap(findViewById(b.getId()), buttons[14]);
            } else if (getResource(buttons[20])==BLACK) {
                swap(findViewById(b.getId()), buttons[20]);
            }
        } else if (findViewById(b.getId()) == buttons[16]) {
            if (getResource(buttons[17])==BLACK) {
                swap(findViewById(b.getId()), buttons[17]);
            } else if (getResource(buttons[11])==BLACK) {
                swap(findViewById(b.getId()), buttons[11]);
            } else if (getResource(buttons[21])==BLACK) {
                swap(findViewById(b.getId()), buttons[21]);
            }
        } else if (findViewById(b.getId()) == buttons[17]) {
            if (getResource(buttons[18])==BLACK) {
                swap(findViewById(b.getId()), buttons[18]);
            } else if (getResource(buttons[16])==BLACK) {
                swap(findViewById(b.getId()), buttons[16]);
            } else if (getResource(buttons[22])==BLACK) {
                swap(findViewById(b.getId()), buttons[22]);
            } else if (getResource(buttons[12])==BLACK) {
                swap(findViewById(b.getId()), buttons[12]);
            }
        } else if (findViewById(b.getId()) == buttons[18]) {
            if (getResource(buttons[19])==BLACK) {
                swap(findViewById(b.getId()), buttons[19]);
            } else if (getResource(buttons[17])==BLACK) {
                swap(findViewById(b.getId()), buttons[17]);
            } else if (getResource(buttons[23])==BLACK) {
                swap(findViewById(b.getId()), buttons[23]);
            } else if (getResource(buttons[13])==BLACK) {
                swap(findViewById(b.getId()), buttons[13]);
            }

        } else if (findViewById(b.getId()) == buttons[19]) {
            if (getResource(buttons[20])==BLACK) {
                swap(findViewById(b.getId()), buttons[20]);


            } else if (getResource(buttons[18])==BLACK) {
                swap(findViewById(b.getId()), buttons[18]);

            } else if (getResource(buttons[24])==BLACK) {
                swap(findViewById(b.getId()), buttons[24]);
            } else if (getResource(buttons[14])==BLACK) {
                swap(findViewById(b.getId()), buttons[14]);
            }

        } else if (findViewById(b.getId()) == buttons[20]) {
            if (getResource(buttons[0])==BLACK){
                swap(findViewById(b.getId()), buttons[0]);
            } else if (getResource(buttons[19])==BLACK) {
                swap(findViewById(b.getId()), buttons[19]);

            } else if (getResource(buttons[15])==BLACK) {
                swap(findViewById(b.getId()), buttons[15]);
            }
        } else if (findViewById(b.getId()) == buttons[21]) {
            if (getResource(buttons[22])==BLACK) {
                swap(findViewById(b.getId()), buttons[22]);
            } else if (getResource(buttons[16])==BLACK) {
                swap(findViewById(b.getId()), buttons[16]);
            }
        } else if (findViewById(b.getId()) == buttons[22]) {
            if (getResource(buttons[23])==BLACK) {
                swap(findViewById(b.getId()), buttons[23]);
            } else if (getResource(buttons[21])==BLACK) {
                swap(findViewById(b.getId()), buttons[21]);

            } else if (getResource(buttons[17])==BLACK) {
                swap(findViewById(b.getId()), buttons[17]);
            }
        } else if (findViewById(b.getId()) == buttons[23]) {
            if (getResource(buttons[24])==BLACK) {
                swap(findViewById(b.getId()), buttons[24]);
            } else if (getResource(buttons[22])==BLACK) {
                swap(findViewById(b.getId()), buttons[22]);

            } else if (getResource(buttons[18])==BLACK) {
                swap(findViewById(b.getId()), buttons[18]);
            }
        } else if (findViewById(b.getId()) == buttons[24]) {
            if (getResource(buttons[0]) == BLACK){
                System.out.println("Button 0 is Black");
                swap(findViewById(b.getId()), buttons[0]);
            } else if (getResource(buttons[23]) ==(BLACK)) {
                System.out.println("Button 23 is Black");
                swap(findViewById(b.getId()), buttons[23]);

            } else if (getResource(buttons[19])==(BLACK)) {
                System.out.println("Button 19 is Black");
                swap(findViewById(b.getId()), buttons[19]);
            }
        } else if (findViewById(b.getId()) == buttons[0]) {
            if (getResource(buttons[20]) == BLACK) {
                System.out.println("Button 20 is Black");
                swap(findViewById(b.getId()), buttons[20]);
            } else if (getResource(buttons[24]) == BLACK) {
                System.out.println("Button 24 is Black");
                swap(findViewById(b.getId()), buttons[24]);
            }
        }

        if (isWinner(ids)) {

            newPuzzle();
        }


    }
    public boolean isWinner(int[] listOfPuzzleIDs) {
        int counter = 0;

        for (int i = 0; i < listOfPuzzleIDs.length; i++) {
            if (listOfPuzzleIDs[i] < 3) {
                if (getResource(buttons[listOfPuzzleIDs[i] + 7]) == getResource(challengeButtons[listOfPuzzleIDs[i]])) {
                    counter++;
                }
            } else if (listOfPuzzleIDs[i] < 6) {
                if (getResource(buttons[listOfPuzzleIDs[i] + 9]) == getResource(challengeButtons[listOfPuzzleIDs[i]])) {
                    counter++;
                }
            } else {
                if (getResource(buttons[listOfPuzzleIDs[i] + 11])==(getResource(challengeButtons[listOfPuzzleIDs[i]]))) {
                    counter++;

                }
            }
        }
        System.out.println("counter: " +counter);
        return (counter == 3);
    }
    public ImageButton[] setChallengeButtons() {
        ImageButton[] button = new ImageButton[9];
        button[0] = (ImageButton) findViewById(R.id.challenge0);
        button[1] = (ImageButton) findViewById(R.id.challenge1);
        button[2] = (ImageButton) findViewById(R.id.challenge2);
        button[3] = (ImageButton) findViewById(R.id.challenge3);
        button[4] = (ImageButton) findViewById(R.id.challenge4);
        button[5] = (ImageButton) findViewById(R.id.challenge5);
        button[6] = (ImageButton) findViewById(R.id.challenge6);
        button[7] = (ImageButton) findViewById(R.id.challenge7);
        button[8] = (ImageButton) findViewById(R.id.challenge8);

        return button;
    }

    public void swap(View pressed, ImageButton oldEmptyPiece) {

        Integer tmp = getResource((ImageButton) pressed);
        ((ImageButton) pressed).setImageResource(R.drawable.blackbutton);
        pressed.setTag(R.drawable.blackbutton);
        oldEmptyPiece.setImageResource(tmp);
        oldEmptyPiece.setTag(tmp);

    }




    public void newPuzzle() {

        ids = new int[3];
        Random rnd = new Random();
        challengeTest = randomizeArray(challengeTest);

        for (int i = 3; i < 9; i++) {
            challengeButtons[challengeTest[i]].setVisibility(View.INVISIBLE);

        }
        for (int i = 0; i < 3; i++) {
            ids[i] = challengeTest[i];
            int nextInt = rnd.nextInt(25);
            challengeButtons[challengeTest[i]].setImageResource(colour[nextInt]);
            challengeButtons[challengeTest[i]].setTag(colour[nextInt]);
            challengeButtons[challengeTest[i]].setVisibility(View.VISIBLE);

        }

    }
}
