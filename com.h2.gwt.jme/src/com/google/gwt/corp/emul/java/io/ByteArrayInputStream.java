/*
 * Copyright 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package java.io;

public class ByteArrayInputStream extends InputStream {

  byte[] data;
  int pos = 0;
  int count;
  
  public ByteArrayInputStream(byte[] data) {
    this.data = data;
    count = data.length;
  }
  
  public ByteArrayInputStream(byte[] data, int offset, int length) {
    this.data = data;
    pos = offset;
    count = length;
  }
  
  @Override
  public int read()  {
    return pos < count ? data[pos++] : -1;
  }

}
