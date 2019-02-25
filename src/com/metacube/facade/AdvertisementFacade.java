package com.metacube.facade;

import java.util.List;

import com.metacube.dao.AdvertisementDao;
import com.metacube.enums.DBType;
import com.metacube.enums.EntityName;
import com.metacube.enums.Status;
import com.metacube.factory.DaoFactory;
import com.metacube.view.AdvertisementView;
import com.metacube.model.Advertisement;

public class AdvertisementFacade {

	static AdvertisementFacade advertisement = new AdvertisementFacade();

	AdvertisementDao advertisementdao = (AdvertisementDao) DaoFactory.getDaoForEntity(EntityName.ADVERTISEMENT, DBType.MY_SQL);

	public static AdvertisementFacade getInstance() {
		return advertisement;
	}

	/**
	 * Function to return the insert status of the CategoryDao
	 * 
	 * @param category
	 * @return
	 */
	public Status insertStatus(Advertisement advertisement) {
		boolean status = advertisementdao.CheckAdvertisement(advertisement.getTitle());

		if (status) {
			return Status.DUPLICATE;
		}

		advertisementdao.insert(advertisement);
		return Status.CREATED;
	}

	/**
	 * Function to return the update status of the CategoryDao
	 * 
	 * @param category
	 * @return
	 */
	
	public Status updateStatus(Advertisement advertisement) {

		advertisementdao.update(advertisement);
		return Status.UPDATED;
	}

	/**
	 * Function to get the List of category
	 * 
	 * @param category
	 * @return
	 */
	public List<Advertisement> getList() {
		List<Advertisement> listOfCategory = advertisementdao.getlist();
		return listOfCategory;
	}

	/**
	 * Function to get list of advertisement by id
	 * 
	 * @param id
	 * @return
	 */
	public List<AdvertisementView> getListById(int id) {
		List<AdvertisementView> listOfAdvertisement = advertisementdao
				.getListById(id);

		return listOfAdvertisement;
	}

	/**
	 * Function to delete the advertisement
	 * 
	 * @param advertisement
	 * @return status
	 */
	public Status deleteStatus(int id) {

		advertisementdao.deleteById(id);
		return Status.DELETED;

	}

}
