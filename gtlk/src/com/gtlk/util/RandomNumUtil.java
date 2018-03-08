package com.gtlk.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class RandomNumUtil {
	
	//图像
	private ByteArrayInputStream inputStream;
	//验证码
	private String randomCode;
	
	public RandomNumUtil(int width,int height,int size,int fontSize) throws Exception{
		init(width,height,size,fontSize);
	}
	
	private void init(int width,int height,int size,int fontSize) throws Exception{
		//在内存中创建图像
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//获取图形上下文
		Graphics g = image.getGraphics();
		//固定淡颜色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//设定字体 
		g.setFont(new Font("Engravers MT",Font.BOLD,fontSize));
		//设置边框
		g.setColor(new Color(143, 167, 131));
		g.drawRect(0, 0, width - 1 , height - 1);
		
		//取随机产生的认证码(size个数字)
		this.randomCode = this.getRandCode(g,size);
		//图想法生效
		g.dispose();
		
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
		ImageIO.write(image,"JPEG",imageOut);
		imageOut.close();
		ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
		this.setInputStream(input);
	}
	
	private String getRandCode(Graphics g,int size){
		Random random = new Random();
		String sRand = "";
		for(int i = 0; i < size; i++){
			int x = random.nextInt(9);
			String rand = String.valueOf(x);
			sRand += rand;
			
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 13 * i + 6, 19);
		}
		return sRand;
	}
	
	public void setRandomCode(String randomCode){
		this.randomCode = randomCode;
	}
	
	public String getRandomCode() throws Exception{
		return this.randomCode;
	}
	
	public void setInputStream(ByteArrayInputStream inputStream){
		this.inputStream = inputStream;
	}
	
	public ByteArrayInputStream getInputStream(){
		return inputStream;
	}
}
