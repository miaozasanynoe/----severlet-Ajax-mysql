package com.test;

import java.util.ArrayList;
import java.util.List;

import com.dto.article_Dto;
import com.model.article_model;

public  class article_test {

	public static void main(String[] args) {
		/*���Բ�ѯ����
		article_model article_model=new article_model();
		article_Dto dto=new article_Dto();
		dto=article_model.QueryByUserId("201701020124");
		System.out.println(dto.getArctime());
		*/
		/*���Բ��빦��*/
		article_model article_model=new article_model();
		article_Dto dto=new article_Dto();
		dto.setUserid("201701020135");
		dto.setArcid("2");
		dto.setArctime("2019/7/4");
		dto.setArcatatus("����");
		article_model.add_article(dto);
		/*����ȫ��ѯ����*/
		List<article_Dto> list=article_model.find_article_Dto();
		 for(article_Dto arr:list)
		 {
			 System.out.println(arr.getUserid()+" "+arr.getArcid()+" ");
		 }
		
	}

}
