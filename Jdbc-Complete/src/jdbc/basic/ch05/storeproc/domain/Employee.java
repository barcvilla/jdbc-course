/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch05.storeproc.domain;

/**
 *
 * @author PC
 */
public class Employee 
{
    private int eno;
    private String ename;
    private double esal;
    private String eaddr;

    public Employee() {
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getEsal() {
        return esal;
    }

    public void setEsal(double esal) {
        this.esal = esal;
    }

    public String getEaddr() {
        return eaddr;
    }

    public void setEaddr(String eaddr) {
        this.eaddr = eaddr;
    }

    @Override
    public String toString() {
        return "Employee{" + "eno=" + eno + ", ename=" + ename + ", esal=" + esal + ", eaddr=" + eaddr + '}';
    }
}
