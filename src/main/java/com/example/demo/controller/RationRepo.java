package com.example.demo.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface RationRepo extends JpaRepository<Applicant, Integer> {
	
	@Query(value="select sum(case when a.gender='m' then 1 else 0 end) as Male,sum(case when a.gender='f' then 1 else 0 end) as Female from applicant a join registration b on a.regid=b.regid where b.social= :social",nativeQuery = true)
	List<Object[]> get_gen_count(String social);
	
	@Query(value = "select count(a.regid) from applicant a join registration b on a.regid=b.regid where b.social in ('General','SC','ST')",nativeQuery = true)
	List<Object[]> get_total();
	
	@Query(value = "select state from ulb",nativeQuery = true)
	String get_state();
	
	
	@Query(value = "select district from ulb where state= :state",nativeQuery = true)
	String get_dist(String state);
	
	@Query(value = "select ulb from ulb where district= :district",nativeQuery = true)
	List<Object[]> get_ulb(String district);
	
	@Query(value = "select ulb from ulb where ulb= :ulb",nativeQuery = true)
	List<Object[]> get_ward(String ulb);
	
	
	@Query(value= "select count(a.regid) from applicant a join registration b on a.regid=b.regid where b.social in ('General','SC','ST') AND b.state= :state",nativeQuery =true)
    List<Object[]> get_total_state(String state);
    @Query(value = "select sum(case when a.gender='m' then 1 else 0 end) as Male,sum(case when a.gender='f' then 1 else 0 end) as Female from applicant a join registration b on a.regid=b.regid where b.state= :state  AND b.social= :social ",nativeQuery = true)
	List<Object[]> get_gen_count_state(String state,String social);
	
	
	@Query(value= "select count(a.regid) from applicant a join registration b on a.regid=b.regid where b.social in ('General','SC','ST') AND b.ulb= :ulb",nativeQuery =true)
    List<Object[]> get_total_ulb(String ulb);
    @Query(value = "select sum(case when a.gender='m' then 1 else 0 end) as Male,sum(case when a.gender='f' then 1 else 0 end) as Female from applicant a join registration b on a.regid=b.regid where b.ulb= :ulb  AND b.social= :social ",nativeQuery = true)
	List<Object[]> get_gen_count_ulb(String ulb,String social);
	
	
	
	
    @Query(value = "select sum(case when a.gender='m' then 1 else 0 end) as Male,sum(case when a.gender='f' then 1 else 0 end) as Female from applicant a join registration b on a.regid=b.regid where b.district= :district  AND b.social= :social ",nativeQuery = true)
	    List<Object[]> get_gen_count_dis( String district,String social);
		@Query(value= "select count(a.reg"
				+ "id) from applicant a join registration b on a.regid=b.regid where b.social in ('General','SC','ST') AND b.district= :district",nativeQuery =true)
		List<Object[]> get_total_dis(String district);	
		
		
		
	    @Query(value = "select sum(case when a.gender='m' then 1 else 0 end) as Male,sum(case when a.gender='f' then 1 else 0 end) as Female from applicant a join registration b on a.regid=b.regid where b.ward= :ward  AND b.social= :social ",nativeQuery = true)
	    List<Object[]> get_gen_count_ward(String ward,String social);
		@Query(value= "select count(a.regid) from applicant a join registration b on a.regid=b.regid where b.social in ('General','SC','ST') AND b.ward= :ward",nativeQuery =true)
		List<Object[]> get_total_ward(String ward_code);

	
	
	

}
