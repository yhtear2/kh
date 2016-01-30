package dao;

import java.util.ArrayList;

import dto.BoardDataBean;

public interface BoardDao {
	public int getCount();
	public ArrayList<BoardDataBean> getArticles( int start, int end);
	public int insertArticle( BoardDataBean dto );
	public BoardDataBean getArticle(int num);
	public void addCount( int num );
	public int deletArticle( int num );
	public int checkArticle( int num, String passwd );
	public int updateArticle( BoardDataBean dto);
}
