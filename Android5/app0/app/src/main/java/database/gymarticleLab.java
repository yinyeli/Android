package database;

import java.util.ArrayList;


public class gymarticleLab {
    private static gymarticleLab sWordsLab;
    private static ArrayList<gymarticleBean> sWordBeanArrayList;

    private gymarticleLab(){
        sWordBeanArrayList = new ArrayList<>();
    }

    public static gymarticleLab getInstance(){
        if (sWordsLab == null){
            sWordsLab = new gymarticleLab();
        }

        return sWordsLab;
    }

    public gymarticleBean get(int i){
        return sWordBeanArrayList.get(i);
    }

    public int getLen(){
        return sWordBeanArrayList.size();
    }

    public void set(int i, gymarticleBean v){
        sWordBeanArrayList.set(i, v);
    }

    public void add(gymarticleBean v){
        sWordBeanArrayList.add(v);
    }

    public void init(ArrayList<gymarticleBean> list){
        sWordBeanArrayList.addAll(list);
    }
}