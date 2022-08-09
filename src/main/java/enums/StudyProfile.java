package enums;

import com.google.gson.annotations.SerializedName;

public enum StudyProfile{
    @SerializedName("Физика")
    PHYSICS("Физика"),
    @SerializedName("Информатика")
    COMPUTER_SCIENCE("Информатика"),
    @SerializedName("Математика")
    MATHEMATICS("Математика"),
    @SerializedName("Юриспруденция")
    JURISPRUDENCE("Юриспруденция"),
    @SerializedName("Медицина")
    MEDICINE("Медицина"),
    @SerializedName("Лингвистика")
    LINGUISTICS("Лингвистика");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}