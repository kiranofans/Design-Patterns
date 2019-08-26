package project.android_projects.com.trytomakeperfectsingleton;

public class EagerInitSingletonExample {

    private static volatile EagerInitSingletonExample singletonInstance
            = new EagerInitSingletonExample();

    private EagerInitSingletonExample(){} //private construct so only this class can access


    public static EagerInitSingletonExample getInstance(){
            return singletonInstance;//different from lazy initialized sigleton
    }


}
