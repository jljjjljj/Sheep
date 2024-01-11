package com.jianglijiuju.test;

import com.jianglijiuju.model.Brand;
import com.jianglijiuju.model.Cell;
import com.jianglijiuju.model.Layer;
import com.jianglijiuju.util.LayerUtil;
import com.jianglijiuju.view.Start;

import javax.swing.*;
import java.awt.*;

//测试渲染一个图层
public class TestRenderLayer extends JFrame {
    private Layer layer= LayerUtil.build(3,6);

    public TestRenderLayer(){
        //初始化
        init();
        //渲染,改变牌的坐标
        //改变布局方式->绝对布局
        renderLayer();
        //自动刷新
        autoRefresh();
    }

    private void renderLayer(){
        Cell[][] cells=layer.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand brand= cells[row][col].getBrand();
                int x=col*50+40;
                int y=row*50+20;
                brand.setBounds(x,y,50,50);
                this.getContentPane().add(brand);
            }
            System.out.println();
        }

    }
    private void init(){
        this.setTitle("原了个原");
        Image iconImage = Toolkit.getDefaultToolkit().getImage("imgs/icon.png");
        this.setIconImage(iconImage);
        this.setSize(400,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);//居中

        //设置绝对布局
        this.setLayout(null);
        this.setBounds(0,0,400,800);
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

    public static void main(String[] args) {
        new TestRenderLayer();
    }

}
