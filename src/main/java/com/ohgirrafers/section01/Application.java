package com.ohgirrafers.section01;

import com.ohgirrafers.section01.controller.PhoneBookController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneBookController phoneBookController = new PhoneBookController();
        while (true) {
            System.out.println("사용할 기능을 선택해주세요");
            System.out.println("1. 연락처 관리");
            System.out.println("2. 유효성 검사");
            System.out.println("3. 그룹화");
            System.out.println("4. 조회");
            System.out.println("5. 검색");
            System.out.println("6. 통계");
            System.out.println("7. 설정");
            System.out.println("9. 프로그램 종료");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: phoneBookController.InsertInformation(); break;
                case 2:  break;
                case 3:  break;
                case 4:  break;
                case 5:  break;
                case 6:  break;
                case 7:  break;
                case 9: System.out.println("프로그램을 종료합니다."); return;
                default:
                    System.out.println("잘못된 입력입니다");
                    break;
            }
        }



    }
}
