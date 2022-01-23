using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace RESTful_API
{
    public interface ISAPI
    {
        void CreateNewAccount(string name, string password, string email);

    }
}
