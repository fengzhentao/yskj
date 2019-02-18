package com.yskj.util;

import com.yskj.Entity.News;

/**
 * 分页工具类
 * @author Administrator
 *
 */
public class PageUtil {

	/**
	 * 生成分页代码
	 * @param targetUrl 目标地址
	 * @param totalNum 总记录数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 * @return
	 */
//	public static String genPagination(String targetUrl,long totalNum,int currentPage,int pageSize){
//		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
//		if(totalPage==0){
//			return "未查询到数据";
//		}else{
//			StringBuffer pageCode=new StringBuffer();
//			pageCode.append("<li><a href='"+targetUrl+"?page=1'>首页</a></li>");
//			if(currentPage>1){
//				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage-1)+"'>上一页</a></li>");
//			}else{
//				pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
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
//				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage+1)+"'>下一页</a></li>");
//			}else{
//				pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
//			}
//			pageCode.append("<li><a href='"+targetUrl+"?page="+totalPage+"'>尾页</a></li>");
//			return pageCode.toString();
//		}
//	}
	public static String genPagination(String targetUrl,long totalNum,int currentPage,int pageSize){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		if(totalPage==0){
			return "未查询到数据";
		}else{
			StringBuffer pageCode=new StringBuffer();
			pageCode.append("<a href='"+targetUrl+"?page=1'>首页</a>");
			if(currentPage>1){
				pageCode.append("<a style=\"margin-left:5px;\" href='"+targetUrl+"?page="+(currentPage-1)+"'>上一页</a>");
			}else{
				pageCode.append("<a style=\"margin-left:5px;\" href='#'>上一页</a>");
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
				pageCode.append("<a style=\"margin-left:5px;\" href='"+targetUrl+"?page="+(currentPage+1)+"'>下一页</a>");
			}else{
				pageCode.append("<a style=\"margin-left:5px;\" href='#'>下一页</a>");
			}
			pageCode.append("<a style=\"margin-left:5px;\" href='"+targetUrl+"?page="+totalPage+"'>尾页</a>");
			return pageCode.toString();
		}
	}

	/**
	 * 获取下一篇博客和下一篇博客代码
	 * @return
	 */
	public static String genUpAndDownPageCode(News lastNews, News nextNews, String projectContext) {
		StringBuffer pageCode=new StringBuffer();
		if(lastNews==null || lastNews.getNewsId()==null){
			pageCode.append("<p>上一篇：没有了</p>");
		}else{
			pageCode.append("<p>上一篇：<a href='"+projectContext+"/news/"+lastNews.getNewsId()+"/articles.html'>"+lastNews.getNewsName()+"</a></p>");
		}
		if(nextNews==null || nextNews.getNewsId()==null){
			pageCode.append("<p>下一篇：没有了</p>");
		}else{
			pageCode.append("<p>下一篇：<a href='"+projectContext+"/news/"+nextNews.getNewsId()+"/articles.html'>"+nextNews.getNewsName()+"</a></p>");
		}
		return pageCode.toString();
	}
	

	
	
}
