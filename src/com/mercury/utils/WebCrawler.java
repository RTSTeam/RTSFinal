package com.mercury.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class WebCrawler {

	public static void main(String[] args) {

		Document[] docs = new Document[26];
		int count=0;
		int index=1;
		//File csv = new File("WebContent.csv"); 
		//BufferedWriter bw;
		try {

			Connection conn = JdbcUtil.getConnection();
			String sql = "insert into stations values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			//get all span
			String[] urls = {
					"http://www.amtrak.com/html/stations_A.html",
					"http://www.amtrak.com/html/stations_B.html",
					"http://www.amtrak.com/html/stations_C.html",
					"http://www.amtrak.com/html/stations_D.html",
					"http://www.amtrak.com/html/stations_E.html",
					"http://www.amtrak.com/html/stations_F.html",
					"http://www.amtrak.com/html/stations_G.html",
					"http://www.amtrak.com/html/stations_H.html",
					"http://www.amtrak.com/html/stations_I.html",
					"http://www.amtrak.com/html/stations_J.html",
					"http://www.amtrak.com/html/stations_K.html",
					"http://www.amtrak.com/html/stations_L.html",
					"http://www.amtrak.com/html/stations_M.html",
					"http://www.amtrak.com/html/stations_N.html",
					"http://www.amtrak.com/html/stations_O.html",
					"http://www.amtrak.com/html/stations_P.html",
					"http://www.amtrak.com/html/stations_Q.html",
					"http://www.amtrak.com/html/stations_R.html",
					"http://www.amtrak.com/html/stations_S.html",
					"http://www.amtrak.com/html/stations_T.html",
					"http://www.amtrak.com/html/stations_U.html",
					"http://www.amtrak.com/html/stations_V.html",
					"http://www.amtrak.com/html/stations_W.html",
					"http://www.amtrak.com/html/stations_X.html",
					"http://www.amtrak.com/html/stations_Y.html",
					"http://www.amtrak.com/html/stations_Z.html"
			};

			for(int i=0; i<26; i++){


				docs[i] = Jsoup.connect(urls[i]).get();
				Elements stations = docs[i].select("span[style=\"text-decoration:underline\"]");
				// span style="text-decoration:underline"

				//bw = new BufferedWriter(new FileWriter(csv));
				for (Element station : stations) {
					if(count%2==0){
						//bw.write(station.text());
						//bw.newLine();
						ps.setInt(1, index);
						index++;
						ps.setString(3, station.text());
						System.out.println("\nStation FullName : " + station.text());
					}
					else{
						//bw.write(station.text());
						//bw.newLine();
						ps.setString(2, station.text());
						ps.executeUpdate();
						System.out.println("\nStation Abbr : " + station.text());
					}
					count++;
				}
			}
			//bw.close(); 
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}