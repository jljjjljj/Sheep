package com.jianglijiuju.model;

import java.util.Random;

//图层类 二维表格
public class Layer {

    private Integer offsetX; //水平偏移量
    private Integer offsetY;
    private Integer rowNum;
    private Integer colNum;
    private Integer capacity;//当前图层最多能容纳的牌的数量，容量
    private Integer size;//当前有多少张牌 当牌动态添加，消失时需要改变值
    private Layer parent;//当前图层的上一层对象
    private Cell[][] cells=null; //二维数组

    public Layer(Integer rowNum, Integer colNum) throws Exception {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.capacity=this.rowNum*this.colNum;
        if(this.capacity%3!=0){
            throw new Exception("容量不是3的倍数");
        }
        this.cells=new Cell[this.rowNum][this.colNum];
        this.size=0;
        this.offsetX=new Random().nextInt(100);
        this.offsetY=new Random().nextInt(100);
    }

    public void showCells(){
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand brand= cells[row][col].getBrand();
                System.out.print(brand.getName()+"-");
            }
            System.out.println();
        }
    }

    public Layer getParent() {
        return parent;
    }

    public void setParent(Layer parent) {
        this.parent = parent;
    }

    public Integer getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(Integer offsetX) {
        this.offsetX = offsetX;
    }

    public Integer getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(Integer offsetY) {
        this.offsetY = offsetY;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public Integer getColNum() {
        return colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
