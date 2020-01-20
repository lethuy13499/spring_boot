/**
 * 
 */
package global.testingsystem.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.testingsystem.entity.Role;
import global.testingsystem.entity.SlideBanner;
import global.testingsystem.repository.SlideBannerRepository;
import global.testingsystem.service.SlideBannerService;

/**
 * Create by: HaNuoc Create date: Nov 13, 2018 Modifier: HaNuoc Modified date:
 * Nov 13, 2018 Description: .... Version 1.0
 */
@Service
public class SliderBannerServiceImpl implements SlideBannerService {

    private static Logger log = Logger.getLogger(SliderBannerServiceImpl.class);
    @Autowired
    private SlideBannerRepository slideBarRepository;

    @Override
    public List<SlideBanner> getAllListSlidebar() {
        return slideBarRepository.findAllByOrderByIdDesc();
    }


    @Override
    public boolean insertSlidebar(SlideBanner s) {
        boolean isSuccess = false;
        SlideBanner insertedSlidebar = slideBarRepository.save(s);
        if (insertedSlidebar != null) {
            isSuccess = true;
        } else {
            isSuccess = false;
            log.error("insert fail ");
        }
        return isSuccess;
    }

    @Override
    public boolean updateSlidebar(SlideBanner s) {
        boolean isSuccess = false;
        SlideBanner updateSlidebar = slideBarRepository.save(s);
        if (updateSlidebar != null) {
            isSuccess = true;
        } else {
            isSuccess = false;
            log.error("insert fall ");
        }
        return isSuccess;
    }

    @Override
    public boolean deleteSlidebar(int id) {
        boolean isSuccess = false;
        SlideBanner s = slideBarRepository.getOne(id);
        try {
            slideBarRepository.delete(s);
            isSuccess = true;
        } catch (Exception e) {
            log.error("delete failed" + e.getMessage());
            isSuccess = false;
        }
        return isSuccess;
    }


    @Override
    public List<SlideBanner> filterSlidebarByTitle(String title) {
        return slideBarRepository.findBytitleContaining(title);
    }

    @Override
    public List<SlideBanner> getListSlideBarActive() {
        return slideBarRepository.findByshowTrue();
    }

    @Override
    public SlideBanner findSlideBarById(int id) {
        return slideBarRepository.getOne(id);
    }
    @Override
	public List<SlideBanner> search(String title) {
		return slideBarRepository.findBytitleContaining(title);

	}

}
