package com.example.moneymate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.MyViewHolder> {


    //CustomAdapter
    private Context context;
    Activity activity;

    //4 array lists
    private ArrayList Account_id, Account_Name, Account_Type, Amount;

    Animation display_anim;



    //constructor
    CustomAdapter(Activity activity, Context context, ArrayList Account_id, ArrayList Account_Name, ArrayList Account_Type, ArrayList Amount ){

        this.activity = activity;
        this.context = context;
        this.Account_id = Account_id;
        this.Account_Name =Account_Name;
        this.Account_Type =Account_Type;
        this.Amount =Amount;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflate method
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {



        //holder.Acc_id_txt.setText(String.valueOf(Account_id.get(position)));
        holder.Acc_Name_txt.setText(String.valueOf(Account_Name.get(position)));
        holder.Acc_Type_txt.setText(String.valueOf(Account_Type.get(position)));
        holder.Amount_txt.setText(String.valueOf(Amount.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Update_Account.class);
                intent.putExtra("Account_id",  String.valueOf(Account_id.get(position)));
                intent.putExtra("Account_Name",  String.valueOf(Account_Name.get(position)));
                intent.putExtra("Account_Type",  String.valueOf(Account_Type.get(position)));
                intent.putExtra("Amount",  String.valueOf(Amount.get(position)));
//                context.startActivity(intent);

                activity.startActivityForResult(intent,1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return Account_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //text view objects
        TextView Acc_id_txt, Acc_Name_txt, Acc_Type_txt, Amount_txt;
        LinearLayout mainLayout;

        //constructor
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Acc_id_txt =itemView.findViewById(R.id.Acc_id_txt);
            Acc_Name_txt =itemView.findViewById(R.id.Acc_Name_txt);
            Acc_Type_txt =itemView.findViewById(R.id.Acc_Type_txt);
            Amount_txt =itemView.findViewById(R.id.Amount_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            //Recycle View Animation
            display_anim = AnimationUtils.loadAnimation(context, R.anim.display_anim);
            mainLayout.setAnimation(display_anim);
        }
    }
}
