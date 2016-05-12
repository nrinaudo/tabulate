/*
 * Copyright 2016 Nicolas Rinaudo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kantan.csv

import kantan.codecs.Result

object DecodeResult {
  def apply[A](a: ⇒ A): DecodeResult[A] = Result.nonFatal(a).leftMap(DecodeError.TypeError.apply)
  def outOfBounds(index: Int): DecodeResult[Nothing] = Result.failure(DecodeError.OutOfBounds(index))
  def success[A](a: A): DecodeResult[A] = Result.success(a)
  def typeError(str: String): DecodeResult[Nothing] = Result.failure(DecodeError.TypeError(str))
  def typeError(e: Exception): DecodeResult[Nothing] = Result.failure(DecodeError.TypeError(e))
}
