package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����servlet�ķ��ʵ�ַ
//1.��web.xml����
//2 ��ע��  @WebServlet("/userServlet")  -->  web.xml  
	/**��ע��  @WebServlet("/userServlet")�൱����web.xml�е���������
		 * <servlet>
			<servlet-name>UserServlet</servlet-name>
			<servlet-class>com.servlet.UserServlet</servlet-class>
		</servlet>
		<servlet-mapping>
			<servlet-name>UserServlet</servlet-name>
			<url-pattern>/userServlet</url-pattern>
		</servlet-mapping>
	 * @author Administrator
	 *
	 */
@WebServlet("/userServlet") 
public class UserServlet extends HttpServlet {
	
	//��дdoGet,doPost����
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		System.out.println("�յ�doGet����");
		PrintWriter out  =  resp.getWriter();//out
		out.print("doGet");///���ͻ�����������doGet�ַ���
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int a = 10/0;
		System.out.println("�յ�doPost����");
		PrintWriter out  =  resp.getWriter();//out
		out.print("doPost");///���ͻ�����������doGet�ַ���
	}

}
