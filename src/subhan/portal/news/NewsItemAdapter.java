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
 * Kontribusi : Luthfi Hariz (lavalyst[at]gmail[dot]com)
 * Projek     : Aplikasi Portal FST Android (Youread)
 * Lokasi     : Pusdatin FST UIN Syarif Hidayatullah Jakarta
 * 
 */

package subhan.portal.news;

import subhan.portal.R;
import subhan.portal.config.ListRssItem;

import java.util.List;
 
import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsItemAdapter extends ArrayAdapter<ListRssItem> {

		ViewHolder holder;
		
		public NewsItemAdapter(Context context, List<ListRssItem> objects) {
			super(context, 0, objects);
		}
	 
		
		public View getView(int position, View convertView, ViewGroup parent) {
	 
			View rowView = convertView;	
	 
			ListRssItem listItem = getItem(position);
			if (rowView == null) {
				LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
						Context.LAYOUT_INFLATER_SERVICE);
				rowView = vi.inflate(R.layout.news_item, null);
	 
				holder = new ViewHolder();
				holder.title = (TextView) rowView
						.findViewById(R.id.title_news);			
				holder.pubDate = (TextView) rowView
						.findViewById(R.id.date_news);			
	 
				Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
						"font/ROBOTO-CONDENSED.TTF");
	 
				holder.title.setTypeface(tf, 1);
				holder.pubDate.setTypeface(tf);
	 
				rowView.setTag(holder);
			} else {
				holder = (ViewHolder) rowView.getTag();
			}
	 
			holder.title.setText(Html.fromHtml(listItem.getItemTitle()));
			holder.pubDate.setText(listItem.getItemPubDate());				
			
			return rowView;
		}
	 
	 
		static class ViewHolder {
			TextView title;
			TextView pubDate;		
		}	 
}


