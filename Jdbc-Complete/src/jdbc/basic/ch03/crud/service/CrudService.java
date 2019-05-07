/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch03.crud.service;

/**
 *
 * @author PC
 */
public interface CrudService {
    public String createEmployeeTable();
    public String dropEmployeeTable();
    public int insertFixedEmployee();
    public void insertDynamicalEmployee(int eno, String ename, double esal, String eaddr);
    public int insertMultipleRows(int eno, String ename, double esal, String eaddr);
    public int updateFixedEmployee();
    public int updateMultipleRows(double increment, double range);
}
