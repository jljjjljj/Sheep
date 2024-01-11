package com.jianglijiuju.test;

import com.jianglijiuju.model.Brand;
import com.jianglijiuju.model.Cell;
import com.jianglijiuju.model.Layer;

import java.util.Random;

//测试图层数据
public class TestBuildLayer {

    public static Random random=new Random();
    public static String[] brandNames={
            "可莉","宵宫","散兵",
            "林尼","温迪","琳妮特",
            "纳西妲","绫人","绫华",
            "胡桃","芙芙","达达鸭",
            "钟离","锅巴","雷神","魈"
    };
    public static String getName(){
       int index= random.nextInt(brandNames.length);
       return brandNames[index];
    };//每次调用都随机获取一个牌的名字

    public static void main(String[] args) {
        Layer layer= null;//创建一个容量为36的二维数组
        try {
            layer = new Layer(8 ,6);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Brand[] brands=new Brand[layer.getCapacity()];//36容量的数组

        //3张相同牌消除,步调为3
        //为了避免容量不够，容量必须为3的倍数
        //随机打散数组
        for (int i = 0; i < brands.length ; i=i+3) {
            String randomName=getName();
            Brand brand1=new Brand(randomName);
            Brand brand2=new Brand(randomName);
            Brand brand3=new Brand(randomName);
            brands[i]=brand1;
            brands[i+1]=brand2;
            brands[i+2]=brand3;
        }

        //打乱算法
        System.out.println("-----------------");
        for (int i = 0; i < brands.length; i++) {
            Brand brandA=brands[i];//当前位置的变量
            int randomIndex=random.nextInt(brands.length);//交换位置的索引
            Brand brandB=brands[randomIndex];
            Brand temp=brandA;
            brands[i]=brandB;
            brands[randomIndex]=temp;
        }
        System.out.println("-----------------");
        for (int i = 0; i < brands.length; i++) {
            System.out.print(brands[i].getName()+"-");
        }

        //把打乱的牌数组一个个放到cell二维数组里
        int flag=0;
        Cell[][] cells=layer.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Cell cell=new Cell();
                cell.setState(1);
                cell.setBrand(brands[flag++]);
                cells[row][col]=cell;
            }
            
        }

        System.out.println("--------layer---------");
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
               Brand brand= cells[row][col].getBrand();
                System.out.print(brand.getName()+"-");
            }
            System.out.println();
        }

    }
}
