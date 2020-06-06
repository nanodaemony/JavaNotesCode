package com.nano.mybatis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: nano
 * @time: 2020/5/21 12:55
 */
public class GpsServer {

	public static final String url = "jdbc:mysql://172.20.29.103/nano_eval_local";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "621";

	public static void main(String[] args) throws IOException {
		try  {
			ServerSocket ss = new ServerSocket(8888);
			while (true) {
				Socket socket = ss.accept();
				System.out.println("Get connection");
				InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

				while (true) {
					String s = bufferedReader.readLine();
					// Longitude:106.46347 E#Latitude:29.56483 N#Altitude:271.4m#Speed:0.000km/h#Fix Mode: 3D#GPS+BD Valid satellite:10#GPS Visible satellite:00#BD Visible satellite:00#UTC Date:2020/05/16
					// 退出本次接收
					if ("end".equals(s)) {
						break;
					}
					String[] values = s.split("#");
					String longitude = values[0].split(":")[1];
					String latitude = values[1].split(":")[1];
					String altitude = values[2].split(":")[1];
					String speed = values[3].split(":")[1];
					String locateMode = values[4].split(":")[1];
					String validNumber = values[5].split(":")[1];
					String gpsVisible = values[6].split(":")[1];
					String bdVisible = values[7].split(":")[1];

					String sqlTemp = "insert  into `gps_data`(`altitude`,`bd_visible`,`gmt_create`,`gmt_modified`,`gps_visible`,`latitude`,`locate_mode`,`longitude`,`speed`,`valid_number`) " +
							"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					Connection conn = null;
					PreparedStatement pst = null;
					try {
						// 指定连接类型
						Class.forName(name);
						// 获取连接
						conn = DriverManager.getConnection(url, user, password);
						// 准备执行语句
						pst = conn.prepareStatement(sqlTemp);
						pst.setString(1, altitude);
						pst.setString(2, bdVisible);
						pst.setString(3, System.currentTimeMillis() + "");
						pst.setString(4, System.currentTimeMillis() + "");
						pst.setString(5, gpsVisible);
						pst.setString(6, latitude);
						pst.setString(7, locateMode);
						pst.setString(8, longitude);
						pst.setString(9, speed);
						pst.setString(10, validNumber);
						System.out.println(pst.toString());
						pst.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}

					try {
						if (conn != null) {
							conn.close();
						}
						if (pst != null) {
							pst.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					System.out.println(s);

				}

				inputStreamReader.close();

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}


}




