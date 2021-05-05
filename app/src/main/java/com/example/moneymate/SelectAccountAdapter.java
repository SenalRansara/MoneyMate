package com.example.moneymate;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectAccountAdapter extends RecyclerView.Adapter<SelectAccountAdapter.AccountViewHolder> {

    private Context context;
    private ArrayList accId,accName;
    int position;

    SelectAccountAdapter(Context context, ArrayList accId, ArrayList accName){

        this.context = context;
        this.accId = accId;
        this.accName = accName;

    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.account_recycler,parent,false);
        return  new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        holder.accName.setText((String.valueOf(accName.get(position))));
        Log.d("<<<<<<<<<<<<",(String.valueOf(accName.get(position))));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context," Account selected ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,Choose_category.class);
                intent.putExtra("Account",String.valueOf(accName.get(position)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return accId.size();
    }

    public class AccountViewHolder extends RecyclerView.ViewHolder{
        TextView accId, accName;
        LinearLayout mainLayout;

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
            accId = itemView.findViewById(R.id.exId);
            accName = itemView.findViewById(R.id.catName);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
