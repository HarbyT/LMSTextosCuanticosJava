/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textoscuanticoslms.util;

/**
 *
 * @author harby
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionDB {
  public static Connection conectar() {
    try {
      String url = "jdbc:mysql://localhost:3306/textoscuanticos";
      String user = "root";
      String password = "";
      Connection conn = DriverManager.getConnection(url, user, password);
      return conn;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
