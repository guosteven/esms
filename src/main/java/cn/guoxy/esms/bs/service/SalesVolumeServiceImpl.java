package cn.guoxy.esms.bs.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.bs.dao.SalesVolumeDao;

/**
 * ����ҵ���ʵ����
 * 
 * @author gxy
 *
 */
@Service("salesVolumeService")
public class SalesVolumeServiceImpl implements SalesVolumeService {
	@Resource(name = "salesVolumeDao")
	private SalesVolumeDao salesVolumeDao;

	public Map<String, Integer> getSalesVolume() {
		Map<String, Integer> map = salesVolumeDao.getSalesVolume();
		return map;
	}

}
