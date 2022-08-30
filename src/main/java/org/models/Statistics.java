package org.models;

import enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "avgScore")
    private float avgScore;
    @XmlTransient
    private int studentsAmountByProfile;
    @XmlTransient
    private int universityAmountByProfile;
    @XmlElement(name = "studyProfile")
    private StudyProfile studyProfile;
    @XmlTransient
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
