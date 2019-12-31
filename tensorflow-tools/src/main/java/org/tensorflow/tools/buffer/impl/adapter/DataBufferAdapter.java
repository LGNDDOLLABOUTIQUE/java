/*
 *  Copyright 2019 The TensorFlow Authors. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  =======================================================================
 */

package org.tensorflow.tools.buffer.impl.adapter;

import org.tensorflow.tools.buffer.ByteDataBuffer;
import org.tensorflow.tools.buffer.DataBuffer;
import org.tensorflow.tools.buffer.layout.DataLayout;

@SuppressWarnings("unchecked")
class DataBufferAdapter<T> extends AbstractDataBufferAdapter<T, DataBuffer<T>> {

  @Override
  public DataBuffer<T> offset(long index) {
    return new DataBufferAdapter<>(buffer().offset(index * layout().sizeInBytes()), layout());
  }

  @Override
  public DataBuffer<T> narrow(long size) {
    return new DataBufferAdapter<>(buffer().narrow(size * layout().sizeInBytes()), layout());
  }

  DataBufferAdapter(ByteDataBuffer physicalBuffer, DataLayout<T> layout) {
    super(physicalBuffer, layout);
  }
}
