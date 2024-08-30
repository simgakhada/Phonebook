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
            String phone = sc.nextLine();
            sc.nextLine();
            System.out.println("이메일입력 :");
            String Email = sc.nextLine();
            System.out.println("주소입력 :");
            String Address = sc.nextLine();
            System.out.println("생일입력 :");
            String birth = sc.nextLine();
            System.out.println("인그룹입력 :");
            int ingroup = sc.nextInt();
            sc.nextLine();

            pstmt.setString(1,name);
            pstmt.setString(2,phone);
            pstmt.setString(3,Email);
            pstmt.setString(4,Address);
            pstmt.setString(5,birth);
            pstmt.setInt(6,ingroup);
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteInfo(Connection con)
    {
        Scanner sc = new Scanner(System.in);
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("deleteInfo");

        try {
            pstmt = con.prepareStatement(query);
            System.out.println("이름입력 :");
            String st = sc.nextLine();
            pstmt.setString(1, st);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void UpdateInfo(Connection con)
    {
        Scanner sc = new Scanner(System.in);
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("updateInfo");

        try {
            pstmt = con.prepareStatement(query);
            System.out.println("변경하실 정보의 이름을 입력해 주세요");
            String name = sc.nextLine();
            pstmt.setString(7,name);
            System.out.println("새로운 이름을 입력해 주세요");
            String newName = sc.nextLine();
            pstmt.setString(1,newName);
            System.out.println("새로운 전화번호를 입력해주세요");
            String phone = sc.nextLine();
            pstmt.setString(2,phone);
            System.out.println("새로운 이메일을 입력해주세요");
            String Email = sc.nextLine();
            pstmt.setString(3,Email);
            System.out.println("새로운 주소를 입력해 주세요");
            String Address = sc.nextLine();
            pstmt.setString(4,Address);
            System.out.println("새로운 생일을 입력해 주세요");
            int birth = sc.nextInt();
            pstmt.setInt(5,birth);
            System.out.println("새로운 그룹번호를 정해주세요");
            int ingroup = sc.nextInt();
            pstmt.setInt(6,ingroup);
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
