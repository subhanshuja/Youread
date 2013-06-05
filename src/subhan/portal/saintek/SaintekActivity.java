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

package subhan.portal.saintek;

import com.actionbarsherlock.app.SherlockActivity;
//import com.actionbarsherlock.view.Menu;

import subhan.portal.MainActivity;
import subhan.portal.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SaintekActivity extends SherlockActivity {
	
	TextView tv;
	ListView menuList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saintek);	
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	
		menuList = (ListView)findViewById(R.id.lv_menu);
		
		String[] items = {
				getResources().getString(R.string.kimia),
				getResources().getString(R.string.fisika),
				getResources().getString(R.string.biologi),
				getResources().getString(R.string.matematika),
				getResources().getString(R.string.sistem_informasi),
				getResources().getString(R.string.teknik_informatika),
				getResources().getString(R.string.pusdatin),
				getResources().getString(R.string.agribisnis),
				getResources().getString(R.string.kerjasama),
				getResources().getString(R.string.magister_agribisnis),
		};
		
		ArrayAdapter<String> adapater = new ArrayAdapter<String>(this, R.layout.menu_item, items);
		
		menuList.setAdapter(adapater);
		
		menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
				TextView tvClicked = (TextView) itemClicked;
				String strText = tvClicked.getText().toString();
				
				if (strText.equalsIgnoreCase(getResources().getString(R.string.kimia))) {
						Kimia();
				} else if (strText.equalsIgnoreCase(getResources().getString(R.string.fisika))){
						Fisika();
				} else if (strText.equalsIgnoreCase(getResources().getString(R.string.biologi))){
						Biologi();
				} else if (strText.equalsIgnoreCase(getResources().getString(R.string.matematika))){
						Matematika();
				} else if (strText.equalsIgnoreCase(getResources().getString(R.string.agribisnis))){
						Agribinis();
				} else if (strText.equalsIgnoreCase(getResources().getString(R.string.teknik_informatika))){
						TeknikInformatika();
				} else if (strText.equalsIgnoreCase(getResources().getString(R.string.sistem_informasi))){
						SistemInformasi();
				} else if (strText.equalsIgnoreCase(getResources().getString(R.string.pusdatin))){
						Pusdatin();
				} else if (strText.equalsIgnoreCase(getResources().getString(R.string.kerjasama))){
						Kerjasama();
				} else if (strText.equalsIgnoreCase(getResources().getString(R.string.magister_agribisnis))){
						MagisterAgriBisnis();
				}
			}
		});
		
		StringBuilder builder = new StringBuilder();
		for(String dialog : Profile){
			builder.append(dialog).append("\n");
		}
		
		tv = (TextView)findViewById(R.id.tv_profile);
		tv.setText(builder.toString());
	
	}

	public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent i = new Intent(this,MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			return true;
		default :
			return super.onOptionsItemSelected(item);
		}
	}
	
	public static final String [] Profile = new String[]{
		"Fakultas Saintek UIN Syarif Hidayatullah Jakarta yang terletak " +
		" disebelah Fakultas Ekonomi dan memiliki 7 jurusan yaitu Kimia," +
		" Fisika, Biologi, Matematika, Agribisnis, Sistem Informasi," +
		" Teknik Informatika dan kelas Asing ", 
	} ;
	
	public void Kimia(){
		Intent i = new Intent(SaintekActivity.this, KimiaActivity.class);
		startActivity(i);
	}
	
	public void Fisika(){
		Intent i = new Intent(SaintekActivity.this, FisikaActivity.class);
		startActivity(i);
	}
	
	public void Biologi(){
		Intent i = new Intent(SaintekActivity.this, BiologiActivity.class);
		startActivity(i);
	}
	
	public void Pusdatin(){
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse("http://www.fst.uinjkt.ac.id/Pusdatin/"));
		startActivity(i);
	}
	
	public void Kerjasama(){
		Intent i = new Intent(SaintekActivity.this, RelationshipActivity.class);
		startActivity(i);
	}
	
	public void Matematika(){
		Intent i = new Intent(SaintekActivity.this, MatematikaActivity.class);
		startActivity(i);
	}
	
	public void Agribinis(){
		Intent i = new Intent(SaintekActivity.this, AgribisnisActivity.class);
		startActivity(i);
	}
	
	public void SistemInformasi(){
		Intent i = new Intent(SaintekActivity.this, SistemInformasiActivity.class);
		startActivity(i);
	}
	
	public void TeknikInformatika(){
		Intent i = new Intent(SaintekActivity.this, TeknikInformatikaActivity.class);
		startActivity(i);
	}
	
	public void MagisterAgriBisnis(){
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse("http://www.fst.uinjkt.ac.id/magr/ "));
		startActivity(i);
	}

}
