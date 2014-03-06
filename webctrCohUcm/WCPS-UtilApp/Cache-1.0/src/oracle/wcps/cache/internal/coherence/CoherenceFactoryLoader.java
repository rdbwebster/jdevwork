// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 3/5/2014 10:28:12 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   CoherenceFactoryLoader.java

package oracle.wcps.cache.internal.coherence;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import oracle.wcps.cache.Cache;
import oracle.wcps.cache.CacheFactory;
import oracle.wcps.cache.log.impl.CacheLogger;
import oracle.wcps.cache.CacheFactory;

public class CoherenceFactoryLoader
{

    public static CacheFactory getCoherenceCacheFactory(String factoryName)
    {
        System.out.println(">>>>>>> BOB's CacheFactoryLoader");
        if(Boolean.getBoolean("oracle.wcps.cache.forceLocalCaches"))
            return null;
        ClassLoader cl =  oracle.wcps.cache.CacheFactory.class.getClassLoader();
        try
        {
            Class.forName("com.tangosol.net.DefaultConfigurableCacheFactory", false, cl);
        }
        catch(Throwable e)
        {
            System.out.println(">>>>>>> BOB's CacheFactoryLoader -- Coherence Not Available");
            logger.log_COHERENCE_NOT_AVAILABLE("com.tangosol.net.DefaultConfigurableCacheFactory");
            return null;
        }
        if(null == cl.getResource((new StringBuilder()).append(factoryName).append("-coherence-cache-config.xml").toString()))
        {
            System.out.println(">>>>>>> BOB's CacheFactoryLoader -- Coherence Config Not Found");
            logger.log_COHERENCE_CONFIG_FILE_NOT_AVAILABLE((new StringBuilder()).append(factoryName).append("-coherence-cache-config.xml").toString());
            return null;
        }
        try
        {
            Class c = Class.forName("oracle.wcps.cache.internal.coherence.CoherenceCacheFactory", true, cl);
            Class[] ctorArgs1 = new Class[1];
            ctorArgs1[0] = String.class;
            System.out.println(">>>>>>> BOB's CacheFactoryLoader -- Returning factory named " + factoryName);
            CacheFactory factory = (CacheFactory)c.getConstructor(ctorArgs1).newInstance(new Object[] {
                factoryName
            });
            
            
            return factory;
           
        }
        catch(InvocationTargetException e)
        {
            System.out.println(">>>>>>> BOB's CacheFactory -- InvocationTargetException " + factoryName);
            logger.log_ERROR_CREATING_COHERENCE_FACTORY((new StringBuilder()).append(factoryName).append("-coherence-cache-config.xml").toString(), e.getTargetException());
            return null;
        }
        catch(Exception e)
        {
            System.out.println(">>>>>>> BOB's CacheFactory -- Exception " + factoryName);
            logger.log_ERROR_CREATING_COHERENCE_FACTORY((new StringBuilder()).append(factoryName).append("-coherence-cache-config.xml").toString(), e);
        }
        return null;
    }

    private CoherenceFactoryLoader()
    {
    }

    public static final String COHERENCE_CONFIG_FILE_SUFFIX = "-coherence-cache-config.xml";
    private static final String COHERENCE_CLASS = "com.tangosol.net.DefaultConfigurableCacheFactory";
    private static final String CACHE_FACTORY_CLASS = "oracle.wcps.cache.internal.coherence.CoherenceCacheFactory";
    private static final CacheLogger logger = oracle.wcps.cache.log.impl.CacheLogger.Factory.getInstance(oracle.wcps.cache.internal.coherence.CoherenceFactoryLoader.class);

}
