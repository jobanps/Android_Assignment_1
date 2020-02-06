package com.csat.assignment_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class VotingActivity extends AppCompatActivity {

    EditText userName;
    EditText userId;
    String candidateSelected = "";
    Spinner candList;
    TextView voted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);
        userName = findViewById(R.id.userName);
        userId = findViewById(R.id.userId);
        candList = findViewById(R.id.candList);
        voted = findViewById(R.id.voted);

    }

    public void saveVoteData(View view) {

        voted.setText("");
        if (!userName.getText().toString().isEmpty() && !userId.getText().toString().isEmpty()) {
            int id = Integer.valueOf(userId.getText().toString());

            if (checkId(id)) {
                if (candList.getSelectedItemId() != 0) {
                    candidateSelected = candList.getSelectedItem().toString();
                    voted.setText("Voted for " + candidateSelected);
                    MainActivity.candidateVoted = candidateSelected;
                    MainActivity.candidateIds.add(id);
                } else {
                    voted.setText("Please select Candidate");
                }
            } else {
                voted.setText("Please enter new Id, you have already voted");
            }
        } else {

            voted.setText("Name or Id Missing ");
        }
    }


    public boolean checkId(int id) {

        for(int i = 0; i < MainActivity.candidateIds.size() ; i++) {
            if(MainActivity.candidateIds.get(i) == id)
                return false;
        }
    return true;
    }

}
