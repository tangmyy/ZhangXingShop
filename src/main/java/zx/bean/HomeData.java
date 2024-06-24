package zx.bean;

import java.util.ArrayList;

public class HomeData {
	// ������ҳ���ݵĹؼ���Ϣ �����ṩ��Щ��Ϣ
	private String keyword;					// keyword != null���򲻿���sort
	private int sort;							// keyword == null : sort==0 �������ѯ��sort!=0�����ѯ
	private int curPage; 					// �ӷ������������������и��ݵ�ǰҳ����Ϣȷ��ȡ�ļ�������
	private int numPerPage = 8;			// һҳ��ʾ����Ʒ��������¼����

	private int totalElement;				// �����������������ݣ�ȡ����keyword sort numPerPage����dao��ʵ�ָ�ֵ��
	private int totalPages; 				// ������������ҳ����ȡ����keyword sort��
	

	private int navigationPages = 5;						// ҳ�뵼������Ϣ
	private int firstPageForNavigation;					// ҳ�뵼������ĵ�һ��ҳ����ֵ
	private int lastPageForNavigation;					// ҳ�뵼����������һ��ҳ����ֵ ȡ���ڿ�ͷ��������
	private ArrayList<Commodity> commodityList;		// �������������ݣ�ȡ���� ��ͷ����������
																	// ���벹�빤�ߣ�ctrl+/


	public HomeData() {
		super();
	}

	public HomeData(String keyword, int sort, int curPage) {		// String sort �� int sort
		super();
		this.keyword = keyword;
		this.sort = sort;
		this.curPage = curPage;
	}


	public String getKeyword() {							// �ؼ���		Keyword
		return keyword;
	}
	public int getSort() {										// ����			Sort
		return sort;
	}
	public int getCurPage() {									// ��ǰҳ��		CurPage
		return curPage;
	}
	public int getTotalElement() {							// Ԫ������		TotalElement
		return totalElement;
	}
	public int getNumPerPage() {								// ÿҳԪ����	NumPerPage
		return numPerPage;
				}
	public int getTotalPages() {								// ��ҳ��		TotalPages
		return totalPages;
	}
	public int getNavigationPages() {						// ������ҳ��	NavigationPages
		return navigationPages;
	}
	public int getFirstPageForNavigation() {				// ��������ҳ	FirstPageForNavigation
		return firstPageForNavigation;
	}
	public int getLastPageForNavigation() {				// ������ĩҳ	LastPageForNavigation
		return lastPageForNavigation;
	}
	public ArrayList<Commodity> getCommodityList() {	// ��Ʒ�б�		CommodityList
		return commodityList;
	}


	public void setKeyword(String keyword) {																	// �ؼ���		Keyword
		this.keyword = keyword;
	}
	public void setSort(int sort) {																				// ����			Sort
		this.sort = sort;
	}
	public void setCurPage(int curPage) {																		// ��ǰҳ��		CurPage
		this.curPage = curPage;
	}
	public void setTotalElement(int totalElement) {															// Ԫ������		TotalElement
		this.totalElement = totalElement;
		setTotalPages();
		setFirstPageForNavigation();
		setLastPageForNavigation();
	}
	public void setNumPerPage(int numPerPage) {																// ÿҳԪ����	NumPerPage
		this.numPerPage = numPerPage;
	}
	public void setTotalPages() {																					// ��ҳ��		TotalPages
		this.totalPages = (totalElement-1)/numPerPage +1;
	}
	public void setNavigationPages(int navigationPages) {													// ������ҳ��	NavigationPages
		this.navigationPages = navigationPages;
	}

	public void setFirstPageForNavigation() {																	// ��������ҳ	FirstPageForNavigation
		if (totalElement == 0)
			this.firstPageForNavigation = 0;
		else if (curPage <= navigationPages/2+1)    // 1 2 3 4 5    23456
			firstPageForNavigation = 1;
		else 
			firstPageForNavigation = curPage-navigationPages/2;
	}

	public void setLastPageForNavigation() {																	// ������ĩҳ	LastPageForNavigation
		this.lastPageForNavigation = Math.min(firstPageForNavigation +navigationPages-1,totalPages);
	}

	public void setCommodityList(ArrayList<Commodity> commodityList) {								// ��Ʒ�б�		CommodityList
		this.commodityList = commodityList;
	}


	@Override //���ڷ��ض���Ĺ�ϣ��ֵ���������ڽ�����洢�ڹ�ϣ���У�����߲���Ч�ʡ�
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + curPage;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + sort;
		return result;
	}

	@Override //���ڱȽ����������Ƿ���ȡ�Ĭ������£����Ƚϵ��Ƕ�����ڴ��ַ�������Ը�����Ҫ��д�ԱȽ϶�������ݡ�
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HomeData other = (HomeData) obj;
		if (curPage != other.curPage)
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (sort != other.sort)
			return false;
		return true;
	}

	@Override //�ڷ��ض�����ַ�����ʾ��ʽ��ͨ����д����������Ա��Ը�������ķ�ʽ��ʾ��������ݡ�
	public String toString() {
		return "HomeData [keyword=" + keyword + ", sort=" + sort + ", curPage=" + curPage + ", totalElement="
				+ totalElement + ", numPerPage=" + numPerPage + ", totalPages=" + totalPages + ", navigationPages="
				+ navigationPages + ", firstPageForNavigation=" + firstPageForNavigation + ", lastPageForNavigation="
				+ lastPageForNavigation + ", commodityList=" + commodityList + "]";
	}

}
