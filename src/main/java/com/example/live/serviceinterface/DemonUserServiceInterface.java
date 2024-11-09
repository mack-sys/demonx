package com.example.live.serviceinterface;

import java.util.List;

import com.example.live.entity.DemonUser;

public interface DemonUserServiceInterface {
	
	public void saveDemonUser(DemonUser demonUser);
	public List<DemonUser> getAllDemonUser();

}
