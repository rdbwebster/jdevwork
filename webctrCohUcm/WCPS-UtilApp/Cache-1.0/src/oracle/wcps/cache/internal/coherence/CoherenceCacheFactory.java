// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 3/5/2014 10:24:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3)
// Source File Name:   CoherenceCacheFactory.java

package oracle.wcps.cache.internal.coherence;

import com.tangosol.net.Cluster;
import com.tangosol.net.DefaultConfigurableCacheFactory;

import com.tangosol.net.NamedCache;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import oracle.wcps.cache.Cache;
import oracle.wcps.cache.CacheFactory;

// Referenced classes of package oracle.wcps.cache.internal.coherence:
//            CoherenceCacheWrapper

public class CoherenceCacheFactory extends CacheFactory
{

    public CoherenceCacheFactory(String factoryName)
    {
        super(factoryName);
        factory = new DefaultConfigurableCacheFactory((new StringBuilder()).append(factoryName).append("-coherence-cache-config.xml").toString(), oracle.wcps.cache.CacheFactory.class.getClassLoader());
        
    }

    public boolean isLocal()
    {
        return false;
    }

    public Cache createCache(String name)
    {
       
        Cache cache = new CoherenceCacheWrapper(factory.ensureCache(name, oracle.wcps.cache.CacheFactory.class.getClassLoader()));
        System.out.println(">>>>>>> BOB's CacheFactory -- Returning Cache named " + ((CoherenceCacheWrapper)cache).getCacheName() );
        
        return cache;
    }

    private final DefaultConfigurableCacheFactory factory;
}
