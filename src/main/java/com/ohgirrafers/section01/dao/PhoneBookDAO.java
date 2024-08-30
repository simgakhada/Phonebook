package com.ohgirrafers.section01.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class PhoneBookDAO {
    private Properties prop = new Properties(); //파일 불러오기위한 객체 폰디비접근 복사 붙여넣기할 틀


    public PhoneBookDAO(String url) {


        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void insertInfo(Connection con) {

        Scanner sc = new Scanner(System.in);
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertInfo");

        try {
            pstmt = con.prepareStatement(query);
            System.out.println("이름입력 :");
            String name = sc.nextLine();
            System.out.println("전화번호입력 :");
            int phone = sc.nextInt();
            sc.nextLine();
            System.out.println("이메일입력 :");
            String Email = sc.nextLine();
            System.out.println("주소입력 :");
            String Address = sc.nextLine();
            System.out.println("생일입력 :");
            int birth = sc.nextInt();
            System.out.println("인그룹입력 :");
            int ingroup = sc.nextInt();
            sc.nextLine();

            pstmt.setString(1,name);
            pstmt.setInt(2,phone);
            pstmt.setString(3,Email);
            pstmt.setString(4,Address);
            pstmt.setInt(5,birth);
            pstmt.setInt(6,ingroup);
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
