package junior.izael.jogoadiviacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener,View.OnClickListener {

    ImageView um, dois, tres;
    List<String> cartas = new ArrayList<>();
    Button btnNovoJogo;

    boolean umBackShow = true, doisBackShow = true, tresBackShow = true;

    Animation toMiddle, fromMiddle;
    int flagCard = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        um = (ImageView) findViewById(R.id.um);
        dois = (ImageView) findViewById(R.id.dois);
        tres = (ImageView) findViewById(R.id.tres);

        btnNovoJogo = (Button) findViewById(R.id.btnNew);
        toMiddle = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.to_middle);
        fromMiddle = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.from_middle);
        toMiddle.setAnimationListener(this);
        fromMiddle.setAnimationListener(this);

        um.setOnClickListener(this);
        dois.setOnClickListener(this);
        tres.setOnClickListener(this);
        btnNovoJogo.setOnClickListener(this);
        setUp();

    }

    private void setUp() {
        cartas.clear();
        cartas.add("vencedor");
        cartas.add("coringa");
        cartas.add("coringa");

        Collections.shuffle(cartas);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (flagCard == 0) {
            if (animation == toMiddle) {
                if (umBackShow)
                    showCartas(umBackShow, ((ImageView) findViewById(R.id.um)), flagCard);
                else
                    ((ImageView) findViewById(R.id.um)).setImageResource(R.drawable.capa);

                ((ImageView) findViewById(R.id.um)).clearAnimation();
                ((ImageView) findViewById(R.id.um)).startAnimation(fromMiddle);
                ((ImageView) findViewById(R.id.um)).startAnimation(fromMiddle);

            } else
                umBackShow = !umBackShow;

        } else if (flagCard == 1) {
            if (animation == toMiddle) {
                if (doisBackShow)
                    showCartas(doisBackShow, ((ImageView) findViewById(R.id.dois)), flagCard);
                else
                    ((ImageView) findViewById(R.id.dois)).setImageResource(R.drawable.capa);// mostrando a carta é setando a capa nele

                ((ImageView) findViewById(R.id.dois)).clearAnimation();
                ((ImageView) findViewById(R.id.dois)).startAnimation(fromMiddle);
                ((ImageView) findViewById(R.id.dois)).startAnimation(fromMiddle);

            } else
                doisBackShow = !doisBackShow;
        }

        else if (flagCard == 2) {
            if (animation == toMiddle) {
                if (tresBackShow)
                    showCartas(tresBackShow, ((ImageView) findViewById(R.id.tres)), flagCard);
                else
                    ((ImageView) findViewById(R.id.tres)).setImageResource(R.drawable.capa);

                ((ImageView) findViewById(R.id.tres)).clearAnimation();
                ((ImageView) findViewById(R.id.tres)).startAnimation(fromMiddle);
                ((ImageView) findViewById(R.id.tres)).startAnimation(fromMiddle);

            } else
                tresBackShow = !tresBackShow;
        }
    }

    private void showCartas(boolean isBackShow, ImageView imgView, int index) {

        if (isBackShow)
        {
            if (index == 0) // Primeira carta
            {
                if (cartas.get(0).equals("vencedor"))
                    imgView.setImageResource(R.drawable.vencedor);
                else if (cartas.get(0).equals("coringa"))
                    imgView.setImageResource(R.drawable.coringa);

            }
            if (index == 1) // segunda carta
            {
                if (cartas.get(1).equals("vencedor"))
                    imgView.setImageResource(R.drawable.vencedor);
                else if (cartas.get(1).equals("coringa"))
                    imgView.setImageResource(R.drawable.coringa);

            }
            if (index == 2) // Terceira carta
            {
                if (cartas.get(2).equals("vencedor"))
                    imgView.setImageResource(R.drawable.vencedor);
                else if (cartas.get(2).equals("coringa"))
                    imgView.setImageResource(R.drawable.coringa);

            }
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnNew){

            NovoJogo();
        }

        else {

            view.clearAnimation();
            view.setAnimation(toMiddle);
            view.startAnimation(toMiddle);


         if (view.getId() == R.id.um)
                flagCard = 0;
            else if (view.getId() == R.id.dois)
                flagCard = 1;
            else if (view.getId() == R.id.tres)
                flagCard = 2;

        }




    }


    private void fimdeJogo(){





    }

    private void NovoJogo() {

        Collections.shuffle(cartas);

        Animation anim_um = AnimationUtils.loadAnimation(getApplicationContext() ,R.anim.animation_um);
        Animation anim_dois = AnimationUtils.loadAnimation(getApplicationContext() ,R.anim.animation_dois);
        Animation anim_tres = AnimationUtils.loadAnimation(getApplicationContext() ,R.anim.animation_tres);

        um.startAnimation(anim_um);
        dois.startAnimation(anim_dois);
        tres.startAnimation(anim_tres);

        um.setImageResource(R.drawable.capa);
        dois.setImageResource(R.drawable.capa);
        tres.setImageResource(R.drawable.capa);

        umBackShow = doisBackShow = tresBackShow = true;


    }
}