package com.prew.liveat500px.Manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;
import com.prew.liveat500px.DAO.PhotoItemCollectionDao;
import com.prew.liveat500px.DAO.PhotoItemDao;

import java.util.ArrayList;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class PhotoListManager {

    private Context mContext;
    private PhotoItemCollectionDao dao;

    public PhotoListManager() {
        mContext = Contextor.getInstance().getContext();
        loadCache();
    }

    public PhotoItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(PhotoItemCollectionDao dao) {

        this.dao = dao;
        saveCache();
    }

    public void insertDaoAtTopPosition(PhotoItemCollectionDao newDao) {
        if (dao == null)
            dao = new PhotoItemCollectionDao();
        if (dao.getData() == null)
            dao.setData(new ArrayList<PhotoItemDao>());
        dao.getData().addAll(0, newDao.getData());
        saveCache();
    }

    public void appendDaoaAtBottomPosition(PhotoItemCollectionDao newDao) {
        if (dao == null)
            dao = new PhotoItemCollectionDao();
        if (dao.getData() == null)
            dao.setData(new ArrayList<PhotoItemDao>());
        dao.getData().addAll(dao.getData().size(), newDao.getData());
        saveCache();
    }

    public int getMaximunId() {
        if (dao == null) {
            return 0;
        }
        if (dao.getData() == null) {
            return 0;
        }
        if (dao.getData().size() == 0) {
            return 0;
        }
        int maxId = dao.getData().get(0).getId();
        for (int i = 1; i < dao.getData().size(); i++)
            maxId = Math.max(maxId, dao.getData().get(i).getId());
        return maxId;

    }

    public int getMinimumId() {
        if (dao == null) {
            return 0;
        }
        if (dao.getData() == null) {
            return 0;
        }
        if (dao.getData().size() == 0) {
            return 0;
        }
        int minId = dao.getData().get(0).getId();
        for (int i = 1; i < dao.getData().size(); i++)
            minId = Math.min(minId, dao.getData().get(i).getId());
        return minId;

    }

    public int getCount() {
        if (dao == null)
            return 0;
        if (dao.getData() == null)
            return 0;
        return dao.getData().size();
    }

    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("dao", dao);
        return bundle;
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        dao = savedInstanceState.getParcelable("dao");
    }

    private void saveCache() {

        PhotoItemCollectionDao cacheDao = new PhotoItemCollectionDao();
        if (dao != null && dao.getData() != null) {
            cacheDao.setData(dao.getData().subList(0, Math.min(20, getDao().getData().size())));
        }
        String json = new Gson().toJson(cacheDao);

        SharedPreferences preferences = mContext.getSharedPreferences("photos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        //Add/Edit/
        editor.putString("json",json);
        editor.apply();
    }

    private void loadCache() {
        SharedPreferences preferences = mContext.getSharedPreferences("photos", Context.MODE_PRIVATE);
        String json = preferences.getString("json",null);
        if (json == null)
        {
            return;
        }
        dao = new Gson().fromJson(json,PhotoItemCollectionDao.class);
    }
}
