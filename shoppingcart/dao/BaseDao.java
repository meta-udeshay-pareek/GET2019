package dao;

import Enum.Status;

public interface BaseDao {
	public Status create(Object obj);
	public Status delete(Object obj);
	public Object get(int id);
}
