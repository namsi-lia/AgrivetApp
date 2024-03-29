package com.project.agrivetApp.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.agrivetApp.R;
import com.project.agrivetApp.activities.WebActivity;


public class StateDepartmentAdapter extends RecyclerView.Adapter<StateDepartmentAdapter.viewHolder> {
    private String[] array;
    private String[] links;
    private Context context;
    private int layout= R.layout.item_category;

    public StateDepartmentAdapter(Context context, String[] array, String[] links) {
        this.context = context;
        this.array=array;
        this.links=links;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {

        holder.textView.setText(array[position+1]);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, WebActivity.class);
                intent.putExtra("link",links[position]);
                intent.putExtra("title","State Agriculture Department");
               context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.length-1;
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        CardView card;

        public viewHolder(View itemView) {
            super(itemView);
            card=(CardView) itemView.findViewById(R.id.card);
            textView= (TextView) itemView.findViewById(R.id.title);
        }
    }
}
