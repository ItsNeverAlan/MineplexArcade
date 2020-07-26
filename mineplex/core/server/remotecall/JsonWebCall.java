package mineplex.core.server.remotecall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Type;
import mineplex.core.common.util.Callback;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.bukkit.craftbukkit.libs.com.google.gson.Gson;

public class JsonWebCall
{
  private String _url;
  private PoolingClientConnectionManager _connectionManager;
  
  public JsonWebCall(String url)
  {
    this._url = url;
    
    SchemeRegistry schemeRegistry = new SchemeRegistry();
    schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
    
    this._connectionManager = new PoolingClientConnectionManager(schemeRegistry);
    this._connectionManager.setMaxTotal(200);
    this._connectionManager.setDefaultMaxPerRoute(20);
  }
  
  public String ExecuteReturnStream(Object argument)
  {
    HttpClient httpClient = new DefaultHttpClient(this._connectionManager);
    InputStream in = null;
    String result = null;
    


    try
    {
      Gson gson = new Gson();
      request = new HttpPost(this._url);
      
      if (argument != null)
      {
        params = new StringEntity(gson.toJson(argument));
        params.setContentType(new BasicHeader("Content-Type", "application/json"));
        request.setEntity(params);
      }
      
      HttpResponse response = httpClient.execute(request);
      
      if (response != null)
      {
        in = response.getEntity().getContent();
        result = convertStreamToString(in);
      }
    }
    catch (Exception ex)
    {
      System.out.println("Error executing JsonWebCall: \n" + ex.getMessage());
      System.out.println("Result: \n" + result);
      StackTraceElement[] arrayOfStackTraceElement;
      StringEntity params = (arrayOfStackTraceElement = ex.getStackTrace()).length; for (HttpPost request = 0; request < params; request++) { StackTraceElement trace = arrayOfStackTraceElement[request];
        
        System.out.println(trace);
      }
      


      httpClient.getConnectionManager().shutdown();
      
      if (in != null)
      {
        try
        {
          in.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    finally
    {
      httpClient.getConnectionManager().shutdown();
      
      if (in != null)
      {
        try
        {
          in.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    
    return result;
  }
  
  public void Execute()
  {
    Execute(null);
  }
  
  public void Execute(Object argument)
  {
    HttpClient httpClient = new DefaultHttpClient(this._connectionManager);
    InputStream in = null;
    
    try
    {
      Gson gson = new Gson();
      HttpPost request = new HttpPost(this._url);
      
      if (argument != null)
      {
        params = new StringEntity(gson.toJson(argument));
        params.setContentType(new BasicHeader("Content-Type", "application/json"));
        request.setEntity(params);
      }
      
      httpClient.execute(request);
    }
    catch (Exception ex)
    {
      System.out.println("JsonWebCall.Execute() Error:\n" + ex.getMessage());
      StackTraceElement[] arrayOfStackTraceElement;
      StringEntity localStringEntity1 = (arrayOfStackTraceElement = ex.getStackTrace()).length; for (StringEntity params = 0; params < localStringEntity1; params++) { StackTraceElement trace = arrayOfStackTraceElement[params];
        
        System.out.println(trace);
      }
      


      httpClient.getConnectionManager().shutdown();
      
      if (in != null)
      {
        try
        {
          in.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    finally
    {
      httpClient.getConnectionManager().shutdown();
      
      if (in != null)
      {
        try
        {
          in.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
  
  public <T> T Execute(Class<T> returnClass)
  {
    return Execute(returnClass, null);
  }
  
  public <T> T Execute(Type returnType, Object argument)
  {
    HttpClient httpClient = new DefaultHttpClient(this._connectionManager);
    InputStream in = null;
    T returnData = null;
    String result = null;
    


    try
    {
      Gson gson = new Gson();
      request = new HttpPost(this._url);
      
      if (argument != null)
      {
        params = new StringEntity(gson.toJson(argument));
        params.setContentType(new BasicHeader("Content-Type", "application/json"));
        request.setEntity(params);
      }
      
      HttpResponse response = httpClient.execute(request);
      
      if (response != null)
      {
        in = response.getEntity().getContent();
        
        result = convertStreamToString(in);
        returnData = new Gson().fromJson(result, returnType);
      }
    }
    catch (Exception ex)
    {
      System.out.println("Error executing JsonWebCall: \n" + ex.getMessage());
      System.out.println("Result: \n" + result);
      StackTraceElement[] arrayOfStackTraceElement;
      StringEntity params = (arrayOfStackTraceElement = ex.getStackTrace()).length; for (HttpPost request = 0; request < params; request++) { StackTraceElement trace = arrayOfStackTraceElement[request];
        
        System.out.println(trace);
      }
      


      httpClient.getConnectionManager().shutdown();
      
      if (in != null)
      {
        try
        {
          in.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    finally
    {
      httpClient.getConnectionManager().shutdown();
      
      if (in != null)
      {
        try
        {
          in.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    
    return returnData;
  }
  
  public <T> T Execute(Class<T> returnClass, Object argument)
  {
    HttpClient httpClient = new DefaultHttpClient(this._connectionManager);
    InputStream in = null;
    T returnData = null;
    String result = null;
    


    try
    {
      Gson gson = new Gson();
      request = new HttpPost(this._url);
      
      if (argument != null)
      {
        params = new StringEntity(gson.toJson(argument));
        params.setContentType(new BasicHeader("Content-Type", "application/json"));
        request.setEntity(params);
      }
      
      HttpResponse response = httpClient.execute(request);
      
      if (response != null)
      {
        in = response.getEntity().getContent();
        
        result = convertStreamToString(in);
        returnData = new Gson().fromJson(result, returnClass);
      }
    }
    catch (Exception ex)
    {
      System.out.println("Error executing JsonWebCall: \n" + ex.getMessage());
      System.out.println("Result: \n" + result);
      StackTraceElement[] arrayOfStackTraceElement;
      StringEntity params = (arrayOfStackTraceElement = ex.getStackTrace()).length; for (HttpPost request = 0; request < params; request++) { StackTraceElement trace = arrayOfStackTraceElement[request];
        
        System.out.println(trace);
      }
      


      httpClient.getConnectionManager().shutdown();
      
      if (in != null)
      {
        try
        {
          in.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    finally
    {
      httpClient.getConnectionManager().shutdown();
      
      if (in != null)
      {
        try
        {
          in.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    
    return returnData;
  }
  
  public <T> void Execute(Class<T> callbackClass, Callback<T> callback)
  {
    Execute(callbackClass, callback, null);
  }
  
  public <T> void Execute(Class<T> callbackClass, Callback<T> callback, Object argument)
  {
    HttpClient httpClient = new DefaultHttpClient(this._connectionManager);
    InputStream in = null;
    String result = null;
    


    try
    {
      Gson gson = new Gson();
      HttpPost request = new HttpPost(this._url);
      
      if (argument != null)
      {
        StringEntity params = new StringEntity(gson.toJson(argument));
        params.setContentType(new BasicHeader("Content-Type", "application/json"));
        request.setEntity(params);
      }
      
      HttpResponse response = httpClient.execute(request);
      
      if ((response != null) && (callback != null))
      {
        in = response.getEntity().getContent();
        
        result = convertStreamToString(in);
        callback.run(new Gson().fromJson(result, callbackClass));
      }
    }
    catch (Exception ex)
    {
      System.out.println("Error executing JsonWebCall: \n" + ex.getMessage());
      System.out.println("Result: \n" + result);
      


      httpClient.getConnectionManager().shutdown();
      
      if (in != null)
      {
        try
        {
          in.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    finally
    {
      httpClient.getConnectionManager().shutdown();
      
      if (in != null)
      {
        try
        {
          in.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
  
  protected String convertStreamToString(InputStream is)
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();
    
    String line = null;
    try {
      while ((line = reader.readLine()) != null) {
        sb.append(line + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
      try
      {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    finally
    {
      try
      {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return sb.toString();
  }
}
