package com.example.wadim.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wadim on 13.12.2017.
 */

public class FragmentWithRec extends Fragment {
    String[] strings;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rec, container, false);
        strings = getResources().getStringArray(R.array.arrayWithStrings);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerAdapter(strings));

        Toast.makeText(getActivity(), "sdf", Toast.LENGTH_SHORT).show();
        return view;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView imageView;
        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));

            name = itemView.findViewById(R.id.txtName);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void bind(String name){
            this.name.setText(name);
            imageView.setImageResource(getResources().getIdentifier(name, "drawable", getActivity().getPackageName()));
        }
    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
        ArrayList<String> data = new ArrayList<>();

        public RecyclerAdapter(String[] array) {
            for(int i=0;i<array.length;i++){
                data.add(array[i]);
            }
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new RecyclerViewHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder.bind(data.get(position));
        }


        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}
