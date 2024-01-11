package com.jianglijiuju.model;

import com.jianglijiuju.test.TestRenderMap;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//一个牌
public class Brand extends Component {
    private String name;  //牌的名字
    private Boolean isGrey;  //灰色牌
    private Image image;  //正常图片
    private Image greyImage;  //灰色图片

    private Integer x;  //坐标 当前牌左上角坐标
    private Integer y;
    private Integer width;
    private Integer height;

    private Cell cell;
    ElimateBox elimateBox=new ElimateBox();

    public Brand(String name){
        this.name = name;
        this.image=Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
        this.greyImage=Toolkit.getDefaultToolkit().getImage("imgs\\"+name+"_灰.png");

        this.isGrey=false;
        this.width=45;
        this.height=45;

        this.x=0;
        this.y=0;

        //鼠标点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Brand brand=(Brand)e.getSource();//获取当前的组件,强转为brand对象类型
                if(brand.getGrey()){
                    //灰色无法被点击
                    return;
                }else{
                   // brand.getParent().remove(brand);//通过父容器删掉自己 一般树形结构使用
                    elimateBox.addSlot(brand);//添加到消除区域
                    //数据模型中的牌也要删除！
                    cell.setState(0);
                    cell.setBrand(null);

                    //每次消除一张牌又要重新判定置灰的牌
                    TestRenderMap.map.compareAll();
                }

            }
        });


    }

    @Override
    public void paint(Graphics g) {
        if(this.isGrey){
            //绘制灰色图片
            g.drawImage(this.greyImage,this.x,this.y,null);
        }else{
            //绘制正常图片
            g.drawImage(this.image,this.x,this.y,null);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGrey() {
        return isGrey;
    }

    public void setGrey(Boolean grey) {
        isGrey = grey;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getGreyImage() {
        return greyImage;
    }

    public void setGreyImage(Image greyImage) {
        this.greyImage = greyImage;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
    //    public Integer getX() {
//        return x;
//    }
//
//    public void setX(Integer x) {
//        this.x = x;
//    }
//
//    public Integer getY() {
//        return y;
//    }
//
//    public void setY(Integer y) {
//        this.y = y;
//    }

//    public Integer getWidth() {
//        return width;
//    }
//
//    public void setWidth(Integer width) {
//        this.width = width;
//    }
//
//    public Integer getHeight() {
//        return height;
//    }
//
//    public void setHeight(Integer height) {
//        this.height = height;
//    }
}
