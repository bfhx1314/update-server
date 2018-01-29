package com.limn.update.server.dao;

import com.limn.update.server.entity.WXCMUpdateEntity;

/**
 * Created by limengnan on 2018/1/25.
 */
public interface WXCMUpdateDao extends BaseDao<WXCMUpdateEntity> {

    WXCMUpdateEntity getUpdateVersion(WXCMUpdateEntity wxcmUpdateEntity);

}
