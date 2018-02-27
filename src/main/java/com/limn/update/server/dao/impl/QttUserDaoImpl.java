package com.limn.update.server.dao.impl;

import com.limn.tool.common.DateFormat;
import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.QttUserDao;
import com.limn.update.server.dao.RecordLogDao;
import com.limn.update.server.entity.QttUserEntity;
import com.limn.update.server.entity.RecordLogEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Repository
@Transactional
public class QttUserDaoImpl extends BaseDaoImpl<QttUserEntity> implements QttUserDao {

    @Autowired
    public void setDao(BaseDao<QttUserEntity> dao) {
        super.setDao(dao);
    }


    @Override
    public QttUserEntity getExeUser() {
        Session newSession = getSession();
        Query query = newSession.createQuery("from QttUserEntity where lastActivate < ? and valid='Y' and status = 1 order by lastActivate");

        Date dt= DateFormat.getDate();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.HOUR_OF_DAY,-5);

        query.setParameter(0, rightNow.getTime());
        List<QttUserEntity> users = query.list();

        if(users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }
}
