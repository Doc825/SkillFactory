package org.models;

import enums.StudyProfile;

public class Statistics {
    private float avgScore;
    private int studentsAmountByProfile;
    private int universityAmountByProfile;
    private StudyProfile studyProfile;
    private String universityName;

    public float getAvgScore() {
        return avgScore;
    }

    public Statistics setAvgScore(float avgScore) {
        this.avgScore = avgScore;
        return this;
    }

    public int getStudentsAmountByProfile() {
        return studentsAmountByProfile;
    }

    public Statistics setStudentsAmountByProfile(int studentsAmountByProfile) {
        this.studentsAmountByProfile = studentsAmountByProfile;
        return this;
    }

    public int getUniversityAmountByProfile() {
        return universityAmountByProfile;
    }

    public Statistics setUniversityAmountByProfile(int universityAmountByProfile) {
        this.universityAmountByProfile = universityAmountByProfile;
        return this;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public Statistics setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
        return this;
    }

    public String getUniversityName() {
        return universityName;
    }

    public Statistics setUniversityName(String universityName) {
        this.universityName = universityName;
        return this;
    }
}
