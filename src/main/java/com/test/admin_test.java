package com.test;

import java.util.List;

import com.dto.admin_Dto;
import com.dto.article_Dto;
import com.model.admin_model;

public class admin_test {
	public static void main(String[] args) {
		/*���Բ�ѯ����
		admin_model admin=new admin_model();
		admin_Dto dto=new admin_Dto();
		dto=admin.QueryById("201702");
		System.out.println(dto.getPassw());*/
		/*���Բ��빦��*/
		admin_model admin=new admin_model();
		admin_Dto dto=new admin_Dto();
		dto.setId("201703");
		dto.setPassw("111");
		admin.add_admin(dto);
		/*����ȫ��ѯ����*/
		List<admin_Dto> list=admin.find_admin_Dto();
		 for(admin_Dto arr:list)
		 {
			 System.out.println(arr.getId()+" "+arr.getPassw()+" ");
		 }
	}
}
