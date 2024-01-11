package com.jianglijiuju.util;

import com.jianglijiuju.model.Brand;
import com.jianglijiuju.model.Layer;

import java.util.Random;

//工具类 提供创建牌相关的公共方法
public class BrandUtil {
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

    public static Brand[] buildBrands(Integer capacity){
        Brand[] brands=new Brand[capacity];//36容量的数组
        //3张相同牌消除,步调为3
        //为了避免容量不够，容量必须为3的倍数
        //随机打散数组
        for (int i = 0; i < brands.length ; i=i+2) {
            String randomName=getName();
            Brand brand1=new Brand(randomName);
            Brand brand2=new Brand(randomName);
          //  Brand brand3=new Brand(randomName);
            brands[i]=brand1;
            brands[i+1]=brand2;
          //  brands[i+2]=brand3;
        }
        //打乱算法
        for (int i = 0; i < brands.length; i++) {
            Brand brandA=brands[i];//当前位置的变量
            int randomIndex=random.nextInt(brands.length);//交换位置的索引
            Brand brandB=brands[randomIndex];
            Brand temp=brandA;
            brands[i]=brandB;
            brands[randomIndex]=temp;
        }
        return brands;
    }
}
