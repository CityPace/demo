package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class RandomCodeUtil {
	public static BufferedImage createImage(HttpServletRequest request)
	{
		//创建缓冲图像
		int width = 60;
		int height = 20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random(); 
		//设置背景颜色
		g.setColor(getRandColor(200,250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman",Font.PLAIN,18));
		g.setColor(getRandColor(160,200));
		for(int i=0;i<200;i++)
		{
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1= random.nextInt(12);
			int y1= random.nextInt(12);
			g.drawLine(x1, y1, x1, y1);
		}
		String sRand="";
		for(int i=0;i<4;i++)
		{
			String rand = String.valueOf(random.nextInt(10));
			sRand+=rand;
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),
					20+random.nextInt(110)));
			g.drawString(rand, 13*i+6, 16);
		}
		request.getSession().setAttribute("RANDOMCODE_IN_SeSSION", sRand);
		g.dispose();
		return image; 
	}
	private static Color getRandColor(int fc,int bc) {
        Random random = new Random();
        if(fc > 255) {
            fc = 255;
        }
        if(fc<0)
        {
        	fc = 0;
        }
        if(bc > 255) {
            bc = 255;
        }
        if(bc<0)
        {
        	bc = 0;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

}
