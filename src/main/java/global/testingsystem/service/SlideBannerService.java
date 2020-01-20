package global.testingsystem.service;

import java.util.List;

import global.testingsystem.entity.Role;
import global.testingsystem.entity.SlideBanner;


public interface SlideBannerService {
    
   
    List<SlideBanner> getAllListSlidebar();

    boolean insertSlidebar(SlideBanner s);
 
    boolean updateSlidebar(SlideBanner s);
   
    boolean deleteSlidebar(int id);
  
    List<SlideBanner> filterSlidebarByTitle (String title);
  
    List<SlideBanner> getListSlideBarActive();
  
    SlideBanner findSlideBarById(int id);
    
    List<SlideBanner> search(String key);
}
