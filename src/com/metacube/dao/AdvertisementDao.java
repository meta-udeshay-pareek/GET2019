package com.metacube.dao;

import java.util.List;

import com.metacube.view.AdvertisementView;

public interface AdvertisementDao extends BaseDao<com.metacube.model.Advertisement> {
	

	public boolean CheckAdvertisement(String name);

	public List<AdvertisementView> getListById(int category_id);

	public void deleteById(int id);
}
