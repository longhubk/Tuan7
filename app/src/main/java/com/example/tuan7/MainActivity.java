package com.example.tuan7;

import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tuan7.adapters.ItemAdapter;
import com.example.tuan7.adapters.MultiLayoutItemAdapter;
import com.example.tuan7.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    List<ItemModel> items;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();

        items.add(new ItemModel("Item 1", R.drawable.thumb1));
        items.add(new ItemModel("Item 1", R.drawable.thumb1, false));
        items.add(new ItemModel("Item 3", R.drawable.thumb1));
        items.add(new ItemModel("Item 1", R.drawable.thumb1, false));
        items.add(new ItemModel("Item 1", R.drawable.thumb1, false));
        items.add(new ItemModel("Item 1", R.drawable.thumb1));
        items.add(new ItemModel("Item 1", R.drawable.thumb1));
        items.add(new ItemModel("Item 1", R.drawable.thumb1));
        items.add(new ItemModel("Item 1", R.drawable.thumb1));
        items.add(new ItemModel("Item 1", R.drawable.thumb1));
        items.add(new ItemModel("Item 1", R.drawable.thumb1, false));
        items.add(new ItemModel("Item 1", R.drawable.thumb1));
        items.add(new ItemModel("Item 1", R.drawable.thumb1));
        items.add(new ItemModel("Item 1", R.drawable.thumb1));

        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, true);

//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);

        //RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL );

        recyclerView.setLayoutManager(layoutManager);
        adapter = new ItemAdapter(items, this);
//        adapter = new MultiLayoutItemAdapter(items);



        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int pos = viewHolder.getAdapterPosition();
                items.remove(pos);
                adapter.notifyItemRemoved(pos);

            }
        };
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(new ItemModel("Item 2", R.drawable.thumb2) );
                adapter.notifyItemInserted(items.size() - 1);
            }
        });

        findViewById(R.id.btn_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(0);
                adapter.notifyItemRemoved(0);
            }
        });

        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.get(0).setTitle("Change");
                adapter.notifyItemChanged(0);
            }
        });
    }

    @Override
    public void OnItemClick(int position) {
        Log.v("TAG", items.get(position).getTitle() + "is Selected");

    }
}
