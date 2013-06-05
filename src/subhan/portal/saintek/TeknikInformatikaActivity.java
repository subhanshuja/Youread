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

public class TeknikInformatikaActivity extends SherlockActivity {

	
	TextView description;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		
		setContentView(R.layout.activity_teknik_informatika);
		
		getSupportActionBar()
		.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.ab_bg_black));
		
		StringBuilder builder = new StringBuilder();
			for(String dialog : TI){
				builder.append(dialog).append("\n\n");
			}
		
		description = (TextView)findViewById(R.id.tv_description);
		description.setText(builder.toString());
	}

	public static final String[] TI = new String[]{
		
		"Program Studi Teknik Informatika bertujuan "+
		"menghasilkan sarjana komputer yang memiliki "+
		"pemahaman teori dan metode di bidang teknik informatika, "+
		"profesionalitas dan integritas, serta etika dan "+
		"sikap Islami sehingga mampu menganalisisdan memecahkan "+
		"berbagai persoalan di bidang informatika dan "+
		"teknologi informasi yang bermanfaat bagi peningkatan "+
		"hidup masyarakat. Di samping keahlian umum informatika,"+
		"Prodi Teknik Informatika mengembangkan keahlian spesifik "+
		"dalam bentuk konsentrasi atau peminatan, yang terdiri dari :",
		
		"1) Keamaanan dan Jaringan komputer (Securty and networking) meliputi :",
		"	A. Local area network (LAN)"+
		"   B. Internet dan keamanan data"+ 
		"   C. Manajemen jaringan dan komunikasi data",
		
		"2) Software engineering (rekayasa perangkat lunak) :",
		"	A. Pemograman untuk berbagai aplikasi"+
		"	B. Website design",
		
		"3) Keahlian Kreative Multimedia & Broadcasting :",
		"	A. animasi dan design grafis "+
		"	B. komunikasi visual "+
		"   C. konsep broadcast (pemberitaan)",
		
		"Lulusan dengan keahlian spesifik sesuai peminatan "+
		"(konsentrasi) dapat memasuki areal dunia kerja yang . "+
		"Hampir setiap perusahaan, lembaga penelitian, "+
		"sangat luaslembaga swadaya masyarakat (LSM), "+
		"lembaga pendidikan memerlukan tenaga ahli dalam "+
		"bidang jaringan komputer, rekayasa perangkat lunak "+
		"untuk berbagai aplikasi yang memerlukan pemograman "+
		"sesuai kebutuhan instansi. ",
	};
}
