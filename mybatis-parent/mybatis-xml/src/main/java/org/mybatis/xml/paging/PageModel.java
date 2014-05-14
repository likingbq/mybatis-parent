package org.mybatis.xml.paging;

import java.util.List;

public class PageModel<T> {
	
	//用户指定/配置
	private int currentPage;		//当前页数
	private int pageSize;			//每页显示的记录数
	
	//从数据库读取出来的
	private int recordCount;		//总记录数
	private List<T> recordList;		//本页列表数据
	
	//计算得出
	private int pageCount;			//总页数
	private int startPageIndex;		//页码列表开始索引
	private int endPageIndex;		//页码列表结束索引
	
	
	
	public PageModel(){
		
	}
	
	public PageModel(int currentPage, int pageSize, int recordCount,
			List<T> recordList) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		
		
		pageCount = (recordCount + pageSize -1)/pageSize;		//总页数
		
		//a 总页数不大于10页的时候
		if(pageCount <= 10){
			startPageIndex = 1;			//页码列表开始索引
			endPageIndex = pageCount;	//页码列表结束索引
		}else{
			//b 总页数大于10页的时候
			startPageIndex = currentPage - 4;			//页码列表开始索引
			endPageIndex = currentPage + 5;				//页码列表结束索引
			
			//前面的页码不足4个
			
			if(startPageIndex < 1){
				startPageIndex  = 1;
				endPageIndex = 10;
			}else if(endPageIndex > pageCount){			//后面的页码不足5个
				endPageIndex = pageCount;
				startPageIndex = endPageIndex - 10 + 1;
			}
		}
	}
	
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public List<T> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<T> recordList) {
		this.recordList = recordList;
	}
	public int getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartPageIndex() {
		return startPageIndex;
	}
	public void setStartPageIndex(int startPageIndex) {
		this.startPageIndex = startPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
}
