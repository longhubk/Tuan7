package com.example.tuan7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tuan7.adapters.RecycleViewAdapter;
import com.example.tuan7.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

	List<List<ItemModel>> itemss;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		itemss = new ArrayList<>();
		for (int i = 0; i < 10 ; i++) {
			List<ItemModel> items = new ArrayList<>();
			for (int j = 0; j < 10 ; j++) {
				items.add(new ItemModel("Item " + i + "-" + j, R.drawable.thumb1));
			}
			itemss.add(items);
		}
		RecyclerView recyclerView = findViewById(R.id.recycle_view1);
		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);
		RecycleViewAdapter adapter = new RecycleViewAdapter(this, itemss);
		recyclerView.setAdapter(adapter);

	}
}
