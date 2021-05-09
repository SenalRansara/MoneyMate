package com.example.moneymate;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    private Context context;
    private ArrayList exId,exCategory,exAccount,exAmount;
    int position;

    Animation display_anim;

    TransactionAdapter(Context context, ArrayList exId, ArrayList exCategory, ArrayList exAccount, ArrayList exAmount){

        this.context = context;
        this.exId = exId;
        this.exCategory = exCategory;
        this.exAccount = exAccount;
        this.exAmount = exAmount;

    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.transaction_recycler,parent,false);
        return  new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.TransactionViewHolder holder, int position) {
        holder.exCategory.setText((String.valueOf(exCategory.get(position))));
        holder.exAccount.setText((String.valueOf(exAccount.get(position))));
        holder.exAmount.setText((String.valueOf(exAmount.get(position))));
        //Log.d("<<<<<<<<<<<<",(String.valueOf(accName.get(position))));

        holder.transaction_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Update.class);
                intent.putExtra("exId",String.valueOf(exId.get(position)));
                intent.putExtra("exCategory",String.valueOf(exCategory.get(position)));
                intent.putExtra("exAccount",String.valueOf(exAccount.get(position)));
                intent.putExtra("exAmount",String.valueOf(exAmount.get(position)));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exId.size();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder{
        TextView exId,exCategory,exAccount,exAmount;
        LinearLayout transaction_layout;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            exId = itemView.findViewById(R.id.exId);
            exCategory = itemView.findViewById(R.id.catName);
            exAccount = itemView.findViewById(R.id.accType);
            exAmount = itemView.findViewById(R.id.totAmount);
            transaction_layout = itemView.findViewById(R.id.transaction_layout);

            display_anim = AnimationUtils.loadAnimation(context, R.anim.display_anim);
            transaction_layout.setAnimation(display_anim);
        }
    }
}
