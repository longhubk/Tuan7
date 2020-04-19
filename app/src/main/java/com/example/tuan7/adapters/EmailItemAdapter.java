package com.example.tuan7.adapters;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tuan7.R;
import com.example.tuan7.models.EmailItemModel;

import java.util.ArrayList;
import java.util.List;

public class EmailItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

	List<EmailItemModel> items;
	List<EmailItemModel> itemsAll;

	public EmailItemAdapter(List<EmailItemModel> items) {
		this.items = items;
		itemsAll = new ArrayList<>(items);
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_mail, viewGroup, false);
		return new EmailViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
		EmailViewHolder viewHolder1 = (EmailViewHolder) viewHolder;
		EmailItemModel item = items.get(i);
		viewHolder1.textLetter.setText(item.getName().substring(0,1));
		Drawable background = ((EmailViewHolder) viewHolder).textLetter.getBackground();
		background.setColorFilter(new PorterDuffColorFilter(item.getColor(), PorterDuff.Mode.SRC_ATOP));
		viewHolder1.textSubject.setText(item.getSubject());
		viewHolder1.textContent.setText(item.getContent());
		viewHolder1.textTime.setText(item.getTime());
		viewHolder1.textName.setText(item.getName());
		if(item.isIsfav()){
			viewHolder1.imageFav.setImageResource(R.drawable.ic_star_black_24dp);
		}else
			viewHolder1.imageFav.setImageResource(R.drawable.star_boder);

	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	@Override
	public Filter getFilter() {
		return emailFilter;
	}
	private Filter emailFilter = new Filter(){


		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			List<EmailItemModel> fileredList = new ArrayList<>();
			if(constraint == null || constraint.length() == 0){
				fileredList.addAll(itemsAll);
			}else{
				String filterPattern = constraint.toString().toLowerCase().trim();
				for(EmailItemModel item : itemsAll){
					if(item.getName().toLowerCase().contains(filterPattern)){
						fileredList.add(item);
					}
				}
			}

			FilterResults results = new FilterResults();
			results.values = fileredList;
			return results;

		}

		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {

			items.clear();
			items.addAll((List) results.values);
			notifyDataSetChanged();
		}
	};

	class EmailViewHolder extends RecyclerView.ViewHolder{
		TextView textLetter;
		TextView textName;
		TextView textSubject;
		TextView textContent;
		TextView textTime;
		ImageView imageFav;
		public EmailViewHolder(@NonNull View itemView) {
			super(itemView);
			textLetter = itemView.findViewById(R.id.text_letter);
			textName = itemView.findViewById(R.id.text_name);
			textSubject = itemView.findViewById(R.id.text_subject);
			textContent = itemView.findViewById(R.id.text_content);
			textTime = itemView.findViewById(R.id.text_time);
			imageFav = itemView.findViewById(R.id.img_fav);

			imageFav.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					boolean isFav = items.get(getAdapterPosition()).isIsfav();
					items.get(getAdapterPosition()).setIsfav(!isFav);
					notifyDataSetChanged();

				}
			});
		}
	}
	public void filterList(ArrayList<EmailItemModel> fileredList){
		items = fileredList;
		notifyDataSetChanged();
	}
//	public void filterFavList(ArrayList<EmailItemModel> fileredList){
//		items = fileredList;
//		notifyDataSetChanged();
//	}
}
