package com.InfoStack.schoolmanagement.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_peon")
public class Peon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peon_id")
    int peonId;
    @Column(name = "peon_name")
    String peonName;
    @Column(name = "peon_salary")
    int peonSalary;
    @Column(name = "peon_subject")
    String peonWork;

    public int getPeonId() {
        return peonId;
    }

    public void setPeonId(int peonId) {
        this.peonId = peonId;
    }

    public String getPeonName() {
        return peonName;
    }

    public void setPeonName(String peonName) {
        this.peonName = peonName;
    }

    public int getPeonSalary() {
        return peonSalary;
    }

    public void setPeonSalary(int peonSalary) {
        this.peonSalary = peonSalary;
    }

    public String getPeonWork() {
        return peonWork;
    }

    public void setPeonWork(String peonWork) {
        this.peonWork = peonWork;
    }


    public Peon(String peonName, int peonSalary, String peonWork) {
        this.peonName = peonName;
        this.peonSalary = peonSalary;
        this.peonWork = peonWork;
    }

    public Peon(int peonId, String peonName, int peonSalary, String peonWork) {
        this.peonId = peonId;
        this.peonName = peonName;
        this.peonSalary = peonSalary;
        this.peonWork = peonWork;
    }

    public Peon() {
    }
}
