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

import subhan.portal.R;
import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Window;

public class KimiaActivity extends SherlockActivity {

		TextView description;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		
		setContentView(R.layout.activity_kimia);
		
		getSupportActionBar()
		.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.ab_bg_black));
		
		StringBuilder builder = new StringBuilder();
			for(String dialog : KIMIA){
				builder.append(dialog).append("\n\n");
			}
		
		description = (TextView)findViewById(R.id.tv_description);
		description.setText(builder.toString());
	}

	public static final String[] KIMIA = new String[]{
		
		"Program Studi Kimia bertujuan untuk " +
		"menghasilkan sarjana sains di bidang kimia " +
		"yang memiliki pemahaman teori dan metode analisa, " +
		"professional dan memiliki integritas yang tinggi " +
		"serta memiliki etika dan sikap Islami sehingga " +
		"mampu menganalisis dan memecahkan berbagai persoalan " +
		"yang bermanfaat bagi peningkatan kualitas " +
		"hidup masyarakat. Prodi Kimia diarahkan pada "+
		"bidang kajian sebagai berikut :",
		
		"1) Kimia, memiliki arah kajian terhadap ilmu dasar kimia,"+
		"dengan bidang kajian atau penelitian sebagai berikut :"+
		"Kimia analitik, Kimia an-organik, Kimia organic,"+ 
		"Kimia fisik, dan Biokimia",
		
		"2) Kimia Terapan, yang dikembanghkan prodi kimia"+
		"MIPA FST UIN ialah kimia pangan, kimia industri, dan " +
		"kimia lingkungan,"+
		"kimia lingkungan dan kimia polimer dan Energi."+
		"Prospek lulusan program studi kimia untuk bekerja pada " +
		"berbagai industri, baik industri hulu maupun hilir. " +
		"Di samping itu, dapat bekerja pada "+
		"perusahaan yang bergerak dalam laboratorium pengujian " +
		"dan analitik, termasuk pengujian perminyakan dan barang " +
		"tambang lainnya.Lulusan juga dapat menjadi " +
		"peneliti atau konsultan.",
				  
	};

}
