package com.jianglijiuju.util;

import com.jianglijiuju.model.Brand;
import com.jianglijiuju.model.Cell;
import com.jianglijiuju.model.Layer;

public class LayerUtil {
    public static Layer build(Integer rowNum,Integer colNum){
        Layer layer= null;//创建一个容量为36的二维数组
        try {
            layer = new Layer(rowNum,colNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Brand[] brands=BrandUtil.buildBrands(layer.getCapacity());

        //把打乱的牌数组一个个放到cell二维数组里
        int flag=0;
        Cell[][] cells=layer.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand brand=brands[flag++];
                Cell cell=new Cell();
                cell.setState(1);
                cell.setBrand(brand);

                brand.setCell(cell);
                cells[row][col]=cell;
            }
        }
       // layer.showCells();
        return layer;

    }
}
