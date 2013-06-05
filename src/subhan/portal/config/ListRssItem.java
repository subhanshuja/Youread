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

package subhan.portal.config;

import java.util.ArrayList;
	 
public class ListRssItem {
		private String contributorImageUrl;
		private String itemTitle;
		private String itemContent;
		private String itemContributor;
		private String itemPubDate;
		private String itemSummary;
		private String itemLink;
		private String category;	
		private ArrayList<String> listCategory = new ArrayList<String>();
	 
		public ListRssItem() {
			listCategory = new ArrayList<String>();
		}
	 
		public ListRssItem(String itemTitle, String itemPubDate, String itemSummary) {
			listCategory = new ArrayList<String>();
			this.itemTitle = itemTitle;
			this.itemPubDate = itemPubDate;
			this.itemSummary = itemSummary;
		}
	 
		public ListRssItem(String contributorImageUrl, String itemTitle,
				String itemContributor, String itemPubDate, String itemSummary) {
			listCategory = new ArrayList<String>();
			this.contributorImageUrl = contributorImageUrl;
			this.itemTitle = itemTitle;
			this.itemContributor = itemContributor;
			this.itemPubDate = itemPubDate;
			this.itemSummary = itemSummary;
		}
	 
		public String getContributorImageUrl() {
			return contributorImageUrl;
		}
	 
		public void setContributorImageUrl(String contributorImageUrl) {
			this.contributorImageUrl = contributorImageUrl;
		}
	 
		public String getItemTitle() {
			return itemTitle;
		}
	 
		public void setItemTitle(String itemTitle) {
			this.itemTitle = itemTitle;
		}
	 
		public String getItemContent() {
			return itemContent;
		}
	 
		public void setItemContent(String itemContent) {
			this.itemContent = itemContent;
		}
	 
		public String getItemContributor() {
			return itemContributor;
		}
	 
		public void setItemContributor(String itemContributor) {
			this.itemContributor = itemContributor;
		}
	 
		public String getItemPubDate() {
			return itemPubDate;
		}
	 
		public void setItemPubDate(String itemPubDate) {
			this.itemPubDate = itemPubDate;
		}
	 
		public String getItemSummary() {
			return itemSummary;
		}
	 
		public void setItemSummary(String itemSummary) {
			this.itemSummary = itemSummary;
		}
	 
		public String getItemLink() {
			return itemLink;
		}
	 
		public void setItemLink(String itemLink) {
			this.itemLink = itemLink;
		}
	 
		public void setItemCategory(String itemCategory) {
			listCategory.add(itemCategory);
		}
	 
		public ArrayList<String> getListCategory() {
			return listCategory;
		}
	 
		public void setListCategory(ArrayList<String> listCategory) {
			this.listCategory = listCategory;
		}
		
		public String listCategoryToString(){
			String result = "";
			for(int i=0;i<listCategory.size();i++){
				if(i==listCategory.size()-1){
					result += listCategory.get(i);
				}else{
					result += listCategory.get(i)+", ";
				}						
			}
			return result;
		}
	 
		public String getCategory() {
			return category;
		}
	 
		public void setCategory(String category) {
			this.category = category;
		}
}
