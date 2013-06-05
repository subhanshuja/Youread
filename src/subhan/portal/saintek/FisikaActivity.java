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

public class FisikaActivity extends SherlockActivity {

	TextView description;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		setContentView(R.layout.activity_fisika);
		
		getSupportActionBar()
		.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.ab_bg_black));
		
		StringBuilder builder = new StringBuilder();
			for(String dialog : FISIKA){
				builder.append(dialog).append("\n\n");
			}
		
		description = (TextView)findViewById(R.id.tv_description);
		description.setText(builder.toString());
	}

	public static final String[] FISIKA = new String[]{
		
		"Program studi Fisika bertujuan untuk menghasilkan sarjana sains" +
		"di bidang fisika yang memiliki tingkat profesionalisme" +
		"yang cukup tinggi, memiliki kepribadian Islam dan memiliki " +
		"kemampuan dasar ilmu-ilmu Islam sebagai basis pengembangan sains." +
		"Secara lebih spesifik, Prodi Fisika bertujuan untuk menghasilkan" +
		"lulusan yang memiliki integritas kepribadian dan akhlak yang " +
		"tinggi sebagai sarjana sains bidang fisika, memiliki pola " +
		"pikir yang logis dan sistematis dalam merumuskan dan memecahkan" +
		"masalah, serta memiliki kepekaan terhadap kepentingan masyarakat" +
		"dan lingkungan, memiliki kemampuan bekerja di bidangnya, memiliki" +
		"kemandirian untuk berkembang serta meneruskan ke jenjang pendidikan " +
		"yang lebih tinggi, memiliki daya analisis dan kreativitas yang " +
		"tinggi dalam memecahkan berbagai permasalahan, mampu bersaing " +
		"di pasar global, serta memiliki wawasan tauhiddalam pengembangan" +
		"sains fisika. Program studi Fisika diarahkan pada konsentrasi " +
		"sebagai berikut :",
		
		"A. Fisika Instrumentasi, melakukan kajian sains dan teknologi " +
		"   bidang instrumentasi yang meliputi sistem informasi, proses" +
		"   yang terjadi pada sistem sensor, mikroprosesor, dan pengelolaan" +
		"   pada sistem sinyal dan digital, sehingga lulusan dapat mengikuti" +
		"   perkembangan teknologi yang terkait dengan bidang instrumentasi.",
		
		"B. Fisika Inti Radiasi, melakukan kajian sains dan teknologi mutakhir" +
		"   di bidang tenaga nuklir yang meliputi proses terjadinya radiasi," +
		"   instrumen yang digunakan untuk mendeteksi radiasi, efek-efek yang" +
		"   ditimbulkan dari radioaktif, serta cara untuk pencegahannya.",
		
		"C. Geofisika, melakukan kajian mutakhir di bidang geologi yang " +
		"	menyangkut prinsip stratigrafi, sesmik eksplorasi dengan berbagai " +
		"	metodenya dan pengindraan jarak jauh yang kesemuanya merupakan " +
		"	prinsip-prinsip utama yang diperlukan untuk mengetahui dan " +
		"	mendeteksi keberadaan bahan tambang dan minyak bumi.",
		
		"D. Fisika Material, melakukan kajian terhadap sains dan teknologi" +
		" 	mutakhir di bidang industri, khususnya dalam proses pemilihan " +
		"	dan pembuatan material yang memiliki nilai lebih, dengan " +
		"	mengetahui struktur kristalnya, ikatan antar atom dan molekulnya," +
		"	perubahan termodinamika dan sifat-sifat fisiknyayang dapat dianalisis " +
		"	dengan menggunakan proses difraksi sinar X. Lulusan Prodi " +
		"	Fisika dapat bekerja berwirausaha dalam bidang komputasi, " +
		"	juga dalam bidang usaha konsultasi dalam bidang komputasi " +
		"	dan elektronika; pertambangan dan instrumentasi. " +
		"	Para lulusan juga akan sangat dibutuhkan oleh berbagai " +
		"	perusahaan dan industri yang melakukan kagiatan dalam bidang " +
		"	eksplorasi dan pertambangan, komputasi dan mikro prosesor, " +
		"	serta poerusahaan yang melakukan analisis material. " +
		"	Di samping itu, lulusan dapat menjadi akademisi, " +
		"	seperti staf pengajar dan peneliti, baik swasta maupun negeri.",
	};

}
