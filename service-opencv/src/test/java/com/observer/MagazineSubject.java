package com.observer;

import java.util.ArrayList;
import java.util.List;

public class MagazineSubject implements Subject{
    //存放订阅者
    private List<Observer> observers = new ArrayList<Observer>();

    //期刊版本
    private int version;

    @Override
    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void deleteObserver(Observer obj) {
        //如果存在该观察者 就删除
        int i = observers.indexOf(obj);
        if(i>=0){
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<observers.size();i++){
            //获取到每一位观察者 并更新订阅数组里面每一位观察者
            //这样观察者就知道杂志社已经更新  但是还没有购买
            Observer o=observers.get(i);
            //因为
            o.update(version);
        }
    }

    //该杂志发行了新版本
    public void publish(){
        //新版本
        this.version++;
        //信息更新完毕，通知所有观察者
        notifyObserver();
    }
}
