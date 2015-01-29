package com.comdosoft.union.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 系统工具类<br>
 * <功能描述>
 *
 * @author shine 2014年8月13日
 *
 */
public class SysUtils {

    /**
     * 将json字符串转换成java对象
     * 
     * @param json
     * @param object
     * @return
     */
    public static Object parseJSONStringToObject(String json, Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, object.getClass());
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json字符串转换成List
     * 
     * @param json
     * @param object
     * @return
     */
    public static List<?> parseJSONStringToList(String json, Class<?> object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(List.class, object));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将java对象转换成json字符串
     * 
     * @param object
     * @return
     */
    public static String parseObjectToJSONString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取上传文件的名称<br>
     * <该文件已复制到指定目录>
     * 
     * @param request
     * @param imgInputName
     * @param uploadFilePath
     * @return
     * @throws IOException
     */
    public static String getUploadFileName(HttpServletRequest request, String imgInputName, String uploadFilePath) throws IOException {
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        MultipartFile multiFile = mRequest.getFile(imgInputName);
        if (null == multiFile || StringUtils.isEmpty(multiFile.getOriginalFilename())) {
            return null;
        }
        String originalFileName = multiFile.getOriginalFilename();// 源文件全名
        StringBuffer newFileName = new StringBuffer(UUID.randomUUID().toString());// 生成系统唯一文件名
        newFileName.append(originalFileName.substring(originalFileName.lastIndexOf(".")));// 拼接源文件扩展名
        String realPath = request.getServletContext().getRealPath(uploadFilePath);
        FileUtils.copyInputStreamToFile(multiFile.getInputStream(), new File(realPath, newFileName.toString()));
        return newFileName.toString();
    }

    /**
     * 截取字符串的前limit个字符
     *
     * @param string
     *            原字符串
     * @param limit
     *            截取长度
     * @return String
     */
    public static String substring(String string, int limit) {
        StringBuffer returnString = new StringBuffer();
        if (string == null || limit <= 0 || limit > string.length()) {
            return string;
        }
        char[] temp = string.toCharArray();
        for (int i = 0; i < limit; i++) {
            returnString.append(temp[i]);
        }
        return returnString.toString();
    }

    /**
     * 随机产生N位验证码
     * 
     * @return
     */
    public static char[] getRandNum(int n) {
        char[] rand = new char[n];
        String str = "123456789qwertyuiplkjhgfdsazxcvbnmQWERTYUIPLKJHGFDSAZXCVBNM";
        for (int i = 0; i < n; i++) {
            Random rd = new Random();
            int index = rd.nextInt(str.length());

            // 通过下标获取字符
            rand[i] = str.charAt(index);
        }
        return rand;
    }

    /**
     * 生成图片 - 验证码
     * 
     * @param randNum
     *            验证码
     * @return
     */
    public static BufferedImage generateRandImg(char[] randNum) {

        // 在内存中创建图象
        int width = 60, height = 30;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获取图形上下文
        Graphics g = image.getGraphics();

        // 生成随机类
        Random random = new Random();

        // 设定背景色
        g.setColor(getRandColor(200, 250));

        g.fillRect(0, 0, width, height);

        // 设定字体
        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        // 画边框
        // g.setColor(new Color());
        // g.drawRect(0,0,width-1,height-1);

        // 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 160; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        String strRandNum = "";
        for (int i = 0; i < 4; i++) {// 取出验证码(4位数字)
            strRandNum = Character.toString(randNum[i]);
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(strRandNum, 13 * i + 6, 20);// 将验证码显示到图象中
        }

        // 图象生效
        g.dispose();

        return image;
    }

    /**
     * 获得随机图片颜色
     * 
     * @param fc
     * @param bc
     * @return
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
    
    public static Boolean isNum(String str){
        if(null == str || str.equals("")) return false;
        Pattern pattern = Pattern.compile("[0-9]*");
        Boolean isNum = pattern.matcher(str).matches();
        return isNum;
    }

}