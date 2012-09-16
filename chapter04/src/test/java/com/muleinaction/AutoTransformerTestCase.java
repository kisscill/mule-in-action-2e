
package com.muleinaction;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

import com.prancingdonkey.statistics.ActivityReport;

import org.junit.Test;

public class AutoTransformerTestCase extends FunctionalTestCase
{

    @Override
    protected String getConfigResources()
    {
        return "auto-transformer.xml";
    }

    @Test
    public void testAutoTransformer() throws Exception
    {
        MuleClient muleClient = new MuleClient(muleContext);

        String payload = "<ActivityReport><value1>a</value1><value2>b<value2></ActivityReport>";

        MuleMessage result = muleClient.send("vm://auto-transformer.in", payload, null);

        assertThat(result.getPayload(), is(instanceOf(ActivityReport.class)));
    }

}
