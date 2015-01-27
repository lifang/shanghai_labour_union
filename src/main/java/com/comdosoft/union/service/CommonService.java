package com.comdosoft.union.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.comdosoft.union.bean.app.AppPicture;
import com.comdosoft.union.dao.news.CommonMapper;

/**
 * 文章
 * 
 * @author lifang
 * 
 */
@Service
public class CommonService {

    @Resource
    private CommonMapper commonMapper;

    // @Value("${dir.root}")
    // private String dirRoot;

    @Value("${uploadPictureTempsPath}")
    private String uploadPictureTempsPath;

    @Value("${uploadPictureLargePath}")
    private String uploadPictureLargePath;

    @Value("${uploadPictureSmallPath}")
    private String uploadPictureSmallPath;

    @Value("${uploadStudentExeclTempPath}")
    private String uploadStudentExeclTempPath;

    /**
     * 查询
     * 
     * @return
     */
    public List<AppPicture> getPictures(Map<Object, Object> query) {
        return commonMapper.getPictures(query);
    }

    public String saveTmpImage(MultipartFile img, HttpServletRequest request) throws IOException {
        String fileName = Calendar.getInstance().getTimeInMillis() + ".jpg";
        // String realPath = dirRoot + imgTempPath;
        String realPath = request.getServletContext().getRealPath(uploadPictureTempsPath);
        File dir = new File(realPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        InputStream stream = img.getInputStream();
        Thumbnails.of(stream).size(480, 480).toFile(realPath + File.separator + fileName);
        stream.close();
        return uploadPictureTempsPath + fileName;
    }

    public String saveImage(HttpServletRequest request, String picUrl, Integer x, Integer y, Integer w, Integer h) throws IOException {
        String fileName = Calendar.getInstance().getTimeInMillis() + ".jpg";
        // String realPath = dirRoot + imgRealPath;
        String realPath = request.getServletContext().getRealPath(uploadPictureLargePath);
        // String smallPath = dirRoot + imgSmallPath;
        String smallPath = request.getServletContext().getRealPath(uploadPictureSmallPath);
        File realDir = new File(realPath);
        if (!(realDir).exists()) {
            realDir.mkdirs();
        }
        File smallDir = new File(smallPath);
        if (!(smallDir).exists()) {
            smallDir.mkdirs();
        }
        // InputStream stream = new FileInputStream(dirRoot + picUrl);
        InputStream stream = new FileInputStream(request.getServletContext().getRealPath(picUrl));
        Thumbnails.of(stream).sourceRegion(x, y, w, h).size(480, 480).toFile(realPath + File.separator + fileName);
        stream.close();
        // InputStream streamSmall = new FileInputStream(dirRoot + picUrl);
        InputStream streamSmall = new FileInputStream(request.getServletContext().getRealPath(picUrl));
        Thumbnails.of(streamSmall).sourceRegion(x, y, w, h).size(200, 200).toFile(smallPath + File.separator + fileName);
        streamSmall.close();
        return uploadPictureSmallPath + fileName;
    }

    public void savePictures(Integer foreignId, Integer foreignType, String[] imageUploadPath) {
        for (String p : imageUploadPath) {
            AppPicture picture = new AppPicture();
            picture.setForeignId(foreignId);
            picture.setForeignType(foreignType);
            picture.setPictureSmallFilePath(p);
            picture.setPictureLargeFilePath(p.replace("/small", ""));
            picture.setCreateTime(new Date());
            picture.setUpdateTime(new Date());
            commonMapper.insertPicture(picture);
        }
    }

    public void removePictures(Map<Object, Object> query) {
        commonMapper.removePicture(query);
    }

    public String saveTmpExcel(MultipartFile excel, HttpServletRequest request) {
        String fileName = Calendar.getInstance().getTimeInMillis() + ".xls";
        // String realPath = dirRoot + excelPath;
        String realPath = request.getServletContext().getRealPath(uploadStudentExeclTempPath);
        File dir = new File(realPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        InputStream stream = null;
        OutputStream os = null;
        String path = realPath + File.separator + fileName;
        try {
            stream = excel.getInputStream();
            os = new FileOutputStream(path);
            byte buffer[] = new byte[4 * 1024];
            while ((stream.read(buffer)) != -1) {
                os.write(buffer);
            }
            os.flush();
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        } finally {
            try {
                os.close();
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 
     * @param enumCodeType
     * @param enumTextName
     * @param enumTextDefaultName
     * @return
     */
    public int getEnumId(String enumCodeType, String enumTextName, String enumTextDefaultName) {
        Map<Object, Object> query = new HashMap<Object, Object>();
        query.put("enumCodeType", enumCodeType);
        query.put("enumTextName", enumTextName);
        query.put("enumTextDefaultName", enumTextDefaultName);
        return commonMapper.getEnumId(query);
    }

}