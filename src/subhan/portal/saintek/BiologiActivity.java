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

public class BiologiActivity extends SherlockActivity {

	TextView description;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		
		setContentView(R.layout.activity_biologi);
		
		getSupportActionBar()
		.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.ab_bg_black));
		
		StringBuilder builder = new StringBuilder();
			for(String dialog : BIOLOGI){
				builder.append(dialog).append("\n\n");
			}
		
		description = (TextView)findViewById(R.id.tv_description);
		description.setText(builder.toString());
	}

	public static final String[] BIOLOGI = new String[]{
		
		"Program Studi Biologi bertujuan untuk menghasilkan " +
		"sarjana sains di bidang biologi yang memiliki tingkat " +
		"profesionalisme yang cukup tinggi, memiliki kepribadian " +
		"Islam dan memiliki kemampuan dasar ilmu-ilmu Islam " +
		"sebagai basis pengembangan sains. Prodi Biologi diarahkan " +
		"pada konsentrasi di bidang bioteknologi dan lingkungan, " +
		"serta tetap berpegang pada prinsip-prinsip biologi " +
		"dan lingkungan serta menjunjung tinggi nilai-nilai Islami. " +
		"Dengan konsentrasi pada bioteknologi, lulusan akan memiliki" +
		"kemampuan untuk menganalisis produk dan mengelola pencemaran " +
		"lingkungan dengan pendekatan ilmu biologi. Untuk menopang " +
		"keahlian di bidang bioteknologi dan lingkungan,lulusan " +
		"dibekali dengan kemampuan analisisis dan operasional " +
		"berbagai alat analitik dan instrumentasi, seperti : ",
		
		"A. GC-MS " +
		"B. FTIR" +
		"C. HPLC" +
		"D. AAS dan," +
		"E. alat laboratorium standar lainnya.",
		
		"Lulusan Prodi Biologi FST UIN memiliki prospek untuk" +
		"bekerja pada berbagai industri, baik industri hulu maupun" +
		"hilir, khususnya industri yang berbasis bioteknologi dan " +
		"pengelolaan lingkungan. Disamping itu, dapat bekerja pada ",
		
		"A. lembaga penelitian" +
		"B. konsultan lingkungan dan pangan" +
		"C. BPLHD" +
		"D. Departemen" +
		"E. LSM " +
		"F. dan dunia pendidikan.",		 
		
	};
}
