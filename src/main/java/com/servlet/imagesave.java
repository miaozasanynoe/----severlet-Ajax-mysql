package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;


import util.*;
/**
 * Servlet implementation class imagesave
 */
@WebServlet("/images") 
public class imagesave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imagesave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String savePath = this.getServletContext().getRealPath("/upload");	
		savePath = savePath.replace("\\", "\\\\");
		File file = new File(savePath);
		//�ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
		if(!file.exists()){
			//Ŀ¼��������Ҫ����Ŀ¼
			file.mkdir();
		}
		//�ϴ���ʾ��Ϣ
		String message="";	
	
		try{
			//ʹ��apache�ļ��ϴ���������ļ��ϴ�����
			//1������һ��DiskFileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//2������һ���ļ��ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			//����ϴ��ļ�������������
			upload.setHeaderEncoding("UTF-8");
			//4��ʹ��ServletFileUpload�������ϴ����ݣ�����������ص���һ��List<FileItem>����
			//	ÿһ��FileItem��Ӧһ��Form����������
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list) {
				if (item.isFormField()) {
					System.out.println("formField");
				}else {
				String filename = item.getName();
				System.out.println(filename);
				if(filename == null || filename.trim().equals("")){
					continue;
				}
				filename = filename.substring(filename.lastIndexOf(".")+1);
				//���ļ�����ȡһ������UUID
				filename = UUID.randomUUID().toString()+"."+filename;
				//��ȡitem�е��ϴ��ļ���������
				InputStream in = item.getInputStream();
				tecent_upload tenup=new tecent_upload();
				tenup.conn();
			//	tenup.upload_images("test-1258897694", "122", in);
			//	tenup.upload_images("333", inputstream_File.asFile(in));
				//����һ���ļ������
				System.out.print(savePath);
				FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
				//����һ��������
				byte[] buffer = new byte[1024];
				//�ж��������е������Ƿ��Ѿ�����ı�ʶ
				int len = 0;
				//ѭ�������������뵽���������У�
				while((len = in.read(buffer)) > 0) {
					//ʹ��FileOutputStream��������������������д�뵽ָ����Ŀ¼(savePath + "\\" +filename)
					out.write(buffer,0,len);
				}
				//���������֮������Ҫ�ģ�����Ϊ�˷���JSON������׼����
				String [] str = {request.getContextPath() + "/upload/" + filename};				
				//Result result = ResultUtil.success(str);
				System.out.print(str);
				Result result = ResultUtil.success(str);
		        response.getWriter().write(JSON.toJSONString(result));//����url��ַ
		        //�ر���
				in.close();
				out.close();
				//ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
				item.delete();

		 
		        
				}

				
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubs
		
		doGet(request, response);
	}

}
