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

public class SistemInformasiActivity extends SherlockActivity {

	TextView description;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		
		setContentView(R.layout.activity_sistem_informasi);
		
		getSupportActionBar()
		.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.ab_bg_black));
		
		StringBuilder builder = new StringBuilder();
			for(String dialog : SI){
				builder.append(dialog).append("\n\n");
			}
			
		description = (TextView)findViewById(R.id.tv_description);
		description.setText(builder.toString());
	}

	public static final String[] SI = new String[]{
		
		"Program Studi Sistem Informasi bertujuan menghasilkan "+
		"Sarjana Komputer yang memiliki pemahaman teoritis dan "+
		"empiris bidang Sistem Informasi, profesionalitas, "+
		"integritas, etika dan sikap Islami sehingga mampu menganalisis "+
		"dan memecahkan berbagai persoalan bidang Sistem Informasi "+
		"bagi peningkatan kualitas hidup masyarakat. Lulusan Program  "+
		"Studi Sistem Informasi diharapkan memiliki pengetahuan "+
		"dan kemampuan dalam hal :",
		
		"a) Kemampuan menganalisis, merancang, menerapkan dan memelihara  "+
		"	Sistem Informasi pada organisasi yang berbasis "+
		"   teknologi informasi dan komunikasi"+
		"b) Prinsip-prinsip dasar keislaman dan keindonesiaan sehingga"+ 
		"   mempunyai karakter kepribadian dan kepemimpinan "+
		"   yang baik dan dapat memberikan contoh panutan di masyarakat."+
		"c) Kompetensi profesional untuk bekerja sebagai praktisi"+
		"	bidang Sistem Informasi, antara lain sebagai "+
		"	1) System Analisyt. "+
		"   2) Project Manager. "+
		"   3) Application Consultant. "+
		"	4) Geographic Information System (GIS) specialist. "+
		"	5) Syariah Accounting Information System (SAIS) specialist. "+
		"d) Kemampuan akademik tinggi untuk dapat melanjutkan pendidikan "+
		"	ke jenjang lebih tinggi. "+
		"e) Kesempatan untuk mengambil program sertifikasi profesional"+
		"	secara internasional seperti "+
		"	1) Cisco Networking Academy Program (CNAP). "+
		"	2) Oracle Workforce Development Program (OWDP). "+
		"	3) Microsoft Certified Professional. "+
		" 	4) GIS sertification. "+
		"   5) System Analyst Certification."+
		"	6) Project Management Certification.",
		
		"Program Studi Sistem Informasi mentargetkan untuk menghasilkan"+
		"tenaga profesional dalam bidang pengembangan Sistem Informasi"+
		"pada suatu organisasi modern yang berbasis Teknolologi Informasi "+
		"dan Komunikasi, berkonsentrasi pada tiga bidang, yaitu :"+
		
		" 1. Sistem Informasi Korporasi (Enterprise Information System)."+
		" 2. Sistem Informasi Geografis (Geographic Information System)."+
		" 3. Sistem Informasi Bisnis Syariah (Syar’i Business Information System)",
		
		"Keahlian pengolahan dan pengelolaan data secara elektronik "+
		"merupakan kebutuhan umum bagi seluruh instansi dan lembaga, "+
		"baik lembaga pemerintah maupun swasta. Karena itu,lulusan  "+
		"Prodi Sistem Informasi memiliki prospek lapangan kerja yang sangat luas."+
		"Lulusan dapat bekerja di berbagai bidang kerja sebagai "+
		"System Analisyt, Project Manager, Application Consultant,"+
		"Geographic Information System (GIS) specialist, "+
		"Syariah Accounting Information System (SAIS) specialist, wirausahawan TIK,"+
		"studi lanjut mengarah ke dosen atau staf penelitian dan lain-lain.",

	};

}
