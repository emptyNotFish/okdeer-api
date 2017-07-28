package com.okdeer.mall.common;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

/**
 * DESC: 数字验证码生成工具
 * @author LIU.W
 * @DATE 2016年3月8日上午17:55:21
 * @version 0.1.0
 * @copyright ©2005-2020 yschome.com Inc. All rights reserved
 * =================================================================================================
 *     Task ID			  Date			     Author		      Description
 * ----------------+----------------+-------------------+-------------------------------------------
 *		重构V4.1			2016-08-19			wushp				生成验证码
 */
public class VerifyCodeUtils {
	
	private static String[] seedArray = { "1", "2", "3", "4", "5", "6", "7", "8", "9","0" };

	private static String[] seedNineArray = { "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	public static String getVerifyCodeString(int length) {
		Random random = new Random();
		StringBuffer verifyCode = new StringBuffer();
		int indexNine = random.nextInt(seedNineArray.length);
		verifyCode.append(seedNineArray[indexNine]);
		for (int i = 1; i < length; i++) {
			int index = random.nextInt(seedArray.length);
			verifyCode.append(seedArray[index]);
		}
		return verifyCode.toString();
	}

	// begin 重构4.1 add by wushp 20160819
	/**
	 * 
	 * @Description: 生成图形验证码
	 * @param verifyCode 验证码
	 * @param width 宽
	 * @param height 高
	 * @return ByteArrayInputStream   字节数组输入流
	 * @throws Exception exception
	 * @author wushp
	 * @date 2016年8月19日
	 */
	public static ByteArrayInputStream generateImage(String verifyCode, int width, int height) throws Exception{
		Random random = new Random();
		BufferedImage image = new BufferedImage(width, height, 1);
		Graphics g = image.getGraphics();
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", 2, 28));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl =random.nextInt(12);
			int yl =random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		char[] codes = verifyCode.toCharArray();
		for (int i = 0; i < codes.length; i++) {
			g.setColor(new Color(20 + random.nextInt(110),
					20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(String.valueOf(codes[i]), 20 * i + 10, 30);
		}
		g.dispose();
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			ImageOutputStream imageOut = ImageIO
					.createImageOutputStream(output);
			ImageIO.write(image, "JPEG", imageOut);
			imageOut.close();
			input = new ByteArrayInputStream(output.toByteArray());
		} catch (Exception e) {
			throw new RuntimeException("验证码图片生成异常!", e);
		}
		
		return input;
	}
	
	/**
	 * 
	 * @Description: TODO
	 * @param fc 宽
	 * @param bc 高
	 * @return Color 图形验证码 
	 * @author wushp
	 * @date 2016年8月19日
	 */
	private static Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	// end 重构4.1 add by wushp 20160819
}
