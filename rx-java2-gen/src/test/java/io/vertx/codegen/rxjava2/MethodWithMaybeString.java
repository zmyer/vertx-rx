package io.vertx.codegen.rxjava2;

import io.vertx.codegen.annotations.Nullable;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@VertxGen
public interface MethodWithMaybeString {
  void doSomethingWithMaybeResult(Handler<AsyncResult<@Nullable String>> handler);
}
