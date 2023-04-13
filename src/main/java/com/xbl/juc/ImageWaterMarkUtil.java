package com.xbl.juc;

import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageWaterMarkUtil {

    /**
     * 给图片添加水印文字、可设置水印文字的大小、旋转角度、透明度
     *
     * @param logoText      水印内容
     * @param srcImgPath    原图片路径
     * @param targetImgPath 目标图片路径
     */
    public static void markImageByText(String logoText, String srcImgPath,
                                       String targetImgPath) throws IOException {

        // 1、读取源图片，Image获取图片宽度、高度
        Image scrImg = ImageIO.read(new File(srcImgPath));
        BufferedImage buffImg = new BufferedImage(scrImg.getWidth(null), scrImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

        // 2、得到画笔对象
        Graphics2D graphics = buffImg.createGraphics();

        // 3、设置对线段的锯齿状边缘处理
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.drawImage(scrImg.getScaledInstance(scrImg.getWidth(null), scrImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);

        // 4、设置水印倾斜度，这里是在图片的对角线上
        // 对角线长度lengthOfDiagonal
        double lengthOfDiagonal = Math.sqrt(Math.pow(buffImg.getWidth(), 2) + Math.pow(buffImg.getHeight(), 2));
        double v = (Math.pow(buffImg.getWidth(), 2) + Math.pow(lengthOfDiagonal, 2) - Math.pow(buffImg.getHeight(), 2)) / (2 * buffImg.getWidth() * lengthOfDiagonal);
        //get到了一个弧度数
        double acos = Math.acos(v);
        double myDegree = Math.toDegrees(acos);
        //这里的负号决定对角线-Math.toRadians(myDegree)
        graphics.rotate(-Math.toRadians(myDegree),
                (double) buffImg.getWidth() / 2,
                (double) buffImg.getHeight() / 2);

        // 5、设置水印文字颜色
        graphics.setColor(Color.RED);

        // 6、获取源图片的宽度和高度
        int width = scrImg.getWidth(null);
        int heigth = scrImg.getHeight(null);

        // 7、设置水印文字大小（根据原图的宽、高度，我这里是哪个长就取哪个，再除上水印字符串长度，记为size）
        int size = width >= heigth ? width / logoText.length() : heigth / logoText.length();
//        if (width >= heigth) {
//            size = width / logoText.length();
//        } else {
//            size = heigth / logoText.length();
//        }
        //Font是JAVA中的字体类，PLAIN：普通样式常量；BOLD：粗体样式常量；ITALIC：斜体样式常量
        //如下初始化对象:Font font = new Font("宋体" , Font.BOLD , 23)；该字体表示23磅粗体的宋体字
        graphics.setFont(new Font("宋体", Font.PLAIN, size));

        //8、设置透明度
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                0.3f));

        //9、设置文字位置
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(graphics.getFont());
        //获取文字宽度
        int strWidth = metrics.stringWidth(logoText);
        int strHeight = metrics.getHeight();
        //文字在画布上的坐标
        int left = (width - strWidth) / 2;
        //有条基线，加上ascent，相当于画布要向上移动（或是文字向下移），才能保证文字是居中的
        int top = (heigth - strHeight) / 2 + metrics.getAscent();

        //10、水印文字开始动工了，文字内容，x,y坐标
        graphics.drawString(logoText, left, top);

        //11、释放资源
        graphics.dispose();

        //12、生成图片
        try {
            OutputStream os = null;
            os = new FileOutputStream(targetImgPath);
            ImageIO.write(buffImg, "jpg", os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给图片添加水印文字、可设置水印文字的大小、旋转角度、透明度
     *
     * @param logoText   水印内容
     * @param srcImgPath 原图片路径
     * @param targerPath 目标图片路径
     */
    public static void markImageByTextAll(String logoText, String srcImgPath,
                                   String targerPath) throws IOException {

        // 1、读取源图片，Image获取图片宽度、高度
        Image scrImg = ImageIO.read(new File(srcImgPath));
        BufferedImage buffImg = new BufferedImage(scrImg.getWidth(null), scrImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

        // 2、得到画笔对象
        Graphics2D graphics = buffImg.createGraphics();

        // 3、设置对线段的锯齿状边缘处理
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.drawImage(scrImg.getScaledInstance(scrImg.getWidth(null), scrImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);

        // 4、设置水印倾斜度，这里是在图片的对角线上
        // 对角线长度lengthOfDiagonal
        double lengthOfDiagonal = Math.sqrt(Math.pow(buffImg.getWidth(), 2) + Math.pow(buffImg.getHeight(), 2));
        double v = (Math.pow(buffImg.getWidth(), 2) + Math.pow(lengthOfDiagonal, 2) - Math.pow(buffImg.getHeight(), 2)) / (2 * buffImg.getWidth() * lengthOfDiagonal);
        //get到了一个弧度数
        double acos = Math.acos(v);
        double myDegree = Math.toDegrees(acos);
        //这里的负号决定对角线-Math.toRadians(myDegree)
        graphics.rotate(-Math.toRadians(myDegree),
                (double) buffImg.getWidth() / 2,
                (double) buffImg.getHeight() / 2);

        // 5、设置水印文字颜色
        graphics.setColor(Color.DARK_GRAY);


        // 6、获取源图片的宽度和高度
        int width = scrImg.getWidth(null);
        int heigth = scrImg.getHeight(null);


        graphics.setFont(new Font("微软雅黑", Font.BOLD, 50));

        //8、设置透明度
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                0.2f));

        //9、设置文字位置
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(graphics.getFont());
        //获取文字宽度
        int strWidth = metrics.stringWidth(logoText);

        int xNum = width / strWidth + 1;

        int yNum = heigth / 50 + 1;

        int split = 50;

        for (int i = 1; i <= 2 * yNum; i++) {
            int y = -heigth + 50 * i + 5 * split * i;
            for (int j = 0; j < xNum; j++) {
                int x = strWidth * j + 3 * split * j;
                graphics.drawString(logoText, x, y);
            }
        }

        //11、释放资源
        graphics.dispose();

        //12、生成图片
        try {
            OutputStream os = null;
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "jpg", os);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
