package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.models.Students;
import org.models.University;
import java.util.List;

public class JsonUtil {

    private JsonUtil(){}

    public static String studentsToJSON(Students students){
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }
    public static Students jsonToStudent(String json){
        return new Gson().fromJson(json, Students.class);
    }

    public static String universityToJSON(University university){
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }
    public static University jsonToUniversity(String json){
        return new Gson().fromJson(json, University.class);
    }

    public static String ListStudentToJSON(List<Students> students){
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }
    public static List<Students> jsonToStudentList(String json){
        return new Gson().fromJson(json, new TypeToken<List<Students>>() {}.getType());
    }

    public static String ListUniversityToJSON(List<University> universities){
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }
    public static List<University> jsonToUniversityList(String json){
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    }

}

