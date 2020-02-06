package com.csat.assignment_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int[] voteCount = new int[3];
   // String candidateVoted = "";
    TextView candVote1;
    TextView candVote2;
    TextView candVote3;
    TextView result;
    public static String candidateVoted = "";
    public static ArrayList<Integer> candidateIds = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        candVote1 = findViewById(R.id.vote1);
        candVote2 = findViewById(R.id.vote2);
        candVote3 = findViewById(R.id.vote3);
        result = findViewById(R.id.result);
        voteCount[0] = 0;
        voteCount[1] = 0;
        voteCount[2] = 0;
    }

    public void voteCandidate(View view) {

        Intent intent = new Intent(this, VotingActivity.class);
        intent.putExtra("voteCount", voteCount);
        intent.putExtra(candidateVoted,"");
        startActivity(intent);
    }

    @Override
    protected void onStart() {


        if(getIntent() != null) {
           String candidate = candidateVoted;
           System.out.println(candidate);
            if(candidate !=null) {
                if (candidate.equals("Candidate 1")) {
                    voteCount[0]++;
                } else if (candidate.equals("Candidate 2")) {
                    voteCount[1]++;
                } else if(candidate.equals("Candidate 3")) {
                    voteCount[2]++;
                }
            }
       }

        candVote1.setText(""+voteCount[0] + " votes");
        candVote2.setText(""+voteCount[1] + " votes");
        candVote3.setText(""+voteCount[2] + " votes");

        super.onStart();
    }

}
