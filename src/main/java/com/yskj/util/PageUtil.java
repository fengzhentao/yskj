package com.yskj.util;

import com.yskj.Entity.News;

/**
 * ��ҳ������
 * @author Administrator
 *
 */
public class PageUtil {

	/**
	 * ���ɷ�ҳ����
	 * @param targetUrl Ŀ���ַ
	 * @param totalNum �ܼ�¼��
	 * @param currentPage ��ǰҳ
	 * @param pageSize ÿҳ��С
	 * @return
	 */
//	public static String genPagination(String targetUrl,long totalNum,int currentPage,int pageSize){
//		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
//		if(totalPage==0){
//			return "δ��ѯ������";
//		}else{
//			StringBuffer pageCode=new StringBuffer();
//			pageCode.append("<li><a href='"+targetUrl+"?page=1'>��ҳ</a></li>");
//			if(currentPage>1){
//				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage-1)+"'>��һҳ</a></li>");
//			}else{
//				pageCode.append("<li class='disabled'><a href='#'>��һҳ</a></li>");
//			}
//			for(int i=currentPage-2;i<=currentPage+2;i++){
//				if(i<1||i>totalPage){
//					continue;
//				}
//				if(i==currentPage){
//					pageCode.append("<li class='current'><a href='"+targetUrl+"?page="+i+"'>"+i+"</a></li>");
//				}else{
//					pageCode.append("<li><a href='"+targetUrl+"?page="+i+"'>"+i+"</a></li>");
//				}
//			}
//			if(currentPage<totalPage){
//				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage+1)+"'>��һҳ</a></li>");
//			}else{
//				pageCode.append("<li class='disabled'><a href='#'>��һҳ</a></li>");
//			}
//			pageCode.append("<li><a href='"+targetUrl+"?page="+totalPage+"'>βҳ</a></li>");
//			return pageCode.toString();
//		}
//	}
	public static String genPagination(String targetUrl,long totalNum,int currentPage,int pageSize){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		if(totalPage==0){
			return "δ��ѯ������";
		}else{
			StringBuffer pageCode=new StringBuffer();
			pageCode.append("<a href='"+targetUrl+"?page=1'>��ҳ</a>");
			if(currentPage>1){
				pageCode.append("<a style=\"margin-left:5px;\" href='"+targetUrl+"?page="+(currentPage-1)+"'>��һҳ</a>");
			}else{
				pageCode.append("<a style=\"margin-left:5px;\" href='#'>��һҳ</a>");
			}
			for(int i=currentPage-2;i<=currentPage+2;i++){
				if(i<1||i>totalPage){
					continue;
				}
				if(i==currentPage){
					pageCode.append("<a class='current' style=\"margin-left:5px;\" href='"+targetUrl+"?page="+i+"'>"+i+"</a>");
				}else{
					pageCode.append("<a style=\"margin-left:5px;\" href='"+targetUrl+"?page="+i+"'>"+i+"</a>");
				}
			}
			if(currentPage<totalPage){
				pageCode.append("<a style=\"margin-left:5px;\" href='"+targetUrl+"?page="+(currentPage+1)+"'>��һҳ</a>");
			}else{
				pageCode.append("<a style=\"margin-left:5px;\" href='#'>��һҳ</a>");
			}
			pageCode.append("<a style=\"margin-left:5px;\" href='"+targetUrl+"?page="+totalPage+"'>βҳ</a>");
			return pageCode.toString();
		}
	}

	/**
	 * ��ȡ��һƪ���ͺ���һƪ���ʹ���
	 * @return
	 */
	public static String genUpAndDownPageCode(News lastNews, News nextNews, String projectContext) {
		StringBuffer pageCode=new StringBuffer();
		if(lastNews==null || lastNews.getNewsId()==null){
			pageCode.append("<p>��һƪ��û����</p>");
		}else{
			pageCode.append("<p>��һƪ��<a href='"+projectContext+"/news/"+lastNews.getNewsId()+"/articles.html'>"+lastNews.getNewsName()+"</a></p>");
		}
		if(nextNews==null || nextNews.getNewsId()==null){
			pageCode.append("<p>��һƪ��û����</p>");
		}else{
			pageCode.append("<p>��һƪ��<a href='"+projectContext+"/news/"+nextNews.getNewsId()+"/articles.html'>"+nextNews.getNewsName()+"</a></p>");
		}
		return pageCode.toString();
	}
	

	
	
}
