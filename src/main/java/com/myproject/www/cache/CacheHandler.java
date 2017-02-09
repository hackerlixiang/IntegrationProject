package com.myproject.www.cache;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import com.myproject.www.exception.EhcacheException;
import com.myproject.www.utils.StringUtils;

/**
 * 缓存处理
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
@Component("CacheHandler")
public class CacheHandler{
	
	@Resource(name = "ehCacheManager")
    private CacheManager cacheManager;
	
	@Resource(name = "messageSource")
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;
	
	/**
     * 获取缓存存储路径
     * 
     * @return 缓存存储路径
     */
    public String getDiskStorePath() {
        return cacheManager.getConfiguration().getDiskStoreConfiguration().getPath();
    }

    /**
     * 获取缓存数
     * 
     * @return 缓存数
     */
    public int getCacheSize() {
        int cacheSize = 0;
        String[] cacheNames = cacheManager.getCacheNames();
        if (cacheNames != null) {
            for (String cacheName : cacheNames) {
                Ehcache cache = cacheManager.getEhcache(cacheName);
                if (cache != null) {
                    cacheSize += cache.getSize();
                }
            }
        }
        return cacheSize;
    }
    
    /**
     * 添加缓存
     * @param cacheName 缓存名称
     */
    public void addCache(String cacheName){
    	validateCacheName(cacheName);
	    Cache cache = new Cache(cacheName, 100, true, false, 5, 2);
	    cacheManager.addCache(cache);
    }
    
    /**
     * 删除缓存
     * @param cacheName 缓存名称
     */
    public void removeCache(String cacheName){
    	validateCacheName(cacheName);
    	cacheManager.removeCache(cacheName);
    }
    
    /**
     * 删除所有缓存
     */
    public void removeAllCache(){
    	cacheManager.removeAllCaches();
    	cacheManager.removalAll();
    }
    
    /**
     * 获取缓存
     * @param cacheName 需要获取的缓存名称
     * @return 缓存
     */
    public Cache getCache(String cacheName){
		validateCacheName(cacheName);
		return cacheManager.getCache(cacheName);
    }
    
    /**
     * 向缓存中添加元素
     * @param cacheName 缓存名
     * @param eleName 元素名
     * @param cacheCont 元素内容
     */
    public void addElementForCache(String cacheName,String eleName,Object eleCont){
    	validateCacheName(cacheName,eleName);
    	
    	Cache cache = getCache(cacheName);
    	Element element = new Element(eleName,eleCont);
    	cache.put(element);
    }
    
    /**
     * 删除缓存中的元素
     * @param cacheName 缓存名称
     * @param eleName 元素名称
     * @return 删除是否成功
     */
    public Boolean removeElement(String cacheName,String eleName){
    	validateCacheName(cacheName,eleName);
    	Cache cache = getCache(cacheName);
    	return cache.remove(eleName);
    }
    
    /**
     * 删除缓存中所有元素
     * @param cacheName 缓存名称
     */
    public void removeAllElement(String cacheName){
    	validateCacheName(cacheName);
    	Cache cache = getCache(cacheName);
    	cache.removeAll();
    }
    
    /**
     * 获取缓存中的元素
     * @param cacheName 缓存名称
     * @param eleName 元素名称
     * @return 缓存中的元素
     */
    public Element getElement(String cacheName,String eleName){
    	validateCacheName(cacheName,eleName);
    	Cache cache = getCache(cacheName);
    	return cache.get(eleName);
    }
    
    /**
     * 根据缓存名刷新缓存
     * @param cacheName 缓存名称
     */
    public void flushCacheByName(String cacheName){
    	validateCacheName(cacheName);
    	Cache cache = getCache(cacheName);
    	cache.flush();
    }
    
    /**
     * 刷新所有缓存
     */
    public void flushAllCache(){
    	cacheManager.clearAll();
    }
    
//    @CacheEvict(value = { "setting", "authorization", "logConfig", "area", "bank", "bankBranch", "dict", "dictWord",
//            "template", "adPosition", "ad", "friendLink", "articleCategory", "article" }, allEntries = true)
//    public void clear() {
//        reloadableResourceBundleMessageSource.clearCache();
//        try {
//            Configuration configuration = freeMarkerConfigurer.getConfiguration();
//            configuration.setSharedVariable("setting", SettingUtils.get());
//        } catch (TemplateModelException e) {
//            e.printStackTrace();
//        }
//        freeMarkerConfigurer.getConfiguration().clearTemplateCache();
//    }
    
    /**
     * 验证缓存名称是否为空
     * @param cacheName 缓存名称
     */
    private void validateCacheName(String...names){
    	if(names.length<1){
    		throw new EhcacheException();
    	}else{
    		for (String name : names) {
				if(StringUtils.isBlank(name)){
					throw new EhcacheException();
				}
			}
    	}
    }
    
}
