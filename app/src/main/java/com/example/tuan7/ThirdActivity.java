package com.example.tuan7;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tuan7.adapters.EmailItemAdapter;
import com.example.tuan7.models.EmailItemModel;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

	List<EmailItemModel> items;
	EmailItemAdapter emailItemAdapter;
	Boolean isLisFav = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);

		EditText editText = findViewById(R.id.edit_text);
		editText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				filter(s.toString());

			}
		});


		findViewById(R.id.btn_mail).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isLisFav){
					filterFav(isLisFav);
					isLisFav = false;
				}else{
					filterFav(isLisFav);
					isLisFav = true;

				}
			}
		});


		items = new ArrayList<>();
		items.add(new EmailItemModel("Apple company", "iphone 12", "delay iphone", "10:20 PM", true));
		items.add(new EmailItemModel("Bphone x86", "Sell new Bphone", "delay sell", "8:30 PM", true));
		items.add(new EmailItemModel("Camstasia software", "sale off", "use to record screen", "6:50 PM", false));
		items.add(new EmailItemModel("Dream Honda", "made in Thai", "best choie at past", "5:30 PM", false));
		items.add(new EmailItemModel("Email anonymous", "hacker sent", "to all victims in window", "4:40 PM", true));
		items.add(new EmailItemModel("Fancy Juice", "very good", "a piece of cooktail", "4:09 PM", true));
		items.add(new EmailItemModel("Hook Kaido", "in japan", "a place beautiful", "3:00 PM", false));
		items.add(new EmailItemModel("Im Sama", "onepiece", "a fiction character on comic", "2:54 PM", false));
		items.add(new EmailItemModel("Knight dark", "joker vs batman", "a oscar movies", "2:30 PM", true));
		items.add(new EmailItemModel("League of legend", "game video", "best moba game", "1:20 PM", false));
		items.add(new EmailItemModel("Mario game", "nes game", "a common classic game", "1:20 PM", true));
		items.add(new EmailItemModel("Opera mini", "small browser", "smallest browser for mobile", "12:30 AM", false));
		items.add(new EmailItemModel("Phopho sunfuric", "science", "this is the symbol of.. ", "11:00 AM", true));
		items.add(new EmailItemModel("Queen Halley", "characer", "a Devil Character of DC", "10:02 AM", false));
		items.add(new EmailItemModel("Xmen 3", "Movies", "", "10:20 AM", false));
		items.add(new EmailItemModel("Yamaha R3", "Moto GP", "buy moto now", "10:03 AM", false));
		items.add(new EmailItemModel("Zoombie Land", "something", "zoombie attacked", "10:00 AM", false));

		RecyclerView recyclerView = findViewById(R.id.recycle_view);
		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);

		emailItemAdapter = new EmailItemAdapter(items);
		recyclerView.setAdapter(emailItemAdapter);



	}

	private void filter(String text){
		ArrayList<EmailItemModel> fileredList = new ArrayList<>();
		if(text.length() > 2){
			for(EmailItemModel item: items){
				if(item.getName().toLowerCase().contains(text.toLowerCase()) ||
					item.getSubject().toLowerCase().contains(text.toLowerCase())||
					item.getContent().toLowerCase().contains(text.toLowerCase())

				){
					fileredList.add(item);
				}

			}

		}else
			fileredList = (ArrayList<EmailItemModel>) items;

		emailItemAdapter.filterList(fileredList);
	}

	private void filterFav(boolean isFav){

		ArrayList<EmailItemModel> fileredList = new ArrayList<>();
		for(EmailItemModel item: items){
			if(isFav){
				if(item.isIsfav())
					fileredList.add(item);
			}else{
					fileredList.add(item);
			}
		}
		emailItemAdapter.filterList(fileredList);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mail_menu, menu);
		MenuItem searchItem = menu.findItem(R.id.action_search);
		SearchView searchView = (SearchView) searchItem.getActionView();
		searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			@Override
			public boolean onQueryTextSubmit(String query) {

				return false;
			}

			@Override
			public boolean onQueryTextChange(String newText) {
				emailItemAdapter.getFilter().filter(newText);
				return false;
			}
		});
		return true;
	}
}
