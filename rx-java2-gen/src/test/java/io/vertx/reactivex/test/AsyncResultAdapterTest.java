package io.vertx.reactivex.test;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.codegen.rxjava2.MethodWithCompletable;
import io.vertx.reactivex.codegen.rxjava2.MethodWithMaybeString;
import io.vertx.reactivex.codegen.rxjava2.MethodWithSingleString;
import io.vertx.test.core.VertxTestBase;
import org.junit.Test;

public class AsyncResultAdapterTest extends VertxTestBase {

  @Test
  public void testSingleReportingSubscribeUncheckedException() {
    RuntimeException cause = new RuntimeException();
    MethodWithSingleString meth = new MethodWithSingleString(handler -> {
      throw cause;
    });
    Single<String> single = meth.rxDoSomethingWithResult();
    single.subscribe(result -> fail(), err -> testComplete());
    await();
  }

  @Test
  public void testMaybeReportingSubscribeUncheckedException() {
    RuntimeException cause = new RuntimeException();
    MethodWithMaybeString meth = new MethodWithMaybeString(handler -> {
      throw cause;
    });
    Maybe<String> single = meth.rxDoSomethingWithMaybeResult();
    single.subscribe(result -> fail(), err -> testComplete(), this::fail);
    await();
  }

  @Test
  public void testCompletableReportingSubscribeUncheckedException() {
    RuntimeException cause = new RuntimeException();
    MethodWithCompletable meth = new MethodWithCompletable(handler -> {
      throw cause;
    });
    Completable single = meth.rxDoSomethingWithResult();
    single.subscribe(this::fail, err -> testComplete());
    await();
  }
}
