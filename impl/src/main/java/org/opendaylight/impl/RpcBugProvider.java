/*
 * Copyright © 2016 N/A and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.impl;

import java.util.concurrent.Future;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpc.bug.rev150105.NoopInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpc.bug.rev150105.NoopOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpc.bug.rev150105.RpcBugService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpcBugProvider {

    private static final Logger LOG = LoggerFactory.getLogger(RpcBugProvider.class);

    private final DataBroker dataBroker;

    public RpcBugProvider(final DataBroker dataBroker, final RpcProviderRegistry rpcProviderRegistry) {
        this.dataBroker = dataBroker;

        rpcProviderRegistry.addRpcImplementation(RpcBugService.class, new RpcBugService() {
            @Override
            public Future<RpcResult<NoopOutput>> noop(NoopInput input) {

                return RpcResultBuilder.<NoopOutput>success().buildFuture();
            }
        });
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("RpcBugProvider Session Initiated");
    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {
        LOG.info("RpcBugProvider Closed");
    }
}