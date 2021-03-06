/**
 * MVEL 2.0
 * Copyright (C) 2007 The Codehaus
 * Mike Brock, Dhanji Prasanna, John Graham, Mark Proctor
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mvel2.compiler;

import java.io.Serializable;
import java.util.Collection;

import static java.lang.String.valueOf;
import static java.lang.reflect.Array.getLength;
import static org.mvel2.util.ParseTools.isNumeric;

/** 表示一个特别的空常量,主要用于与internalNumber进行协作,以表示内部的一个特殊的空值 */
public class BlankLiteral implements Serializable {
    public static final BlankLiteral INSTANCE = new BlankLiteral();

    public BlankLiteral() {
    }

    public boolean equals(Object obj) {
        if(obj == null || valueOf(obj).trim().length() == 0) {
            return true;
        }
        if(isNumeric(obj)) {
            return "0".equals(valueOf(obj));
        }
        if(obj instanceof Collection) {
            return ((Collection) obj).size() == 0;
        }
        if(obj.getClass().isArray()) {
            return getLength(obj) == 0;
        }
        if(obj instanceof Boolean) {
            return !(Boolean) obj;
        }
        return false;
    }

    public String toString() {
        return "";
    }
}
