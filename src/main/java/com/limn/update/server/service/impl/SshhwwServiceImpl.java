package com.limn.update.server.service.impl;

import com.limn.update.server.bean.TaskRecordVo;
import com.limn.update.server.dao.*;
import com.limn.update.server.entity.SshhwwTaskEntity;
import com.limn.update.server.entity.SshhwwTaskRecordEntity;
import com.limn.update.server.entity.SshhwwTaskUuidEntity;
import com.limn.update.server.enumeration.TaskEnum;
import com.limn.update.server.enumeration.WXCMEnum;
import com.limn.update.server.service.FileServerService;
import com.limn.update.server.service.SshhwwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    SshhwwConfigDao sshhwwConfigDao;

    @Autowired
    SshhwwTaskUuidDao sshhwwTaskUuidDao;

    @Override
    public void uploadLua(MultipartFile file) {
        fileServerService.upLoad(file,WXCMEnum.UPDATEPATH.getCode(), WXCMEnum.LUA.getCode());

    }

    @Override
    public void uploadPhp(MultipartFile file) {

    }

    @Override
    @Transactional
    public TaskRecordVo getTask(String uuid, String type, String deviceName, String version) {

        TaskRecordVo taskRecordVo = new TaskRecordVo();
        taskRecordVo.setStatus("1");
        if (!sshhwwAuthUuidDao.isAuthByUuid(uuid)){

            taskRecordVo.setTaskRecordId(-1);
            taskRecordVo.setDetail("无授权执行脚本");
            return taskRecordVo;
        }

        List<SshhwwTaskEntity> listTask = sshhwwTaskDao.getTask(uuid,type);

        if(listTask == null || listTask.size() == 0){
            taskRecordVo.setTaskRecordId(-1);
            taskRecordVo.setDetail("无任务");
            return taskRecordVo;
        }

        SshhwwTaskEntity sshhwwTaskEntity = listTask.get(0);
        SshhwwTaskRecordEntity taskRecord = new SshhwwTaskRecordEntity();
        taskRecord.setVersion(version);
        taskRecord.setStatus("0");
        taskRecord.setValid("Y");
        taskRecord.setTaskId(sshhwwTaskEntity.getId());
        taskRecord.setUuid(uuid);
        taskRecord.setValue(sshhwwTaskEntity.getValue());
        taskRecord.setDeviceName(deviceName);
        taskRecord.setCreateDate(new Date());
        sshhwwTaskRecordDao.save(taskRecord);

        if(taskRecord.getValue().equalsIgnoreCase(TaskEnum.TAOBAOLIVE)){
            SshhwwTaskUuidEntity sshhwwTaskUuidEntity = sshhwwTaskUuidDao.getTaskData(TaskEnum.TAOBAOLIVE,uuid);
            taskRecordVo.setData(sshhwwTaskUuidEntity.getValue() == null ? "" : sshhwwTaskUuidEntity.getValue());
        }

        taskRecordVo.setTaskRecordId(taskRecord.getId());
        taskRecordVo.setTaskRecordName(sshhwwTaskEntity.getValue());

        return taskRecordVo;
    }


    @Override
    public boolean isAuthByUuid(String uuid) {
        return sshhwwAuthUuidDao.isAuthByUuid(uuid);
    }

    @Override
    public String insurance() {

        String value = sshhwwConfigDao.getConfigByKey("insurance");
        if(value.equalsIgnoreCase("YES")){
            return "YES";
        }
        return "NO";
    }


}
