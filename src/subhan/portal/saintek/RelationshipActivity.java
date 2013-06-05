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
import com.actionbarsherlock.view.Window;

import subhan.portal.R;
import android.os.Bundle;
import android.widget.TextView;

public class RelationshipActivity extends SherlockActivity {

	TextView title;
	TextView description;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_MODE_OVERLAY);
		
		setContentView(R.layout.activity_relationship);
		
		getSupportActionBar()
		.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.ab_bg_black));
		
		StringBuilder builder = new StringBuilder();
			for(String dialog : Relationship){
				builder.append(dialog).append("\n\n");
			}
		
		
		title = (TextView)findViewById(R.id.tv_title);
		title.setText("Latar Belakang");
		
		description = (TextView)findViewById(R.id.tv_description);
		description.setText(builder.toString());
	}

	public static final String[] Relationship = new String[]{
		
		"Terdorong oleh hasrat untuk melakukan " +
		"kerjasama dengan berbagai pihak dalam " +
		"mengembangkan sains dan teknologi,"+
		"dan dalam mewujudkan interasi keilmuan, " +
		"khususnya di bidang teknik informatika " +
		"dan sistem informasi, maka sejak " +
		"tahun ajaran 2009/2010 Fakultas Sains " +
		"dan Teknologi (FST) bekerjasama dengan ",
		
		"Fakultas Teknik Universitas Indonesia (FTUI)"+
		"menyelenggarakan pembelajaran bersama dengan pola 2:2, "+
		"yakni dua tahun pertama di FTUI, dan dua tahun " +
		"berikutnya atau sampai memperoleh " +
		"gelar sarjana di FST-UIN.",
		
		"Dalam kerjasama ini, FTUI menyelenggarakan " +
		"dua peminatan, yakni: peminatan sofware track " +
		"dan peminatan network track."+
		"Selanjutnya, mulai tahun ajaran 2010/2011, " +
		"FTUI menyelenggarakan peminatan Sharia Banking " +
		"Informaton Technolog " +
		"(Teknologi Informasi Perbankan Syariah).",
		
		"Seluruh peminatan tersebut dapat melanjutkan " +
		"pada Program S-1 (Proram Sajana) Program Studi " +
		"Teknik Informatika dan Sistem Informasi " +
		"FST-UIN dengan mekanisme penyetaraan kurikulum.",
		
		"Artinya, FST-UIN mengakui sejumlah mata kuliah yang "+
		"diselenggarakan oleh FTUI. Dengan sendirinya, " +
		"mahasiswa FST-UIN yang berasal dari FTUI melalui " +
		"mekanisme kerjasama ini tidak perlu mengambil mata " +
		"kuliah yang sudah diakui oleh FST-UIN, dengan " +
		"syarat mahasiswa tersebut memperoleh " +
		"nilai B atau setara dengan B. Jumlah SKS Yang Diakui " +
		"oleh FST-UIN bagi mahasiswa Program Kerjasama FTUI ini " +
		"maksimal sebanyak 68 SKS tergantung pada peminatan yang " +
		"diambil mahasiswa di FTUI, dan tergantung pada peminatan " +
		"yang dipilih mahasiswa di FST-UIN.",
		
		"Untuk Prodi Teknik Informatika di FST terdapat " +
		"tiga peminatan, yakni :"+
		"	A) Sofware Engineering (SE) " +
		"	B) Networking (N) " +
		"	C) Multi Media (MM) ",
		
		"Untuk Prodi Sistem Informasi di FST-UIN terdapat " +
		"tiga peminatan, yakni:"+
		"	A) Sistem Informasi Korporasi (SIK)"+
		"	B) Sistem Informas Geografi (SIG)" +
		"	C) Sistem Informasi Bisnis Syariah (SIBIS)",
	};

}
