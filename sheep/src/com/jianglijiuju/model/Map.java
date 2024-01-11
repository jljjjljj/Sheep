package com.jianglijiuju.model;

import com.jianglijiuju.util.MapUtil;

import java.util.ArrayList;
import java.util.List;

//地图下有多个图层，层层遮盖
public class Map {
    private Integer floorHeight;//一张地图有几张图层
    private List<Layer> list=new ArrayList<>(); //存放图层数据

    public Integer getFloorHeight() {
        return floorHeight;
    }
    public void setFloorHeight(Integer floorHeight) {
        this.floorHeight = floorHeight;
    }

    public List<Layer> getList() {
        return list;
    }

    public void setList(List<Layer> list) {
        this.list = list;
    }

    //判断map中所有牌是否置灰
    //游戏开始时调用函数/每次点击消除一个牌时也要调用
    public void compareAll(){
        //最顶层不需要判断
        for (int i = 1; i < list.size(); i++) {
            Layer layer=list.get(i);
            Cell[][] cells=layer.getCells();
            for (int row = 0; row < cells.length; row++) {
                for (int col = 0; col < cells[row].length; col++) {
                    Cell cell=cells[row][col];
                    if(cell.getState()==1){
                        Brand brand=cell.getBrand();
                        boolean result=MapUtil.compare(brand,layer.getParent());
                        brand.setGrey(result);
                    }
                }
            }
        }
    }
}
