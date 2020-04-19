package com.example.tuan7.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tuan7.ItemClickListener;
import com.example.tuan7.MainActivity;
import com.example.tuan7.R;
import com.example.tuan7.models.ItemModel;

import java.util.List;

public class ItemAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ItemModel> items;
    ItemClickListener listener;


    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
    }
    public ItemAdapter(List<ItemModel> items, ItemClickListener listener) {
        this.listener = listener;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemModel item = items.get(position);
        ItemViewHolder viewHolder = (ItemViewHolder) holder;

        viewHolder.textview.setText(item.getTitle());
        viewHolder.imageView.setImageResource(item.getImageRes());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView textview;
        ImageView imageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(listener != null)
                        listener.OnItemClick(getAdapterPosition());

                }
            });
        }
    }
}
