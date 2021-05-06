package com.example.moneymate;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.ViewData> {

    private Context context;
    private ArrayList id,des,amount;


        BudgetAdapter(Context context, ArrayList id, ArrayList des, ArrayList amount) {
        this.context = context;
        this.id = id;
        this.des = des;
        this.amount = amount;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row,parent,false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.des.setText(String.valueOf(des.get(position)));
        holder.amount.setText(String.valueOf(amount.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (context, UpdateSavings.class);
                intent.putExtra("aid",String.valueOf(id.get(position)));
                intent.putExtra("description",String.valueOf(des.get(position)));
                intent.putExtra("amnt",String.valueOf(amount.get(position)));
                context.startActivity(intent);
            }
        });
        }


    @Override
    public int getItemCount() {

            return id.size();
    }

     class ViewData extends RecyclerView.ViewHolder {

        TextView id,des,amount;
        ConstraintLayout mainLayout;


            ViewData(View view) {
            super(view);
            id = view.findViewById(R.id.id_txt);
            des = view.findViewById(R.id.des_txt);
            amount = view.findViewById(R.id.amount_txt);
            mainLayout = view.findViewById(R.id.mainLayout);
        }
    }
}
