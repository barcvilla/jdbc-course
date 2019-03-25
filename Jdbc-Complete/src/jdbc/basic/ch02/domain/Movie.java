/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch02.domain;

/**
 *
 * @author PC
 */
public class Movie 
{
    private int no;
    private String name;
    private String hero;
    private String heroine;
    
    public Movie(){}
    
    public Movie(int no, String name, String hero, String heroine)
    {
        this.no = no;
        this.name = name;
        this.hero = hero;
        this.heroine = heroine;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getHeroine() {
        return heroine;
    }

    public void setHeroine(String heroine) {
        this.heroine = heroine;
    }

    @Override
    public String toString() {
        return "Movie{" + "no=" + no + ", name=" + name + ", hero=" + hero + ", heroine=" + heroine + '}';
    }
    
}
