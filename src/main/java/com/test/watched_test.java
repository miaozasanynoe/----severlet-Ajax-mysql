package com.test;

import java.util.List;

import com.dto.user_Dto;
import com.dto.watched_Dto;
import com.model.user_model;
import com.model.watched_model;

public class watched_test {

	public static void main(String[] args) {
		/*���Բ�ѯ����
		watched_model watched=new watched_model();
		watched_Dto dto=new watched_Dto();
		dto=watched.QueryByWauserId("201701020124");
		System.out.println(dto.getUnwa_time());*/
		/*���Բ��빦��*/
		watched_model watched=new watched_model();
		watched_Dto dto=new watched_Dto();
		dto.setWa_userid("201701020135");
		dto.setWing_userid("201701020145");
		dto.setWa_time("2019/7/7");
		dto.setUnwa_time("2019/7/9");
		watched.add_watched(dto);
		/*����ȫ��ѯ����*/
		
		List<watched_Dto> list=watched.find_watched_Dto();
		 for(watched_Dto arr:list)
		 {
			 System.out.println(arr.getWa_time()+" "+arr.getWing_userid()+" "+arr.getUnwa_time()+" ");
		 }
	}

}
