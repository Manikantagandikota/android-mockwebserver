package com.example.ruwa.mockservertest.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruwa.mockservertest.R;
import com.example.ruwa.mockservertest.model.Hero;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    Context context;
    String titleName="";
    List<Hero> listDummy = new ArrayList<Hero>();
    public ListAdapter(Context context, List<Hero> listDummy) {
        this.context = context;
        this.listDummy =listDummy;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.Name.setText(listDummy.get(position).getName());
        holder.real_name.setText(listDummy.get(position).getRealname());
        holder.team.setText(listDummy.get(position).getTeam());
        holder.first.setText(listDummy.get(position).getFirstappearance());
    }

    @Override
    public int getItemCount() {
        return listDummy.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name, real_name, team, first;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.name);
            real_name = (TextView) itemView.findViewById(R.id.realname);
            team = (TextView) itemView.findViewById(R.id.team);
            first = (TextView) itemView.findViewById(R.id.first);
        }
    }
}