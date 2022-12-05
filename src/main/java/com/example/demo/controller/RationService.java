package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RationService {
	
	@Autowired
	RationRepo rationRepo;
	
	
	
	public String getstate() {
		String distlist =rationRepo.get_state();
		return distlist;
		
	}
	
	
	public String getDist(String state) {
		String distlist =rationRepo.get_dist(state);
		return distlist;
		
	}
	
	public List<Object[]> getulb(String district) {
		List<Object[]> distlist =rationRepo.get_ulb(district);
		return distlist;
		
	}
	
	public List<Object[]> getward(String ulb) {
		List<Object[]> distlist =rationRepo.get_ulb(ulb);
		return distlist;
		
	}
		
	
	public String getcount(String soc_group,String g){
		String count=null;
		List<Object[]> gen_male = rationRepo.get_gen_count(soc_group);
		for(Object[] gender :gen_male) {
			if(g=="m") {
				count = gender[0].toString();
			}else if(g=="f") {
				count =gender[1].toString();
			}
		}
		return count;
		
	}	
	
	public String getTotal(){
		String total= null;
		List<Object[]> totals = rationRepo.get_total();
		for(Object[] total_count :totals) {
			total = total_count[0].toString();
		}
		return total;
		
	}
	
	
	
	
	 public List<Object[]> registndetails(String soc_group,String gen,String office, String office_id) {
		 List<Object[]> dataitems = null ;
		  if(office.equals("dist")) {
			  dataitems =rationRepo.get_total_dis(office_id);
			  dataitems = rationRepo.get_gen_count_dis(office_id,soc_group);
			  
		  }else if(office.equals("ulb")) {
			  dataitems =rationRepo.get_total_ulb(office_id);
			  dataitems = rationRepo.get_gen_count_ulb(office_id,soc_group);
		  }else if(office.equals("ward")) {
			  dataitems =rationRepo.get_total_ward(office_id);
			  dataitems = rationRepo.get_gen_count_ward(office_id,soc_group);
		  }else if(office.equals("state")) {
			  dataitems =rationRepo.get_total_state(office_id);
			  dataitems = rationRepo.get_gen_count_state(office_id,soc_group);
		  }
		  else {
			 
		  }
		return dataitems;
		}

}
