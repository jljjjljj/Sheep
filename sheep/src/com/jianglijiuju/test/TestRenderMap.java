package com.jianglijiuju.test;

import com.jianglijiuju.model.*;
import com.jianglijiuju.util.MapUtil;
import javazoom.jl.decoder.JavaLayerException;


import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

//测试渲染一个图层
public class TestRenderMap extends JFrame {
    public static Map map= MapUtil.build(4);

    public TestRenderMap() throws FileNotFoundException, JavaLayerException {
        //初始化
        init();
        ImageIcon backgroundImage=new ImageIcon("imgs/草地背景.png");
        JLabel backgroundLabel=new JLabel(backgroundImage);
        backgroundLabel.setBounds(0,0,getWidth(),getHeight());
        this.add(backgroundLabel);
        //渲染,改变牌的坐标,改变布局方式->绝对布局
        List<Layer> list=map.getList();
        for (int i = 0; i < list.size(); i++) {
            renderMap(list.get(i),backgroundLabel);
        }
        map.compareAll();//游戏开始时的判定
        //自动刷新
        autoRefresh();

        new Music().music();
    }

    private void renderMap(Layer layer,JLabel bg){
        Cell[][] cells=layer.getCells();
        layer.showCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand brand= cells[row][col].getBrand();
                int x=col*50+layer.getOffsetX();
                int y=row*50+layer.getOffsetY()+100;
                brand.setBounds(x,y,50,50);
                this.getContentPane().add(brand);
                bg.add(brand);
            }
            System.out.println();
        }

    }
    private void init(){
        this.setTitle("原了个原");
        this.setSize(400,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置绝对布局
        this.setLayout(null);
        this.setBounds(0,0,400,800);
        this.setLocationRelativeTo(null);//居中

        Image iconImage = Toolkit.getDefaultToolkit().getImage("imgs/icon.png");
        this.setIconImage(iconImage);

        this.setVisible(true);
    }

    private void autoRefresh(){
        JFrame start=this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    start.repaint();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }



    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
        new TestRenderMap();
    }

}
