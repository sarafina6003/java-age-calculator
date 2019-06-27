/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifelsestatements2;

/**
 *
 * @author nyawira
 * 
 *
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class IfElseStatements2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.print("Please enter date of birth in YYYY-MM-DD: ");
        Scanner date = new Scanner(System.in);
        String input = date.nextLine();
        //date.close();
        
 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar dob = Calendar.getInstance();
        dob.setTime(sdf.parse(input));
        System.out.println("Age is: " + getAge(dob));
        if(getAge(dob)<=18)
        {
            System.out.println("You are a minor");
        }
         else
        {
            System.out.println("You are an adult");
        }
    }
 
    // Returns age given the date of birth
    public static int getAge(Calendar dob) throws Exception {
        Calendar today = Calendar.getInstance();
 
        int curYear = today.get(Calendar.YEAR);
        int dobYear = dob.get(Calendar.YEAR);
 
        int age = curYear - dobYear;
 
        // if dob is month or day is behind today's month or day
        // reduce age by 1
        int curMonth = today.get(Calendar.MONTH);
        int dobMonth = dob.get(Calendar.MONTH);
        if (dobMonth > curMonth) { // this year can't be counted!
            age--;
        } else if (dobMonth == curMonth) { // same month? check for day
            int curDay = today.get(Calendar.DAY_OF_MONTH);
            int dobDay = dob.get(Calendar.DAY_OF_MONTH);
            if (dobDay > curDay) { // this year can't be counted!
                age--;
            }
        }
 
        return age;
    
    }
}
