package org.sonatype.mavenbook.utils.serlvet;

import org.sonatype.mavenbook.utils.Page;
/*
java多线程模式:ThreadLocal,使每个线程保存一份属于自己的数据。
定义一个静态的ThreadLocal实例。
然后将一个共用的ThreadLocal静态实例作为key，
将不同对象的引用保存到不同线程的ThreadLocalMap中，
然后在线程执行的各处通过这个静态ThreadLocal实例的get()方法取得自己线程保存的那个对象。
是每一个Thread持有一个自己的map，并不是一个ThreadLocal持有一个map。

使用ThreadLocal类封装Page对象，让Service层等无需传Page对象，减小了侵入性。
拦截器也省去了查找Page对象的动作，性能也同时改善。
*/
public class PageContext {
	
	private static ThreadLocal<Page> threadPage = new ThreadLocal<Page>();  
    
    public static Page getPage () {  
        Page p = threadPage.get();  
          
        return p;  
    }  
      
    public static void setPage (Page page) {  
        threadPage.set(page);  
    }  
    
}
