package com.googlecode.gwtquake.client;

import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;

public class ArrayUtils {

  // TODO(jgw): Get rid of these conversions in web mode.
  public static JsArrayInteger toJsArray(Byte[] data) {
    JsArrayInteger jsan = (JsArrayInteger) JsArrayInteger.createArray();
    int len = data.length;
    for (int i = len - 1; i >= 0; i--) {
      jsan.set(i, data[i]);
    }
    return jsan;
  }

  public static JsArrayNumber toJsArray(Double[] data) {
    JsArrayNumber jsan = (JsArrayNumber) JsArrayNumber.createArray();
    int len = data.length;
    for (int i = len - 1; i >= 0; i--) {
      jsan.set(i, data[i]);
    }
    return jsan;
  }

  public static JsArrayNumber toJsArray(Float[] data) {
    JsArrayNumber jsan = (JsArrayNumber) JsArrayNumber.createArray();
    int len = data.length;
    for (int i = len - 1; i >= 0; i--) {
      jsan.set(i, data[i]);
    }
    return jsan;
  }

  public static JsArrayInteger toJsArray(Integer[] data) {
    JsArrayInteger jsan = (JsArrayInteger) JsArrayNumber.createArray();
    int len = data.length;
    for (int i = len - 1; i >= 0; i--) {
      jsan.set(i, data[i]);
    }
    return jsan;
  }

  public static JsArrayInteger toJsArray(short[] data) {
    JsArrayInteger jsan = (JsArrayInteger) JsArrayInteger.createArray();
    int len = data.length;
    for (int i = len - 1; i >= 0; i--) {
      jsan.set(i, data[i]);
    }
    return jsan;
  }

  public static JsArrayInteger toJsArrayUnsigned(byte[] data) {
    JsArrayInteger jsan = (JsArrayInteger) JsArrayInteger.createArray();
    int len = data.length;
    for (int i = len - 1; i >= 0; i--) {
      jsan.set(i, data[i] & 255);
    }
    return jsan;
  }

  public static JsArrayInteger toJsArrayUnsigned(short[] data) {
    JsArrayInteger jsan = (JsArrayInteger) JsArrayInteger.createArray();
    int len = data.length;
    for (int i = len - 1; i >= 0; i--) {
      jsan.set(i, data[i] & 65535);
    }
    return jsan;
  }

  private ArrayUtils() {
  }
}
