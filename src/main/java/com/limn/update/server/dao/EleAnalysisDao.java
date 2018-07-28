package com.limn.update.server.dao;


import java.util.List;

public interface EleAnalysisDao<T> extends BaseDao<T> {

    List<T> getNoAnalysis(int maxCount);

}
