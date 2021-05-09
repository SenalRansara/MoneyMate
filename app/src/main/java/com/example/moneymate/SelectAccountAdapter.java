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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectAccountAdapter extends RecyclerView.Adapter<SelectAccountAdapter.AccountViewHolder> {

    private Context context;
    private ArrayList accId,accName,accType;
    int position;

    Animation display_anim;

    SelectAccountAdapter(Context context, ArrayList accId, ArrayList accName, ArrayList accType){

        this.context = context;
        this.accId = accId;
        this.accName = accName;
        this.accType= accType;

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
        holder.accType.setText((String.valueOf(accType.get(position))));
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
        TextView accId, accName, accType;
        LinearLayout mainLayout;

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
            accId = itemView.findViewById(R.id.exId);
            accName = itemView.findViewById(R.id.catName);
            accType = itemView.findViewById(R.id.acc_type);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            //Recycle View Animation
            display_anim = AnimationUtils.loadAnimation(context, R.anim.display_anim);
            mainLayout.setAnimation(display_anim);
        }
    }
}
