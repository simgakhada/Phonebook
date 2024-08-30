package com.ohgirrafers.section01.controller;

import com.ohgirrafers.section01.dao.PhoneBookDAO;

import static com.ohgirrafers.common.JDBCTemplate.*;

public class PhoneBookController {
    private PhoneBookDAO phoneBookDAO = new PhoneBookDAO("src/main/resources/mapper/menu-query.xml");

    public void InsertInformation()
    {
        phoneBookDAO.insertInfo(getConnection2());
    }


}
