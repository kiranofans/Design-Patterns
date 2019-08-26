package project.android_projects.com.trytomakeperfectsingleton;

/**
 * Singleton classes should be thread-safe, which means
 * when comes to multi threads, the hashcode should be
 * always the same for multiple class instances.
 * Singleton classes also should be reflection proof, so
 * if the instances have different hash codes the RuntimeException will throw
 */
public class LazyInitSingletonExample {
    /**
     * Use the volatile keyword for thread-safe
     * Volatile keyword guarantees that value of the volatile variable will
     * always be read from main memory and "happens-before" any read of instance variable
     */
    private static volatile LazyInitSingletonExample instance;

    private LazyInitSingletonExample() {
        /** Throw RuntimeException in the private constructor to
         * make the sigleton class reflection proof in order to create
         * more than 1 instance with singleton*/
        if (instance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of" +
                            " this LazyInitSingletonExample class");
        }
    }

    /** Use Synchronized key word for getInstance() to make thread-safe.
     * JVM will put a lock on the methods or functions with synchronized keywords,
     * so the second thread will have to wait until the getInstance() method is completed
     * for the first thread*/
    /*public synchronized static LazyInitSingletonExample getInstance(){
        //JVM will put a lock on that at the same second thread, it will
        //have to wait until the getInstance() method is completed for the first thread.
        if(instance == null){
            //if there is no instance available... create new one
            return instance = new LazyInitSingletonExample();
        }
        return instance;

        //Drawback #1: Performance will be slow
        //Drawback #2: The synchronized keyword won't function once the instance variable is initialized
    }*/

    /**
     * Double-check locking method for getInstance() to make thread-safe
     */
    public static LazyInitSingletonExample getInstance() {
        if (instance == null) {
            //if there is no instance available... create new one
            synchronized (LazyInitSingletonExample.class) {
                //The synchronized block will be executed only when the instance is null

                //Check for the second time
                if (instance == null) instance = new LazyInitSingletonExample();
            }
            //return instance = new LazyInitSingletonExample();
        }
        return instance;
    }
}
