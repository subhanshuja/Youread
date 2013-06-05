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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import subhan.portal.MainActivity;
import subhan.portal.R;
import subhan.portal.config.ListRssItem;
import subhan.portal.config.Util;
import subhan.portal.dailysocial.DailySocialActivity;
import subhan.portal.news.NewsItemAdapter;
import subhan.portal.saintek.SaintekActivity;

//Library Android
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

public class DailySocialActivity extends SherlockActivity {
	
	/*private static final String TAG ="DailySocialActivity";*/
	//
	private static final String RSS_DAILY_SOCIAL = "http://dailysocial.net/feed";
	private static final String FILE_DAILY_SOCIAL = "dailysocial.xml";
	private ArrayList<ListRssItem> aListRssItems;
	private ListView newsListView;
	private com.actionbarsherlock.view.MenuItem refresh = null;
	private ParserXML parserXML;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daily_social);
	    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		newsListView = (ListView) findViewById(R.id.lv_news_daily_social);
		parserXML = new ParserXML();
		
		newsListView
		.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(DailySocialActivity.this,
						NewsViewDSActivity.class);
				
				intent.putExtra("title", aListRssItems.get(position)
						.getItemTitle());
				Log.i("youread_title",aListRssItems.get(position).getItemTitle());
				intent.putExtra("description",
						aListRssItems.get(position).getItemSummary());
				intent.putExtra("content", aListRssItems.get(position)
						.getItemContent());
				intent.putExtra("pubdate", aListRssItems.get(position)
						.getItemPubDate());
				intent.putExtra("author", aListRssItems.get(position)
						.getItemContributor());
				intent.putExtra("link", aListRssItems.get(position)
						.getItemLink());
				Log.i("youread_link",aListRssItems.get(position).getItemLink());
				startActivity(intent);
			}
		});
	}
	
	protected void onResume(){
		super.onResume();
		try {
			parserXML.execute();
		} catch (IllegalStateException e) {
		}
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_daily_social, menu);
		refresh = menu.findItem(R.id.refresh);
		/*refreshNews();*/
		return super.onCreateOptionsMenu(menu);
	}
	
	public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent i = new Intent(this,MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			return true;
		case R.id.refresh:
			refreshNews();
			return true;
		default : 
			return true;
		}
	}
	
	/*protected void onResume() {
		super.onResume();
		try {
			parserXML.execute();
		} catch (IllegalStateException e) {
		}
	}*/
	
	public void refreshNews(){
		LayoutInflater inflater = (LayoutInflater) DailySocialActivity.this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ImageView iv = (ImageView) inflater.inflate(
				R.layout.refresh_action, null);
		/*Animation rotation = AnimationUtils.loadAnimation(
				DailySocialActivity.this, R.drawable.refresh_animation);
		rotation.setRepeatCount(Animation.INFINITE);
		iv.startAnimation(rotation);*/
		refresh.setActionView(iv);
		new DownloadFeed().execute();
	}
	
	class DownloadFeed extends AsyncTask<String, Void, Void>{

		@Override
		protected Void doInBackground(String... params) {
			try {
				Util.downloadFromUrl(RSS_DAILY_SOCIAL, FILE_DAILY_SOCIAL);
			} catch (Exception e) {
				e.printStackTrace();
				DailySocialActivity.this.runOnUiThread(new Runnable() {
					
					public void run() {
						Toast.makeText(DailySocialActivity.this,
					" Tidak berhasil perbarui berita ", 
					Toast.LENGTH_SHORT).show();
					}
				});
			}
			return null;
		}
		
		protected void onPostExecute(Void result) {
			new ParserXML().execute();
			//completeRefresh();
		}
		
	}
	
	class ParserXML extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			aListRssItems = new ArrayList<ListRssItem>();
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(new File(
				android.os.Environment.getExternalStorageDirectory()
								+"/youread",FILE_DAILY_SOCIAL));
				new NewsFeedHandler().parseContent(inputStream);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		protected void onPostExecute(Void result) {
			NewsItemAdapter newsItemAdapter = new NewsItemAdapter(
					DailySocialActivity.this, aListRssItems);
			newsListView.setAdapter(newsItemAdapter);
		}
		
	}
	
	class NewsFeedHandler extends DefaultHandler{
		StringBuffer sBuffer = new StringBuffer();
		boolean item = false;
		ListRssItem rssItem;
		
		public void parseContent(InputStream is){
			try {
				SAXParserFactory parserFactory = SAXParserFactory.newInstance();
				SAXParser saxParser = parserFactory.newSAXParser();
				XMLReader xmlReader = saxParser.getXMLReader();
				xmlReader.setContentHandler(this);
				InputSource inputSource = new InputSource(is);
				xmlReader.parse(inputSource);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SAXException saxe){
				saxe.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
		}
		
		public void startElement(String uri, String localName, String qName,
				Attributes attributes)throws SAXException {
			
			sBuffer = new StringBuffer();
			if (localName.equalsIgnoreCase("item")) {
				rssItem = new ListRssItem();
				item = true;
			}
			
		}
		
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if (item) {
				if (localName.equalsIgnoreCase("title")
						&& rssItem.getItemTitle() == null) {
					rssItem.setItemTitle(sBuffer.toString());
				}
				if (localName.equalsIgnoreCase("description")
						&& rssItem.getItemSummary() == null) {
					rssItem.setItemSummary(sBuffer.toString());
				}
				if (localName.equalsIgnoreCase("link")
						&& rssItem.getItemLink() == null) {
					rssItem.setItemLink(sBuffer.toString());
				}
				if (localName.equalsIgnoreCase("pubDate")
						&& rssItem.getItemPubDate() == null) {
					String pubDate = sBuffer.toString().replace("+0000", "");
					rssItem.setItemPubDate(pubDate);
				}
				if (localName.equalsIgnoreCase("category")
						&& rssItem.getCategory() == null) {
					rssItem.setCategory(sBuffer.toString());
				}
				if (localName.equalsIgnoreCase("encoded")
						&& rssItem.getItemContent() == null) {
					rssItem.setItemContent(sBuffer.toString());
				}
				if (localName.equalsIgnoreCase("creator")
						&& rssItem.getItemContributor() == null) {
					rssItem.setItemContributor(sBuffer.toString());
				}
				if (localName.equalsIgnoreCase("item")) {
					aListRssItems.add(rssItem);
				}
			}
		}
 
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			sBuffer.append(new String(ch, start, length));
		}
	
	}	
}
