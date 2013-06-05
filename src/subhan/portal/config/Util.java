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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.apache.http.util.ByteArrayBuffer;

public class Util {
	
	/*private static final String FILE_DAILY_SOCIAL = "dailysocial.xml";
	private static final String FILE_TEKNO_JURNAL = "teknojurnal.xml";
	*/
	
	public static void downloadFromUrl(String downloadUrl, String fileName) throws IOException {
		File root = android.os.Environment.getExternalStorageDirectory(); // path ke sdcard
 
		File dir = new File(root.getAbsolutePath() + "/youread"); // path ke folder
 
		if (dir.exists() == false) { // cek folder eksistensi
			dir.mkdirs(); // kalau belum ada, dibuat
		}
 
		URL url = new URL(downloadUrl); // you can write here any link
		File file = new File(dir, fileName);
 
		// Open a connection to that URL. 
		URLConnection ucon = url.openConnection();
 
		
		 // Define InputStreams to read from the URLConnection. 
		InputStream is = ucon.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
 
		
		 // Read bytes to the Buffer until there is nothing more to read(-1).
		ByteArrayBuffer baf = new ByteArrayBuffer(5000);
		int current = 0;
		while ((current = bis.read()) != -1) {
			baf.append((byte) current);
		}
 
		// Convert the Bytes read to a String. 
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(baf.toByteArray());
		fos.flush();
		fos.close();
	}
}

