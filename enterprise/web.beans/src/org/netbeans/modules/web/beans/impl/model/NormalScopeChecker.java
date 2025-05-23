/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.web.beans.impl.model;

import java.util.List;

import static org.netbeans.modules.web.beans.analysis.analyzer.AnnotationUtil.NORMAL_SCOPE_FQN;
import static org.netbeans.modules.web.beans.analysis.analyzer.AnnotationUtil.NORMAL_SCOPE_FQN_JAKARTA;


/**
 * @author ads
 *
 */
class NormalScopeChecker extends ScopeChecker {

    private static final List<String> ANNOTATIONS = List.of(
            NORMAL_SCOPE_FQN, NORMAL_SCOPE_FQN_JAKARTA
    );

    static NormalScopeChecker get(){
        return  new NormalScopeChecker();
    }
    
    /* (non-Javadoc)
     * @see org.netbeans.modules.web.beans.impl.model.ScopeChecker#getAnnotation()
     */
    @Override
    protected List<String> getAnnotation() {
        return ANNOTATIONS;
    }

}
