package Utils.RxJava;

import io.reactivex.Scheduler;

public interface RxJavaSchedulerProvider {
    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
