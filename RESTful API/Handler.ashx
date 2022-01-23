
<%@ WebHandler Language="C#" Class="Handler" %>

using System;
using System.Web;
using JsonServices;    
using JsonServices.Web;    
    
namespace RESTful_API
    
{    
    public class Handler: JsonHandler    
    {    
        public Handler()     
        {    
            this.service.Name = "RESTful_API";    
            this.service.Description = "JSON API for android appliation";    
            InterfaceConfiguration IConfig = new InterfaceConfiguration("RestAPI", typeof(ISAPI), typeof(SAPI));    
            this.service.Interfaces.Add(IConfig);    
        }    
    }    
}   