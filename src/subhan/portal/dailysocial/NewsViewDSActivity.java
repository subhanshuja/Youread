/*
 * Copyright (C) 2013 Pusdatin FST Saintek UIN Syarif Hidayatullah Jakarta 
 * Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*  	
 * Library UI : ActionBarSherlockHolmes (Jake Wharton) 
 *  
 * Programmer : Subhan Nooriansyah ( subhan.nooriansyah[at]gmail[dot]com )
 * Projek     : Aplikasi Portal FST Android (Youread)
 * Lokasi     : Pusdatin FST UIN Syarif Hidayatullah Jakarta
 * 
 */

package subhan.portal.dailysocial;


import subhan.portal.R;
import subhan.portal.config.ListRssItem;

import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockActivity;
 

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;


public class NewsViewDSActivity extends SherlockActivity {
	
	private ArrayList<ListRssItem> newsItem;
	ListView view;
	int position;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_ds);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		showNews();
	}
	
	public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent i = new Intent(NewsViewDSActivity.this, DailySocialActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			return true;
		default : 
			return true;
		}
	}
	
	public void showNews(){
		
		Intent intent = getIntent();
		String Title = intent.getStringExtra("title");
		String Content = intent.getStringExtra("content");
		String PubDate = intent.getStringExtra("pubdate");
		String Author = intent.getStringExtra("author");
		final String Link = intent.getStringExtra("link");
		
		TextView title = (TextView)findViewById(R.id.title_ds);
		title.setText(Title.toString());
		TextView pubdate = (TextView)findViewById(R.id.pubdate_ds);
		pubdate.setText(PubDate.toString());
		TextView content = (TextView)findViewById(R.id.content_ds);
		content.setText(Html.fromHtml(Content.toString()));
		TextView author = (TextView)findViewById(R.id.author_ds);
		author.setText(Author.toString());
		TextView link = (TextView)findViewById(R.id.link_ds);
		link.setText(Link.toString());
		link.setHighlightColor(Color.BLUE);
		
		link.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(Link));
				startActivity(i);
			}
		});
		
		
			
	}
}


