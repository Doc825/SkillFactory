import java.io.IOException;
import XLSXReader.Reader;



public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\User\\IdeaProjects\\SkillFactory\\src\\main\\resources\\universityInfo.xlsx";

        System.out.println(Reader.StudentReader(filePath));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(Reader.UniversityReader(filePath));

    }
}