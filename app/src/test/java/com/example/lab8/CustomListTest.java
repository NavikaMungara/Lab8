package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }



    @Test
    void testDeleteCity(){
        CustomList cityList = MockCityList();
        City city = new City("Vancouver", "BC");
        cityList.addCity(city);
        //check if its there
        if(cityList.getCities().contains(city)){
            //delete
            cityList.delete(city);
        }

        Assertions.assertFalse(cityList.getCities().contains(city));

    }

    @Test
    void testhasCity(){
        CustomList cityList = MockCityList();
        City city = new City("Vancouver", "BC");
        cityList.addCity(city);

        //check if its there
        Boolean exists = cityList.hasCity(city);
        Assertions.assertTrue(exists);
    }

    @Test
    void testCountCities(){
        CustomList cityList = MockCityList();

        City city = new City("Toronto", "ON");
        City city3 = new City("Calgary", "AB");
        City city4 = new City("Halifax", "NS");

        //add all the cities to the list
        cityList.addCity(city);
        cityList.addCity(city3);
        cityList.addCity(city4);

        //so I already know that the counts is 3
        int correctCount = 3;
        Assertions.assertEquals(correctCount, cityList.countCities());

    }

}
