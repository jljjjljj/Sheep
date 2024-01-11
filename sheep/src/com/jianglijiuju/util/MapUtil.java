package com.jianglijiuju.util;

import com.jianglijiuju.model.Brand;
import com.jianglijiuju.model.Cell;
import com.jianglijiuju.model.Layer;
import com.jianglijiuju.model.Map;

import java.awt.*;

public class MapUtil {
    public static Map build(Integer height){
        Map map=new Map();
        map.setFloorHeight(height);

        //绝对布局中最先加入到展示在最上层
        Layer layer1= LayerUtil.build(6,6);
        Layer layer2= LayerUtil.build(6,6);
        Layer layer3= LayerUtil.build(6,6);

        //构建链式关系
        layer3.setParent(layer2);
        layer2.setParent(layer1);
        layer1.setParent(null);//null是循环或递归结束的条件

        layer1.setOffsetX(60);
        layer2.setOffsetX(30);
        layer3.setOffsetX(20);

        map.getList().add(layer1);
        map.getList().add(layer2);
        map.getList().add(layer3);

        return map;
    }

    //判断当前的牌和某一层的多有牌是否有交集，true->灰色/false->彩色
    public static boolean compare(Brand brand, Layer layer){
        Cell[][] cells=layer.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
               //当前单元格是空的，cell不用比较
                Cell cell=cells[row][col];
                if(cell.getState()==1){
                   Rectangle rect= brand.getBounds();//当前牌的矩阵
                    Rectangle rectCell=cell.getBrand().getBounds();//对比的单元格的矩阵
                  boolean flag= rect.intersects(rectCell);//比较两个矩阵是否相交
                    if(flag){
                        //true,有交集,灰色,直接结束判断，返回结果
                        return flag;
                    }
                }
            }
            System.out.println();
        }
        //如果当前牌和该层都没有交集，则和更上一层比较
        if(layer.getParent()!=null){
           return compare(brand,layer.getParent());
        }else{
            return false;
        }

    }
}
