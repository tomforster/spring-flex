/*
 * Copyright 2002-2010 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.flex.config;

import org.springframework.util.ClassUtils;

/**
 * Internal helper class to determine the type of runtime data services environment being used, to allow for
 * automatically adapting to the available capabilities.
 * 
 * @author Rohit Kumar
 * @author Jeremy Grelle
 */
public abstract class RuntimeEnvironment {

    private static final String ASYNC_MESSAGE_BROKER_CLASS_NAME = "flex.messaging.AsyncMessageBroker";

    private static final boolean IS_LCDS_ENVIRONMENT;

    static {
        boolean asyncMessageBrokerClassPresent;

        try {
            ClassUtils.forName(ASYNC_MESSAGE_BROKER_CLASS_NAME, null);
            asyncMessageBrokerClassPresent = true;
        } catch (ClassNotFoundException ex) {
            asyncMessageBrokerClassPresent = false;
        }

        IS_LCDS_ENVIRONMENT = asyncMessageBrokerClassPresent;
    }

    /**
     * Returns <code>true</code> if the runtime data services environment is LCDS.
     */
    public static boolean isLCDS() {
        return IS_LCDS_ENVIRONMENT;
    }

    /**
     * Returns <code>true</code> if the runtime data services environment is BlazeDS.
     */
    public static boolean isBlazeDS() {
        return !IS_LCDS_ENVIRONMENT;
    }

}