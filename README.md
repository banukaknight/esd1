# ESDAssignment
DOCUMENTATION:
  DBBean:
  Replace database name, username and password in DBBean to allow connection to your own db.
  Set up the db with the sql commands provided with the assignment.
  Syntax to use the Bean:
    DBBean n = new DBBean("dbname", "dbusername", "dbpassword");
    ArrayList<Claim> claims = n.getClaims();
    for(Claim c : claims)
      System.out.println(c.toString());
