package com.example.quiz.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.quiz.Model.VolleySingleton;
import com.example.quiz.R;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    private RequestQueue queue ;
    private CardStackView cardStackView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardStackView = findViewById(R.id.mCardStack);
        cardStackView.setLayoutManager(new CardStackLayoutManager(this));


        queue = VolleySingleton.getInstance().getRequestQueue();

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, "https://opentdb.com/api.php?amount=10&category=9&type=boolean", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                showQuiz();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(objectRequest);
    }

    private void showQuiz() {

    }
}