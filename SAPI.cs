using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Data.SqlClient;

namespace RESTful_API
{
    public class SAPI : ISAPI
    {
        SqlConnection dbConnection;
        public SAPI()
        {
            dbConnection = DBConnect.getConnection();
        }
        public void CreateNewAccount(string name, string password, string email)
        {
            if (dbConnection.State.ToString() == "Closed")
            {
                dbConnection.Open();
            }

            string query = "INSERT INTO test(userid, name, password, email) SELECT 1 + MAX(userid), '" + name + "', '" + password + "', '" + email + "' FROM test";

            SqlCommand command = new SqlCommand(query, dbConnection);
            command.ExecuteNonQuery();

            dbConnection.Close();
        }
    }
}
