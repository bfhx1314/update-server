package com.limn.update.server.service;

import com.limn.update.server.bean.QttUserInfoVo;
import com.limn.update.server.bean.TaskRecordVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by limengnan on 2018/1/26.
 */
public interface SshhwwService {

    void uploadLua(MultipartFile file);
    void uploadPhp(MultipartFile file);
    TaskRecordVo getTask(String uuid , String type, String deviceName);
    boolean isAuthByUuid(String uuid);

}
