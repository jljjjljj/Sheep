package com.jianglijiuju.model;

import com.jianglijiuju.test.TestRenderMap;

import javax.swing.*;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;


public class ElimateBox {
    private static List<Brand> slot =new ArrayList<>();

    public void addSlot(Brand brand){
        slot.add(brand);

       //slot.sort(Comparator.comparing(Brand::getName));
       Map<String,List<Brand>> map=slot.stream().collect(Collectors.groupingBy(Brand::getName));
       Set<String> key= map.keySet();
        for (String s : key) {
            List<Brand> brands=map.get(s);
            if(brands.size()==3){
                deleteByBrandName(s);
                break;
            }
        }
       paint();
        over(brand);
    }

    void paint(){
        for (int i = 0; i < slot.size(); i++) {
           Brand brand= slot.get(i);
           int x=i*brand.getWidth()+10;
           brand.setBounds(x+25,625,50,50);

        }
    }

    void deleteByBrandName(String name){
        Iterator<Brand> iterator=slot.iterator();
        while (iterator.hasNext()){
            Brand next=iterator.next();
            if(next.getName().equals(name)){
                next.getParent().remove(next);
                iterator.remove();
            }
        }
    }

    void over(Brand brand){
        if(slot.size()>=7){
            JOptionPane.showMessageDialog(brand,"菜就多练！");
            System.exit(0);
        }
    }




}
