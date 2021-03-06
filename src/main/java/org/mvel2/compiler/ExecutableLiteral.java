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

import org.mvel2.ast.Safe;
import org.mvel2.integration.VariableResolverFactory;

/**
 * 表示一个常量的计算单元,表示其本身引用一个常量,并不需要额外进行计算和处理
 *
 * @author Christopher Brock
 */
public class ExecutableLiteral implements ExecutableStatement, Safe {
    /** 所引用的对象 */
    private Object literal;
    /** 内部所引用的整数 */
    private int integer32;
    /** 当前节点是否是整数的标记 */
    private boolean intOptimized;

    public ExecutableLiteral(Object literal) {
        if((this.literal = literal) instanceof Integer) this.integer32 = (Integer) literal;
    }

    public ExecutableLiteral(int literal) {
        this.literal = this.integer32 = literal;
        this.intOptimized = true;
    }

    public int getInteger32() {
        return integer32;
    }

    public void setInteger32(int integer32) {
        this.integer32 = integer32;
    }

    public Object getValue(Object staticContext, VariableResolverFactory factory) {
        return literal;
    }

    public void setKnownIngressType(Class type) {

    }

    public void setKnownEgressType(Class type) {

    }

    public Class getKnownIngressType() {
        return null;
    }

    public Class getKnownEgressType() {
        return this.literal == null ? Object.class : this.literal.getClass();
    }

    public boolean isConvertableIngressEgress() {
        return false;
    }

    public void computeTypeConversionRule() {

    }

    public Object getValue(Object ctx, Object elCtx, VariableResolverFactory variableFactory) {
        return literal;
    }


    public Object getLiteral() {
        return literal;
    }

    public boolean intOptimized() {
        return intOptimized;
    }


    public Object setValue(Object ctx, Object elCtx, VariableResolverFactory variableFactory, Object value) {
        // not implemented
        return null;
    }

    public boolean isLiteralOnly() {
        return true;
    }

    public boolean isEmptyStatement() {
        return false;
    }

    public boolean isExplicitCast() {
        return false;
    }

    @Override
    public String nodeExpr() {
        return String.valueOf(literal);
    }
}
