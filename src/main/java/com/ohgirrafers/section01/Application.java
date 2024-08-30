package com.ohgirrafers.section01;

import com.ohgirrafers.section01.controller.PhoneBookController;
import com.ohgirrafers.section01.validation.Validation;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validation validation = new Validation();
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
                case 2:
                    String samplePhoneNum = "01022343434"; // v true at 1, d false
                    String samplePhoneNum2 = "01012345678"; // v false at 1
                    String samplePhoneNum3 = "0215771577"; // v true at 2
                    String samplePhoneNum4 = "028007070"; // v true at 3
                    String samplePhoneNum5 = "03122222222"; // v true at 4
                    String samplePhoneNum6 = "04299999999"; // v true at 5
                    String sampleEmail = "s2322@naver.com"; // v true, d false
                    String sampleEmail2 = "sample@sample.com"; // v true, d true
                    String sampleEmail3 = "sample"; // v false
                    String sampleBirth = "20230229";
                    boolean vCheckEmail = validation.vCheckEmail(sampleEmail2);
                    boolean dCheckEmail = validation.dCheckEmail(sampleEmail2);
                    boolean vCheckPN = validation.vCheckPN(samplePhoneNum4);
                    boolean dCheckPN = validation.dCheckPN(samplePhoneNum2);
                    boolean vCheckBirth = validation.vCheckBirth(sampleBirth);
                    // System.out.println("vCheckEmail = " + vCheckEmail);
                    // System.out.println("dCheckEmail = " + dCheckEmail);
                    // System.out.println("vCheckPN = " + vCheckPN);
                    // System.out.println("dCheckPN = " + dCheckPN);
                    System.out.println("vCheckBirth = " + vCheckBirth);
                    break;
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
