package io.vertx.reactivex.core;

import com.fasterxml.jackson.core.type.TypeReference;
import io.reactivex.SingleOperator;
import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.core.json.SingleUnmarshaller;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class SingleHelper {

  public static <T> SingleOperator<T, Buffer> unmarshaller(Class<T> mappedType) {
    return new SingleUnmarshaller<>(Buffer::getDelegate, mappedType);
  }

  public static <T> SingleOperator<T, Buffer> unmarshaller(TypeReference<T> mappedTypeRef) {
    return new SingleUnmarshaller<>(Buffer::getDelegate, mappedTypeRef);
  }
}
