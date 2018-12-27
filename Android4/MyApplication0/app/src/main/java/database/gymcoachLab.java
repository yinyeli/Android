package database;

import java.util.ArrayList;


public class gymcoachLab {
    private static gymcoachLab sWordsLab;
    private static ArrayList<gymcoachBean> sWordBeanArrayList;

    private gymcoachLab(){
        sWordBeanArrayList = new ArrayList<>();
    }

    public static gymcoachLab getInstance(){
        if (sWordsLab == null){
            sWordsLab = new gymcoachLab();
        }

        return sWordsLab;
    }

    public gymcoachBean get(int i){
        return sWordBeanArrayList.get(i);
    }

    public int getLen(){
        return sWordBeanArrayList.size();
    }

    public void set(int i, gymcoachBean v){
        sWordBeanArrayList.set(i, v);
    }

    public void add(gymcoachBean v){
        sWordBeanArrayList.add(v);
    }

    public void init(ArrayList<gymcoachBean> list){
        sWordBeanArrayList.addAll(list);
    }
}