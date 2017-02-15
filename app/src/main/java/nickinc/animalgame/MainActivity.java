package nickinc.animalgame;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

//    public class OverlapCheck implements Runnable {
//
//        public void run() {
//            System.out.print("Thread started");
//            while(!(animation.hasEnded())) {
//               // System.out.print("OH NOOOOOOO");
//                    checkOverlap();
//                if (Rect.intersects(otherViewRect5, myViewRect)) {
//                    System.out.println("THEY'VE OVERLAPPEDDDDD");
//                }
//
//                if (Rect.intersects(myViewRect, otherViewRect1) || Rect.intersects(myViewRect, otherViewRect2) || Rect.intersects(myViewRect, otherViewRect3) ||
//                        Rect.intersects(myViewRect, otherViewRect4) || Rect.intersects(myViewRect, otherViewRect5) || Rect.intersects(myViewRect, otherViewRect6) || Rect.intersects(myViewRect, otherViewRect7)) {
//
//                    System.out.println("They've Overlatpped");
//
//                }
//            }
//        }
//
//        public void checkOverlap() {
//            if (Rect.intersects(otherViewRect5, myViewRect)) {
//                System.out.println("THEY'VE OVERLAPPEDDDDD");
//            }
//        }
//    }


    ImageView pos1, pos2, pos3, pos4, pos5, pos6, pos7, playerImage;
    ImageButton leftButton, rightButton;
    ArrayList<ImageView> pos = new ArrayList<>();
    Animation animation;
    Rect myViewRect, otherViewRect1, otherViewRect2, otherViewRect3, otherViewRect4, otherViewRect5, otherViewRect6, otherViewRect7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pos1 = (ImageView) findViewById(R.id.imageView1);
        pos2 = (ImageView) findViewById(R.id.imageView2);
        pos3 = (ImageView) findViewById(R.id.imageView3);
        pos4 = (ImageView) findViewById(R.id.imageView4);
        pos5 = (ImageView) findViewById(R.id.imageView5);
        pos6 = (ImageView) findViewById(R.id.imageView6);
        pos7 = (ImageView) findViewById(R.id.imageView7);

        leftButton = (ImageButton) findViewById(R.id.leftButton);
        rightButton = (ImageButton) findViewById(R.id.rightButton);

        playerImage = (ImageView) findViewById(R.id.playerImage);

        pos.add(pos1);
        pos.add(pos2);
        pos.add(pos3);
        pos.add(pos4);
        pos.add(pos5);
        pos.add(pos6);
        pos.add(pos7);

        leftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moveLeft();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moveRight();
            }
        });


        myViewRect = new Rect();
        playerImage.getHitRect(myViewRect);

        otherViewRect1 = new Rect();
        pos1.getHitRect(otherViewRect1);

        otherViewRect2 = new Rect();
        pos2.getHitRect(otherViewRect2);

        otherViewRect3 = new Rect();
        pos3.getHitRect(otherViewRect3);

        otherViewRect4 = new Rect();
        pos4.getHitRect(otherViewRect4);

        otherViewRect5 = new Rect();
        pos5.getHitRect(otherViewRect5);

        otherViewRect6 = new Rect();
        pos6.getHitRect(otherViewRect6);

        otherViewRect7 = new Rect();
        pos7.getHitRect(otherViewRect7);

        dialog();


    }//onCreate

    public void start() {

        long offset = 1000;
        int bool = 0;
    int i = 0;
        while (i<pos.size()) {
            Random rand = new Random();
            final ImageView curView = pos.get(i);
            curView.setImageResource(R.drawable.raindrop);
            animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanim);

            animation.setStartOffset(offset);
            //animation.setRepeatCount(Animation.INFINITE);
            curView.startAnimation(animation);

            offset= (int) (offset + (rand.nextDouble() * 1000));
            i++;


        }

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                System.out.println("In listener" + pos5.getLeft() + " " + playerImage.getLeft());
                if ((pos5.getLeft()<playerImage.getLeft()) && (pos5.getRight() > playerImage.getLeft())) {
                    System.out.println("THEY're VOVOEKR:A");
                }
                else if ((pos5.getLeft()<playerImage.getRight()) && (pos5.getRight() > playerImage.getRight())) {
                    System.out.println("THEY're VOVOEKR:A");
                }

                else if ((pos5.getLeft()==playerImage.getRight()) && (pos5.getRight() == playerImage.getRight())) {
                    System.out.println("THEY're VOVOEKR:A");
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

//        OverlapCheck p = new OverlapCheck();
//        new Thread(p).start();



    }//start()

    public void moveLeft() {
        playerImage.animate().translationXBy(-50f);

    }

    public void moveRight() {
        playerImage.animate().translationXBy(50f);

    }

    public void dialog() {
        //public void open(View view){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Use the arrow buttons to help the kitty avoid the raindrops!");
                    alertDialogBuilder.setPositiveButton("Click to Play",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    start();
                                }
                            });


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
    }

    public void overlap(Animation animation) {
        while(!(animation.hasEnded())) {
            if (Rect.intersects(myViewRect, otherViewRect1) || Rect.intersects(myViewRect, otherViewRect2) || Rect.intersects(myViewRect, otherViewRect3) ||
                    Rect.intersects(myViewRect, otherViewRect4) || Rect.intersects(myViewRect, otherViewRect5) || Rect.intersects(myViewRect, otherViewRect6) || Rect.intersects(myViewRect, otherViewRect7)) {

                // animation.cancel();
                dialog();
                Toast.makeText(getApplicationContext(), "look it's toast", Toast.LENGTH_LONG).show();
                moveLeft();
            }
        }
    }

}//mainActivity
