package com.example.tuan7.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tuan7.R;
import com.example.tuan7.models.ItemModel;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

	Context context;
	List<List<ItemModel>> itemss;

	public RecycleViewAdapter(Context context, List<List<ItemModel>> itemss) {
		this.context = context;
		this.itemss = itemss;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		View view = LayoutInflater.from(context).inflate(R.layout.layout_item_2, viewGroup, false);
		return new ListViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
		ListViewHolder viewHolder1 = (ListViewHolder) viewHolder;
		ItemAdapter itemAdapter = new ItemAdapter(itemss.get(i));
		viewHolder1.recyclerView.setAdapter(itemAdapter);
	}

	@Override
	public int getItemCount() {
		return itemss.size();
	}

	class ListViewHolder extends RecyclerView.ViewHolder{

		RecyclerView recyclerView;


		public ListViewHolder(@NonNull View itemView) {
			super(itemView);
			recyclerView = itemView.findViewById(R.id.recycle_view1);
			recyclerView.setHasFixedSize(true);

			@SuppressLint("WrongConstant") RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false);
			recyclerView.setLayoutManager(layoutManager);
		}
	}
}
