package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.params.HttpProtocolParams;











































@Immutable
public class RequestExpectContinue
  implements HttpRequestInterceptor
{
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    if (request == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if ((request instanceof HttpEntityEnclosingRequest)) {
      HttpEntity entity = ((HttpEntityEnclosingRequest)request).getEntity();
      
      if ((entity != null) && (entity.getContentLength() != 0L)) {
        ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
        if ((HttpProtocolParams.useExpectContinue(request.getParams())) && (!ver.lessEquals(HttpVersion.HTTP_1_0)))
        {
          request.addHeader("Expect", "100-continue");
        }
      }
    }
  }
}
