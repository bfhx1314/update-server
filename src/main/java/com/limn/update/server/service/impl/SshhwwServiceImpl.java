package com.limn.update.server.service.impl;

import com.limn.tool.common.DateFormat;
import com.limn.update.server.bean.TaskRecordVo;
import com.limn.update.server.dao.SshhwwAuthUuidDao;
import com.limn.update.server.dao.SshhwwTaskDao;
import com.limn.update.server.dao.SshhwwTaskRecordDao;
import com.limn.update.server.dao.SshhwwUpdateDao;
import com.limn.update.server.entity.SshhwwTaskEntity;
import com.limn.update.server.entity.SshhwwTaskRecordEntity;
import com.limn.update.server.enumeration.WXCMEnum;
import com.limn.update.server.service.FileServerService;
import com.limn.update.server.service.SshhwwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Created by limengnan on 2018/1/26.
 */

@Service
public class SshhwwServiceImpl implements SshhwwService {
    @Autowired
    FileServerService fileServerService;

    @Autowired
    SshhwwUpdateDao sshhwwUpdateDao;

    @Autowired
    SshhwwTaskDao sshhwwTaskDao;

    @Autowired
    SshhwwTaskRecordDao sshhwwTaskRecordDao;

    @Autowired
    SshhwwAuthUuidDao sshhwwAuthUuidDao;

    @Override
    public void uploadLua(MultipartFile file) {
        fileServerService.upLoad(file,WXCMEnum.UPDATEPATH.getCode(), WXCMEnum.LUA.getCode());

    }

    @Override
    public void uploadPhp(MultipartFile file) {

    }

    @Override
    public TaskRecordVo getTask(String uuid, String type, String deviceName) {

        TaskRecordVo taskRecordVo = new TaskRecordVo();

        if (!sshhwwAuthUuidDao.isAuthByUuid(uuid)){
            taskRecordVo.setStatus("1");
            taskRecordVo.setTaskRecordId(-1);
            taskRecordVo.setDetail("无授权执行脚本");
            return taskRecordVo;
        }

        List<SshhwwTaskEntity> listTask = sshhwwTaskDao.getTask(uuid);

        if(listTask == null || listTask.size() == 0){
            taskRecordVo.setStatus("1");
            taskRecordVo.setTaskRecordId(-1);
            taskRecordVo.setDetail("无任务");
            return taskRecordVo;
        }

        SshhwwTaskEntity sshhwwTaskEntity = listTask.get(0);
        SshhwwTaskRecordEntity taskRecord = new SshhwwTaskRecordEntity();

        taskRecord.setStatus("0");
        taskRecord.setValid("Y");
        taskRecord.setTaskId(sshhwwTaskEntity.getId());
        taskRecord.setUuid(uuid);
        taskRecord.setValue("");
        taskRecord.setDeviceName(deviceName);
        taskRecord.setCreateDate(new Date());
        sshhwwTaskRecordDao.save(taskRecord);

        taskRecordVo.setTaskRecordId(taskRecord.getId());
        taskRecordVo.setTaskRecordName(sshhwwTaskEntity.getType());

        return taskRecordVo;

    }

    @Override
    public boolean isAuthByUuid(String uuid) {
        return sshhwwAuthUuidDao.isAuthByUuid(uuid);
    }
}
