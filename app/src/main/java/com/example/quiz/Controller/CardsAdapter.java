package com.example.quiz.Controller;

import android.content.Context;
import android.text.style.AlignmentSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.R;

import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsHolder> {


    private Context context ;
    private List Quizes ;

    public CardsAdapter(Context context, List quizes) {
        this.context = context;
        Quizes = quizes;
    }

    @NonNull
    @Override
    public CardsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.quiz_layout,parent,false);
        return new CardsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsHolder holder, int position) {
        holder.quiz.setText(Quizes.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return Quizes.size();
    }

    static class CardsHolder extends RecyclerView.ViewHolder {

        public TextView quiz ;
        public CardsHolder(@NonNull View itemView) {
            super(itemView);
            quiz = itemView.findViewById(R.id.txtQuiz);
            itemView.findViewById(R.id.txtFlase).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            itemView.findViewById(R.id.txtTrue).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}


