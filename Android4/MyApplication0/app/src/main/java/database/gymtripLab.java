package database;

import java.util.ArrayList;


public class gymtripLab {
    private static gymtripLab sWordsLab;
    private static ArrayList<gymtripBean> sWordBeanArrayList;

    private gymtripLab(){
        sWordBeanArrayList = new ArrayList<>();
    }

    public static gymtripLab getInstance(){
        if (sWordsLab == null){
            sWordsLab = new gymtripLab();
        }

        return sWordsLab;
    }

    public gymtripBean get(int i){
        return sWordBeanArrayList.get(i);
    }

    public int getLen(){
        return sWordBeanArrayList.size();
    }

    public void set(int i, gymtripBean v){
        sWordBeanArrayList.set(i, v);
    }

    public void add(gymtripBean v){
        sWordBeanArrayList.add(v);
    }

    public void init(ArrayList<gymtripBean> list){
        sWordBeanArrayList.addAll(list);
    }
}