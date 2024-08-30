package com.ohgirrafers.section01.setting;

import java.io.*;
import java.util.Properties;

/**
 * "설정"
 * 사용자의 설정을 저장하고, 불러오는 기능을 한다.
 * 설정에는 검색 조건, 정렬 방식 등이 있다.
 */
public class Setting
{
    private int condition;
    File path = new File("src/main/resources/config/settings.properties");
    Properties props = new Properties();
    FileInputStream fis;
    FileOutputStream fos;
    
    public void printSavedCondition()
    {
        
    }

    public void saveSearchCondition(int num)
    {
        try {
            fis = new FileInputStream(path);
            props.load(fis);
            fis.close();
            fos = new FileOutputStream(path);
            props.setProperty("search", String.valueOf(num));
            props.store(fos,"Settings");
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Saved.");
    }

    public int loadSearchCondition()
    {
        try {
            fis = new FileInputStream(path);
            props.load(fis);
            String value = props.getProperty("search");
            condition = Integer.parseInt(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return condition;
    }

    public void saveSortCondition(int num)
    {
        try {
            fis = new FileInputStream(path);
            props.load(fis);
            fis.close();
            fos = new FileOutputStream(path);
            props.setProperty("sort", String.valueOf(num));
            props.store(fos, "Settings");
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Saved.");
    }

    public int loadSortCondition()
    {
        try {
            fis = new FileInputStream(path);
            props.load(fis);
            String value = props.getProperty("sort");
            condition = Integer.parseInt(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return condition;
    }
}
