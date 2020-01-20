package global.testingsystem.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import global.testingsystem.entity.News;
import global.testingsystem.entity.SlideBanner;

public interface NewsService {
	List<Object> findPageNewsNews();
	List<Object> findAllPinnedNews();
	public List<News> searchAllNewsCMS(String keyword);

	boolean insertNew (News s);

	boolean updateNews(News s);
	
	public News deleteNews(int id);

	public List<News> getAllNewsByOrderByNewsIdDesc();
	
	public List<News> searchNews(String keyword);
	
	public News findNewsById(int id);
	
	public List<News> sortByProperty(int index,int typeSort,String keySearch);

	public boolean pinNews(int newsId);
	
	public void updateNewActiveStatus(int status,int news_id);
	
	 News getNewById(int id);
}
