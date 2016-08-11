/*
 * Copyright © 2016 N/A and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.impl;

import org.apache.http.client.fluent.Request;

public class NotReferenced {
    private void notCalled() {
        Request.Get("http://google.com");
    }
}
