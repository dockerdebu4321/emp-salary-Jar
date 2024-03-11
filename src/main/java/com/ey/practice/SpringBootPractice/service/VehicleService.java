package com.ey.practice.SpringBootPractice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.practice.SpringBootPractice.bean.VehicleBean;
import com.ey.practice.SpringBootPractice.model.VehicleEntity;
import com.ey.practice.SpringBootPractice.repository.VehicleRepository;
@Service
public class VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<VehicleBean> getAllVehicle() {
		List<VehicleBean> vBeanList=new ArrayList<>();
		List<VehicleEntity> vehentityList = vehicleRepository.findAll();
		for (VehicleEntity currentVehEntity : vehentityList) {
		VehicleBean vehBean=new VehicleBean();
		vehBean.setId(currentVehEntity.getVid());
		vehBean.setName(currentVehEntity.getVehicleName());
		vehBean.setBrand(currentVehEntity.getVehicleBrand());
		vehBean.setType(currentVehEntity.getVehicleType());
		vehBean.setAge(currentVehEntity.getAge());
		vehBean.setEvehicle_evolved(currentVehEntity.isEvehicle_evolved());
		vehBean.setHave_regd_number(currentVehEntity.isHave_regd_number());
		vBeanList.add(vehBean);
	}
		
		return vBeanList;
   }
}
