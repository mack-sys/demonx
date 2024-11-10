package com.example.live.serviceinterface;

import java.util.List;

import com.example.live.entity.DemonUser;

public interface DemonUserServiceInterface {
	
	//save data
	public void save(DemonUser demonUser);
	
	//getting all data from demon user
	public void saveDemonUser(DemonUser demonUser);
	
	public List<DemonUser> getAllDemonUser();

}
