package org.example;

public class Main {
    public static void main(String[] args) {
        University Moscow_State_U = new University("1", "Московский Гос Универ",
                "МГУ", 1772, Students.StudyProfile.ENGINEERING);
        Students Green = new Students("Robert B. Green", "1", 2, 4.2f);
        System.out.println(Moscow_State_U);
        System.out.println(Green);
    }
}