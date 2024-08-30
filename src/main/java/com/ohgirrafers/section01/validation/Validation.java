package com.ohgirrafers.section01.validation;

/**
 *  "유효성 검사"
 *  전화번호부에 있어 중요한 정보인 전화번호, 이메일, 생년월일에 대하여
 *  아래 메소드에서 각각에 대한 유효성 검사를 진행한다.
 *  전화번호와 이메일은 중복 여부를 함께 검사한다.
 *  각 메소드 이름의 첫 글자로 구분한다.
 *  v는 유효한 형식의 정보인지 검사하는 메소드이다.
 *  d는 DB 안에 중복된 값이 존재하는지 검사하는 메소드이다.
 *  유효성 검사를 통과했을 경우 메소드는 true를 반환한다.
 *  아래 메소드 중 단 하나라도 false를 반환할 경우
 *  유효성 검사에 실패한 것으로 간주하고,
 *  입력된 정보를 반려한다.
 *  유효성 검사 탈락 사유를 추가할 지는 회의 후 결정할 것.
 */
import javax.mail.internet.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static com.ohgirrafers.common.JDBCTemplate.*;

public class Validation
{
    public boolean vCheckPN(String PhoneNum)
    {
        boolean result = false;
        if(PhoneNum.matches("^(01[0-9]-?[2-9][0-9]{3}-?[0-9]{4}|01[0-9][2-9][0-9]{7})$"))
        {
            result = true;
        }
        else if(PhoneNum.matches("^(02-?[1-9][0-9]{3}-?[0-9]{4}|02[1-9][0-9]{7})$"))
        {
            result = true;
        }
        else if(PhoneNum.matches("^(02-?[2-9]{3}-?[0-9]{4}|02[2-9][0-9]{6})$"))
        {
            result = true;
        }
        else if(PhoneNum.matches("^(0[3-8][0-5]-?[2-9][0-9]{3}-?[0-9]{4}|0[3-8][0-5][2-9][0-9]{7})$"))
        {
            result = true;
        }
        else if(PhoneNum.matches("^(0[3-6][0-5]-?[2-9]{3}-?[0-9]{4}|0[3-6][0-5][2-9][0-9]{6})$"))
        {
            result = true;
        }

        return result;
    }

    public boolean dCheckPN(String phoneNum)
    {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = true;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            ps = con.prepareStatement(prop.getProperty("duplicateCheckPN"));
            ps.setString(1, phoneNum);
            rs = ps.executeQuery();

            while (rs.next())
                result = false;

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public boolean vCheckEmail(String email)
    {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public boolean dCheckEmail(String email)
    {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = true;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            ps = con.prepareStatement(prop.getProperty("duplicateCheckEmail"));
            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next())
                result = false;

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public boolean vCheckBirth(String birth)
    {
        boolean result = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date ret = dateFormat.parse(birth.trim());
            if(dateFormat.format(ret).equals(birth.trim()))
                result = true;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
