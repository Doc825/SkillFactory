package org.models;

import java.io.IOException;
import XLSXReader.Reader;



public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\\\Users\\\\user\\\\IdeaProjects\\\\Students_University\\\\src\\\\main\\\\resources\\\\universityInfo.xlsx";

        System.out.println(Reader.StudentReader(filePath));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(Reader.UniversityReader(filePath));

    }
}