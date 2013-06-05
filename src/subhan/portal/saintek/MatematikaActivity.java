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

public class MatematikaActivity extends SherlockActivity {

	TextView description;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		
		setContentView(R.layout.activity_matematika);
		
		getSupportActionBar()
		.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.ab_bg_black));
		
		StringBuilder builder = new StringBuilder();
			for(String dialog : MATEMATIKA){
				builder.append(dialog).append("\n\n");
			}
		
		description = (TextView)findViewById(R.id.tv_description);
		description.setText(builder.toString());
	}

	public static final String[] MATEMATIKA = new String[]{
		
		"Program Studi Matematika bertujuan untuk menghasilkan " +
		"sarjana matematika yang memiliki wawasan akademik dan " +
		"kemampuan profesional yang handal di bidang matematika " +
		"informatika dan terapan serta mampu menerapkan model " +
		"matematika pada lingkungan organisasi/institusi yang " +
		"menjadi tempat bekerja lulusan;  serta mampu mengembangkan " +
		"matematika dengan memadukan internalisasi nilai-nilai Islam " +
		"sejalan dengan situasi dan kondisi yang berkembang ke arah " +
		"masyarakat yang lebih terbuka, sehingga dapat memberikan " +
		"layanan sesuai harapan masyarakat. Program Studi matematika " +
		"memiliki konsentrasi pada : ",
		
		"1) Statistika, menekankan pada penerapan matematika dalam " +
		"	analisis seperti statistika, Riset Operasi, dan ilmu-ilmu" +
		"	dasar lain. Melalui konsep pemodelan sistem, matematika " +
		"	dapat digunakan untuk memecahkan berbagai persoalan, " +
		"	baik untuk pengembangan ilmu maupun untuk berbagai " +
		"	keperluan praktis. ",
		
		"2) Matematika Informatika, menekankan pada pengembangan " +
		"	dasar-dasar matematika dan komputasi, sehingga " +
		"	akan menghasilkan lulusan yang mampu membuat solusi " +
		"	komputasi yang optimal dari berbagai persoalan, " +
		"	baik ilmiah maupun praktis. Lulusan program studi " +
		"	matematika diharapkan dapat melakukan berbagai " +
		"	kegiatan praktis, di samping mengembangkan ilmu " +
		"	bagi yang berminat. Karena itu, lulusan akan " +
		"	memiliki kesempatan untuk bekerja dalam berbagai " +
		"	bidang, baik bidang akademis maupun praktis, " +
		"	seperti berbagai perusahaan perdagangan, " +
		"	jasa, dan perbankan.",
	};

}
