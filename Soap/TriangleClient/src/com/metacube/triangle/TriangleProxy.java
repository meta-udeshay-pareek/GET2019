package com.metacube.triangle;

public class TriangleProxy implements com.metacube.triangle.Triangle {
  private String _endpoint = null;
  private com.metacube.triangle.Triangle triangle = null;
  
  public TriangleProxy() {
    _initTriangleProxy();
  }
  
  public TriangleProxy(String endpoint) {
    _endpoint = endpoint;
    _initTriangleProxy();
  }
  
  private void _initTriangleProxy() {
    try {
      triangle = (new com.metacube.triangle.TriangleServiceLocator()).getTriangle();
      if (triangle != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)triangle)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)triangle)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (triangle != null)
      ((javax.xml.rpc.Stub)triangle)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.metacube.triangle.Triangle getTriangle() {
    if (triangle == null)
      _initTriangleProxy();
    return triangle;
  }
  
  public double getArea(int side1, int side2, int side3) throws java.rmi.RemoteException{
    if (triangle == null)
      _initTriangleProxy();
    return triangle.getArea(side1, side2, side3);
  }
  
  
}