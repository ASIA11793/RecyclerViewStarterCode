package com.example.recyclerviewstudentversion;

public class Player {
    private String name;
    private int age;
    private long worth;
    private String mainSport;
    private int image;
    private String wiki;

    public Player(String a, int b,long c,String d,int f,String w){
        name=a;
        age=b;
        worth=c;
        mainSport=d;
        image=f;
        wiki=w;
    }

    public String getName(){

        return name;
    }
    public int getage(){

        return age;
    }
    public long getWorth(){

        return worth;

    }
    public String getMainsport(){
        
        return mainSport;
    }
    public int getImage(){

        return image;
    }
    public String getwiki(){

        return wiki;
    }
    public void setName(String s){

        name=s;
    }
    public void setAge(int s){

        age=s;
    }
    public void setWorth(int s){

        worth=s;
    }
    public void setMainSport(String s){

        mainSport=s;
    }
    public void setImage(int s){

        image=s;
    }
    public void setwiki (String w){
        wiki=w;
    }





}
