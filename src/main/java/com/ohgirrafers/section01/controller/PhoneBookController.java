package com.ohgirrafers.section01.controller;

import com.ohgirrafers.section01.dao.PhoneBookDAO;

import java.util.Scanner;

import static com.ohgirrafers.common.JDBCTemplate.*;

public class PhoneBookController {
    private PhoneBookDAO phoneBookDAO = new PhoneBookDAO("src/main/resources/mapper/menu-query.xml");


    public void InsertInformation()
    {

        Scanner sc = new Scanner(System.in);


        System.out.println("연락처 관리입니다");
        System.out.println("1. 연락처 추가");
        System.out.println("2. 연락처 삭제");
        System.out.println("3. 연락처 변경");
        System.out.println("9. 뒤로가기");

        int choice = sc.nextInt();
        switch (choice)
        {
            case 1 : phoneBookDAO.insertInfo(getConnection2()); break;
            case 2 : phoneBookDAO.deleteInfo(getConnection2()); break;
            case 3 : phoneBookDAO.UpdateInfo(getConnection2()); break;
            case 9 : break;
        }

    }


}
