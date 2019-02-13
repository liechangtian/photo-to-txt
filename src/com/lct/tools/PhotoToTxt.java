package com.lct.tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class PhotoToTxt {

  public static void main(String[] args) throws Exception {
    System.out.println("Hello World!");
    String path = "/home/ws/downloads/304770087.jpg";
//    String path = "/home/ws/downloads/685996169.jpg";
//    String path = "/home/ws/downloads/1355981174.jpg";

    final String base = "@#&$%*o!;.";
    final BufferedImage image = ImageIO.read(new File(path));
    for (int y = 0; y < image.getHeight(); y += 2) {
      for (int x = 0; x < image.getWidth(); x += 1) {
        int pixel = image.getRGB(x, y);
        int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = (pixel & 0xff);
        float gray = 0.299f * r + 0.578f * g + 0.114f * b;
        int index = Math.round(gray * (base.length() + 1) / 255);
        System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
      }
      System.out.println();
    }

  }


}
