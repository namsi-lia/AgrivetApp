package com.project.agrivetApp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.agrivetApp.R;
import com.project.agrivetApp.modals.MainListItem;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
private ArrayList<MainListItem> list=new ArrayList<>();
private Context context;
private int layout= R.layout.item_main;

public MainAdapter(Context context,ArrayList<MainListItem> items) {
        this.context = context;
        this.list=items;
}


    public MainAdapter(Context context,ArrayList<MainListItem> items,int layout) {
        this.context = context;
        this.list=items;
        this.layout=layout;
    }


@Override
public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent, false);
        return new viewHolder(view);
        }

@Override
public void onBindViewHolder(viewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.englishText.setText(list.get(position).getEnglishText());
//        holder.hindiText.setText(list.get(position).getHindiText());
       holder.imageView.setImageResource(list.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).getIntent()!=null)
                context.startActivity(list.get(position).getIntent());
            }
        });
}

@Override
public int getItemCount() {
        return list.size();
        }

public static class viewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView englishText;

    public viewHolder(View itemView) {
        super(itemView);
        imageView= (ImageView) itemView.findViewById(R.id.imageView);
//        hindiText= (TextView) itemView.findViewById(R.id.hindi_title);
        englishText= (TextView) itemView.findViewById(R.id.english_title);
    }
 }
}
