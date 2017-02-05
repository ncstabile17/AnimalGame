package nickinc.animalgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView pos1, pos2, pos3, pos4, pos5, pos6, pos7;
    ArrayList<ImageView> pos = new ArrayList<>();


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

        pos.add(pos1);
        pos.add(pos2);
        pos.add(pos3);
        pos.add(pos4);
        pos.add(pos5);
        pos.add(pos6);
        pos.add(pos7);

        start();
    }//onCreate

    public void start() {

//        ImageView curView = pos.get(1);
//        curView.setImageResource(R.drawable.crab);
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanim);
//        animation.setRepeatCount(Animation.INFINITE);
//        curView.startAnimation(animation);
//
//        ImageView curView1 = pos.get(2);
//        curView1.setImageResource(R.drawable.crab);
//        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanim);
//        animation1.setStartOffset(4000);
//        curView1.startAnimation(animation1);

        long offset = 1000;
        int bool = 0;
    int i = 0;
        while (i<10) {
            Random rand = new Random();
            ImageView curView = pos.get(rand.nextInt(pos.size()));
            bool = rand.nextInt(2);
            if (bool == 0) {
                curView.setImageResource(R.drawable.crab);
            }
            else {
                curView.setImageResource(R.drawable.platypus);
            }
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanim);
            animation.setStartOffset(offset);
          //  animation.setRepeatCount(Animation.INFINITE);
            curView.startAnimation(animation);

            offset= (int) (offset + (rand.nextDouble() * 1000));
            i++;
            animation.cancel();
        }

    }//start()

}//mainActivity
