package project.android_projects.com.tictocgamewithmvc;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import Adapter.MyRecViewAdapter;
import Models.Players;

public class MainActivity extends AppCompatActivity implements Observer,
        MyRecViewAdapter.OnItemClickListenerCallback, View.OnClickListener {
    private MyRecViewAdapter mAdapter;
    private RecyclerView recView;

    private List<String> xoStrList;
    private int[] xoStrings;

    private ImageButton xBtn,oBtn;
    private TextView textView;
    private Button restartBtn;

    private Players playerMod;

    private LinearLayout linearLayout;
    private TicTocController ticTocController;

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ticTocController = TicTocController.getInstance();
        inflater = getLayoutInflater();

        initContentView();

        //Player Mod
        playerMod = new Players();
        playerMod.addObserver(this);
    }

    private void initContentView() {
        //Create the tic toc board using RecyclerView with GridLayoutManager
        recView = (RecyclerView) findViewById(R.id.recyclerView);

        xoStrList = new ArrayList<>();
        createTicTocBoard(xoStrList);

        mAdapter = new MyRecViewAdapter(this, xoStrList);
        recView.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter.setOnItemClickListener(this);
        recView.setAdapter(mAdapter);

        //Initialize buttons
        xBtn =(ImageButton) findViewById(R.id.x_button);
        oBtn = (ImageButton)findViewById(R.id.o_button);
        restartBtn = (Button)findViewById(R.id.restart_btn);

        xBtn.setOnClickListener(this); oBtn.setOnClickListener(this);
        restartBtn.setOnClickListener(this);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        textView = (TextView)findViewById(R.id.player_turns_tv);
    }

    private void createTicTocBoard(List<String> ticTocXOList) {
        xoStrings = new int[9];
        for (int i = 0; i < xoStrings.length; i++) {
            ticTocXOList.add("");
        }
    }

    @Override
    public void onItemClick(int position) {
        LinearLayout boardLayout = (LinearLayout)inflater.inflate(R.layout.recycle_view_items, null);
        TextView ticTocTV = boardLayout.findViewById(R.id.tic_toc_btns);

        for(int i =0;i<9;i++){

        }
        if(position == 0){
            Log.d("CLICK","Clicked"+ticTocTV);

        }

    }

    private void displayXO(Players player){
        player = new Players();
        player.setPlayerO("O");
        player.setPlayerX("X");
        player.getPlayerO(); player.getPlayerX();

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.o_button:
                //the player chooses o
                Toast.makeText(getApplicationContext(),"You've chosen Nought",
                        Toast.LENGTH_SHORT).show();
                linearLayout.setVisibility(View.GONE);
                textView.setText("O's turn");

                break;
            case R.id.x_button:
                //the player chooses x
                Toast.makeText(getApplicationContext(),"You've chosen Cross",
                        Toast.LENGTH_SHORT).show();
                linearLayout.setVisibility(View.GONE);
                textView.setText("O's turn");
                break;
            case R.id.restart_btn:
                linearLayout.setVisibility(View.VISIBLE);
                textView.setText("Choose a side: ");
                break;
        }

    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
