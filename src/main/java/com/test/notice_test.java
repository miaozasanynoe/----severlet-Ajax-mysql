package com.test;

import java.util.List;

import com.dto.admin_Dto;
import com.dto.lock_user_Dto;
import com.dto.notice_Dto;
import com.model.admin_model;
import com.model.lock_user_model;
import com.model.notice_model;

public class notice_test {

	public static void main(String[] args) {
		/*���Բ�ѯ����
		notice_model notice=new notice_model();
		notice_Dto dto=new notice_Dto();
		dto=notice.QueryByAdminId("201701");
		System.out.println(dto.getNotice_text());*/
		/*���Բ��빦��*/
		notice_model notice=new notice_model();
		notice_Dto dto=new notice_Dto();
		dto.setNotice_text("����");
		dto.setTime("2019/7/6");
		dto.setAdmin_id("201702");
		notice.add_notice(dto);
		/*����ȫ��ѯ����*/
		
		List<notice_Dto> list=notice.find_notice_Dto();
		 for(notice_Dto arr:list)
		 {
			 System.out.println(arr.getNotice_text()+" "+arr.getTime()+" "+arr.getAdmin_id()+" ");
		 }
	}

}
