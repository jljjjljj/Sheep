package com.jianglijiuju.view;

import com.jianglijiuju.model.Brand;

import javax.swing.*;
import java.awt.*;

//入口，程序启动类
public class Start extends JFrame {

    private Brand brand=new Brand("达达鸭");
    public Start() throws HeadlessException {
        this.setTitle("原了个原");
        Image iconImage = Toolkit.getDefaultToolkit().getImage("imgs/icon.png");
        this.setIconImage(iconImage);
        this.setSize(400,800);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);//居中

        this.setVisible(true);

        //添加自定义组件到当前窗口
        this.getContentPane().add(brand);
        autoRefresh();

    }

    private void autoRefresh(){
        Start start=this;
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
            new Start();
        //创建对象就会调用上面的start无参构造器
    }
}

//数据结构：
//map->layer->cell->brand(0/1个)->picture(正常/灰色)
