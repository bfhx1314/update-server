package com.limn.update.server.service.impl;

import com.limn.update.server.bean.FileServerVo;
import com.limn.update.server.bean.ResponseVo;
import com.limn.update.server.common.Utils;
import com.limn.update.server.service.FileServerService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class FileServerServiceImpl implements FileServerService {



    @Override
    public FileServerVo upLoad(MultipartFile file, String path , String fileName) {


        FileServerVo fileServerVo = new FileServerVo();
        try {
            if (null == file) {

                fileServerVo.setStatus("0");
                fileServerVo.setDetail("文件不能为空");
                return fileServerVo;
            }
            InputStream input = null;

            input = file.getInputStream();

            String filePath = Utils.getConfigVar("fileServerPath") + path + "/";

            if (!new File(filePath).exists()) {
                new File(filePath).mkdirs();
            }
            if(null == fileName || fileName.isEmpty()) {
                fileName = file.getOriginalFilename();

            }
            filePath = filePath + fileName;

            FileOutputStream fos = new FileOutputStream(filePath);
            // 把数据存入路径+文件名
            byte buf[] = new byte[1024];
            do {
                // 循环读取
                int numread = input.read(buf);
                if (numread == -1) {
                    break;
                }
                fos.write(buf, 0, numread);
            } while (true);
            try {
                fos.flush();
                fos.close();
                input.close();
            } catch (Exception ex) {

            }

            fileServerVo.setStatus("1");
            fileServerVo.setDetail("文件上传成功");
            String url = Utils.getConfigVar("serverURL");
            fileServerVo.setFilePath(url + "/" + path + "/" + fileName);
            fileServerVo.setFileName(fileName);

        } catch (IOException e) {
            fileServerVo.setStatus("0");
            fileServerVo.setDetail(e.getMessage());
            e.printStackTrace();
        }
        return fileServerVo;
    }

    @Override
    public ResponseVo list(String path) {

        ResponseVo responseVo = new ResponseVo();

        String fileServerPath = Utils.getConfigVar("fileServerPath") + "/" + path;

        File files = new File(fileServerPath);

        if(!files.exists() || !files.isDirectory()){
            responseVo.setStatus("0");
            responseVo.setDetail("文件地址不存在:" + fileServerPath);
            return responseVo;
        }

        String url = Utils.getConfigVar("serverURL");
        List<FileServerVo> fileServerVoList = new ArrayList<>();
        for(File file : files.listFiles()){
            FileServerVo fileServerVo = new FileServerVo();
            fileServerVo.setFileName(file.getName());
            fileServerVo.setFilePath(url + "/" + path + "/" + file.getName());
            fileServerVoList.add(fileServerVo);
        }

        responseVo.setData(fileServerVoList);
        responseVo.setStatus("1");

        return responseVo;
    }
}
